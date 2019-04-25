package com.cqeec.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cqeec.blog.entity.Article;
import com.cqeec.blog.entity.SystemUser;
import com.cqeec.blog.service.ShowArticleService;
import com.cqeec.blog.service.UserLoginService;

/**
 * Created by XRog On 2/1/2017.12:36 AM
 */
@Controller
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private ShowArticleService showArticleService;

	@RequestMapping("/login")
	public String gotologin() {
		// 实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
		return "login";
	}

	@RequestMapping("/user/main")
	public String gotoMain() {
		return "main";
	}

	@RequestMapping("/user/login")
	public ModelAndView login(RedirectAttributes redirect ,HttpSession session, String userName,
			String userPassword, String captcha) {
		ModelAndView mav = new ModelAndView();
		// 用户名
		if (userName == null || "".equals(userName)) {
			mav.addObject("message", "请输入用户名！");
			mav.setViewName("login");
			return mav;
		}
		// 密码
		if (userPassword == null || "".equals(userPassword)) {
			mav.addObject("message", "请输入用户密码！");
			mav.addObject("userName", userName);
			mav.setViewName("login");
			return mav;
		}
		// 验证验证码
		if (captcha == null || "".equals(captcha)) {
			mav.addObject("message", "请输入验证码！");
			mav.addObject("userName", userName);
			mav.setViewName("login");
			return mav;
		}
		String code = (String) session.getAttribute("captcha");
		if (captcha.equals(code)) {
			SystemUser user = userLoginService.findSystemUser(userName,
					userPassword);
			if (user == null) {
				mav.addObject("message", "用户名或密码错误");
				mav.addObject("userName", userName);
				mav.setViewName("login");
			} else {
				session.setAttribute("user", user);
				session.setAttribute("userid", user.getId());
				session.setAttribute("userName", user.getUsername());
				session.setAttribute("nickname", user.getNickname());
				session.setAttribute("netname", user.getNetname());
				session.setAttribute("address", user.getAddress());
				session.setAttribute("occupation", user.getOccupation());
				session.setAttribute("password", user.getPassword());
				// String uid = session.getAttribute("userid").toString();
				// List<Article> result = showArticleService.showArticle(uid);
				// mav.addObject("result",result);
				
				List<Article> result = showArticleService.showArticle(user
						.getId());
				session.setAttribute("articleResult", result);
				//redirect.addFlashAttribute("articleResult", result);
			//	mav.addObject("articleResult", result);
				
				mav.setViewName("redirect:/user/main");
			}
		} else {
			// 验证码错误
			mav.addObject("message", "验证码错误！");
			mav.addObject("userName", userName);
			mav.setViewName("login");
		}
		return mav;

	}

	@RequestMapping("/user/exit")
	public String gotoExit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/login";
	}
}