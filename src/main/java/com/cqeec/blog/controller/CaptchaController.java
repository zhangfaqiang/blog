package com.cqeec.blog.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CaptchaController {
	private static final String CAPTCHA = "0123456789";

	@RequestMapping("/captcha.html")
	public void generate(HttpServletResponse response, HttpSession session) {
		// 生成验证码
		String code = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			code += CAPTCHA.charAt(random.nextInt(CAPTCHA.length()));
		}
		// 保存验证码到session
		session.setAttribute("captcha", code);
		// 生成图片
		int width = 85, height = 20;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 28));
		for (int i = 0, x = 6; i < code.length(); i++, x += 20) {
			g.drawString(code.charAt(i) + "", x, 20);
		}
		// 响应设置
		response.setHeader("Content-Type", "image/jpeg");
		response.setHeader("Pragram", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 输出到客户端
		ServletOutputStream out;
		try {
			out = response.getOutputStream();
			ImageIO.write(bi, "JPEG", out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
