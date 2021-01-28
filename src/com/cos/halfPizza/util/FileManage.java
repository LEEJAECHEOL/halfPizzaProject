package com.cos.halfPizza.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class FileManage {
	public static void deleteFile(String path, String fileName, HttpServletRequest req) {
		File file = new File(req.getSession().getServletContext().getRealPath(path) + fileName);
		if(file.exists()) {
			file.delete();
		}
	}
}
