package com.zym.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zym.utils.RenameFileUtils;

@RequestMapping("file")
@Controller
public class FileController extends BaseController {

	@RequestMapping("/test")
	public String login() {
		return "fileupload";
	}
	/**
	 * 文件上传功能
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
		if (!file.isEmpty()) {
			String path = "D:/321";
			String fileName = file.getOriginalFilename();
			
			File dir = new File(path, RenameFileUtils.renameFileName(fileName));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			file.transferTo(dir);
		}
		return "Welcome";
	}

}