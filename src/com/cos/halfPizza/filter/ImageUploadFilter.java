package com.cos.halfPizza.filter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ImageUploadFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String contentType = null;
		if(req.getContentType() != null) {
			contentType = (req.getContentType()).split(";")[0];
		}
		
		if(contentType != null && contentType.equals("multipart/form-data")) {
			String endPoint = req.getRequestURI().replaceAll(req.getContextPath(), "");
			int maxSize = 1024 * 1024 * 10;	//10M
			String path = "";
			if(endPoint.equals("/admin/menu/registProc")) {
				path = "/images/menu/";
			}
			else if(endPoint.equals("/admin/event/registProc")) {
				path = "/images/event/";
			}
			else if(endPoint.equals("/admin/event/updateProc")) {
				path = "/images/event/";
			}
			String uploadPath = req.getSession().getServletContext().getRealPath(path);
			System.out.println("업로드 패스: "+uploadPath);
			try {
				MultipartRequest multi = new MultipartRequest(req, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
				String gubun = multi.getParameter("gubun");
				
				Enumeration<?> params = multi.getParameterNames();
				while(params.hasMoreElements()) {
					String param = (String)params.nextElement();
					req.setAttribute(param, multi.getParameter(param));
				}
				
				Enumeration<?> files = multi.getFileNames();
		        String file = (String)files.nextElement();
		        String fileName = multi.getFilesystemName(file);
		        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		        Calendar time = Calendar.getInstance();   
		        String type = (multi.getContentType(file)).split("/")[1]; 
		        String newFileName = gubun + "_" + format.format(time.getTime()) + '.' + type;
		        File oldFile = new File(uploadPath + fileName);
		        File newFile = new File(uploadPath + newFileName);
		        oldFile.renameTo(newFile); 
		        req.setAttribute("originFileName", fileName);
		        req.setAttribute("changeFileName", newFileName);
		        req.setAttribute("path", path);
		        
			} catch (Exception e) {
				Script.back(resp, "파일의 크기가 너무 큽니다.");
			}
		
		}
		
		chain.doFilter(req, resp);
	}

}
