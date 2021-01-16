package com.cos.halfPizza.filter;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;


public class Dispatcher implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String endPoint = req.getRequestURI().replaceAll(req.getContextPath(), "");
//		System.out.println("엔드포인트 : " + endPoint);
		
		if(exclusionUri(endPoint)) {
			chain.doFilter(request, response);
			return;
		} 
		
		
		List<Class> controllerList = componentScan();
//		System.out.println("ControllerList : " + controllerList);
		for (Class controller : controllerList) {
			Annotation[] controllerAnnotations = controller.getAnnotations();
			for (Annotation controllerAnnotation : controllerAnnotations) {
//				System.out.println("ControllerAnnotation : " + controllerAnnotation);
				if(controllerAnnotation instanceof Controller) {
					try {
						Object controllerInstance = controller.getDeclaredConstructor().newInstance();
						Method[] methods = controller.getDeclaredMethods();
						
						for (Method method : methods) {
							Annotation annotation = method.getDeclaredAnnotation(RequestMapping.class);
							RequestMapping requestMapping = (RequestMapping) annotation;
//							System.out.println("requestMapping value() : " + requestMapping.value());
							if(requestMapping.value().equals(endPoint)) {
								Parameter[] params = method.getParameters();
								
								String path;
								if (params.length != 0) {
									Object[] callParameter = new Object[params.length];
									
									for(int i = 0; i < params.length; i++) {
										String paramName = params[i].getType().getSimpleName();
										if(paramName.equals("HttpSession")) {
											callParameter[i] = req.getSession();
										}else if(paramName.equals("HttpServletRequest")) {
											callParameter[i] = req;
										}else if(paramName.equals("HttpServletResponse")) {
											callParameter[i] = resp;
										}else {
											Object dtoInstance = params[0].getType().getDeclaredConstructor().newInstance();
											setData(dtoInstance, request);
											callParameter[i] = dtoInstance;
										}
									}
//									System.out.println(callParameter[1].getClass().getName());
									path = (String) method.invoke(controllerInstance, callParameter);
								} else {
									path = (String) method.invoke(controllerInstance);
								}
								RequestDispatcher dis = request.getRequestDispatcher(path);
								dis.forward(request, response);
								
								break;
							}
						}	// methods end
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} // controllerAnnotations end

		} // controllerList end
		
//		chain.doFilter(request, response);
		
	}
	
	private boolean exclusionUri(String endPoint) {
		String[] exclusions  = { "/js", "/css", "/font", "/images"};
		if(endPoint.length() == 1){
			return true;
		}
		for (String exclusion : exclusions) {
			if(endPoint.contains(exclusion)) {
				return true;
			}
		}
		return false;
	}
	
	private String keyToMethodKey(String key) {
		String firstkey = key.substring(0, 1);
		String remainKey = key.substring(1);
		return "set" + firstkey.toUpperCase() + remainKey;
	}

	private <T> void setData(T dtoInstance, ServletRequest request) {
//		System.out.println("인스턴스 타입 : " + dtoInstance.getClass());
		Enumeration<String> params = request.getParameterNames();

		while (params.hasMoreElements()) {
			String key = (String) params.nextElement();
			String methodKey = keyToMethodKey(key);

			Method[] methods = dtoInstance.getClass().getMethods();
			for (Method m : methods) {
				if (m.getName().equals(methodKey)) {
					try {
						m.invoke(dtoInstance, request.getParameter(key));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private List<Class> componentScan() {
		List<Class> controllerList = new ArrayList<>();
		String packageName = "com.cos.halfPizza.web";
		String packageNameSlash = "./" + packageName.replace(".", "/");
		URL directoryURL = Thread.currentThread().getContextClassLoader().getResource(packageNameSlash);
		
//		System.out.println("directoryURL" + directoryURL);
		
		if (directoryURL == null) {
			System.err.println("Could not retrive URL resource : "+ packageNameSlash);
		}
		
		String directoryString = directoryURL.getFile();
		
		if (directoryString == null) {
			System.err.println("Could not find directory for URL resource : "+ packageNameSlash);
		}

		File directory = new File(directoryString);
		if (directory.exists()) {

			String[] files = directory.list();
			for (String fileName : files) {
				if (fileName.endsWith(".class")) {
					fileName = fileName.replace(".class", "");
					try {
						Class temp = Class.forName(packageName + '.' + fileName);
						controllerList.add(temp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return controllerList;
	}

}
