package com.cqeec.blog.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {
	// 上传图片
	@ResponseBody
	@RequestMapping("/user/upload/photo")
	public Map<String, Object> upload(MultipartFile img, HttpSession session,
			HttpServletRequest req) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取用户得id
		String userid = session.getAttribute("userid").toString();
		//获取到服务器的地址
		String path1 = session.getServletContext().getRealPath(userid);
		System.out.println(path1);
		File file1 = new File(path1);
		file1.mkdirs();
		if (file1.isDirectory()) {
			System.out.println("file1是目录" + file1);
		} else {
			System.out.println("file1是文件" + file1);
		}
		// 如果没有文件上传，MultipartFile也不会为null，可以通过调用getSize()方法获取文件的大小来判断是否有上传文件
		if (img.getSize() > 0) {
			// 得到项目在服务器的真实根路径，如：/home/tomcat/webapp/项目名/images
			String path = session.getServletContext().getRealPath(userid);
			// 得到文件的原始名称，如：美女.png
			String fileName = userid + ".jpg";
			// 通过文件的原始名称，可以对上传文件类型做限制，如：只能上传jpg和png的图片文件
			if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
				File file = new File(path, fileName);
				if (file.exists()) {
					file.delete();
				}
				img.transferTo(file);
				map.put("photomessage", req.getContextPath() + "/" + userid
						+ "/" + fileName);
				map.put("success", "上传成功");
				return map;
			}else{
				map.put("photomessage", "上传失败");
			}
		}
		map.put("photomessage", "上传失败");
		return map;
	}

}
