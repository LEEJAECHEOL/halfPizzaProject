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
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.util.Script;
import com.oreilly.servlet.MultipartRequest;


public class Dispatcher implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String endPoint = req.getRequestURI().replaceAll(req.getContextPath(), "");
//		System.out.println("엔드포인트 : " + endPoint);
		
		if(exclusionUri(endPoint, resp)) {
			chain.doFilter(request, response);
			return;
		} 
		
		List<Class> controllerList = componentScan();
//		System.out.println("ControllerList : " + controllerList);
		for (Class controller : controllerList) {
			Annotation[] controllerAnnotations = controller.getAnnotations();
			for (Annotation controllerAnnotation : controllerAnnotations) {
//				System.out.println("ControllerAnnotation : " + controllerAnnotation);
				if(controllerAnnotation instanceof Controller || controllerAnnotation instanceof Controller) {
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
										}else if(paramName.equals("MultipartRequest")){
											callParameter[i] = req;
										}else {
											Object dtoInstance = params[i].getType().getDeclaredConstructor().newInstance();
											setData(dtoInstance, request);
											callParameter[i] = dtoInstance;
										}
									}
									path = (String) method.invoke(controllerInstance, callParameter);
								} else {
									path = (String) method.invoke(controllerInstance);
								}
								System.out.println(path);
								if(path == null) {
									break;
								}
								RequestDispatcher dis = request.getRequestDispatcher(path);
								dis.forward(req, resp);
								
								break;
							}
						}	// methods end
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(controllerAnnotation instanceof RestController) {
					try {
						Object controllerInstance = controller.getDeclaredConstructor().newInstance();
						Method[] methods = controller.getDeclaredMethods();
						
						for (Method method : methods) {
							Annotation annotation = method.getDeclaredAnnotation(RequestMapping.class);
							RequestMapping requestMapping = (RequestMapping) annotation;
							
							if(requestMapping.value().equals(endPoint)) {
								Parameter[] params = method.getParameters();
								String data;
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
										}else if(paramName.equals("MultipartRequest")){
											callParameter[i] = req;
										}else {
											Object dtoInstance = params[i].getType().getDeclaredConstructor().newInstance();
											setData(dtoInstance, request);
											callParameter[i] = dtoInstance;
										}
									}
									data = (String)method.invoke(controllerInstance, callParameter);
								} else {
									data = (String)method.invoke(controllerInstance);
								}
								Script.responseData(resp, data);
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
	
	private boolean exclusionUri(String endPoint, HttpServletResponse resp) {
		String[] exclusions  = { "/js", "/css", "/font", "/images", "/index.jsp"};
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
		String contentType = "";
		if(request.getContentType() != null) {
			contentType = (request.getContentType()).split(";")[0];
		}
//		System.out.println("setData() : " + contentType);
		Enumeration<String> params = null;
		if(contentType.equals("multipart/form-data")) {
			params = request.getAttributeNames();
		}else {
			params = request.getParameterNames();
		}
		while (params.hasMoreElements()) {
			String key = (String) params.nextElement();
			String methodKey = keyToMethodKey(key);

			Method[] methods = dtoInstance.getClass().getMethods();
			for (Method m : methods) {
				if (m.getName().equals(methodKey)) {
					try {
						if(contentType.equals("multipart/form-data")) {
							m.invoke(dtoInstance, request.getAttribute(key));
							request.removeAttribute(key);
						}else {
							m.invoke(dtoInstance, request.getParameter(key));
						}								
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
