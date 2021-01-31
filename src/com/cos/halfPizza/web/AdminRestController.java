package com.cos.halfPizza.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.util.Script;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@RestController
public class AdminRestController {

	@RequestMapping("/summer/fileupload")
	public String fileUpload(HttpServletRequest req) {
		int maxSize = 1024 * 1024 * 10;	//10M
		String path = "/images/notice/";
		String uploadPath = req.getSession().getServletContext().getRealPath(path);
		
		try {
			MultipartRequest multi = new MultipartRequest(req, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<?> files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String file = (String)files.nextElement();
				String fileName = multi.getFilesystemName(file);
				SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SS");
				String type = (multi.getContentType(file)).split("/")[1];
				String newFileName = "notice_" + format.format(new Date())+ '_' + Script.getrndnum(10) + '.' + type;
				File oldFile = new File(uploadPath + fileName);
		        File newFile = new File(uploadPath + newFileName);
		        oldFile.renameTo(newFile);
				String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + path + newFileName;
				JsonObject jsonobject = new JsonObject();
		        jsonobject.addProperty("uploaded", true);
		        jsonobject.addProperty("url", url);
		        return jsonobject.toString();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
