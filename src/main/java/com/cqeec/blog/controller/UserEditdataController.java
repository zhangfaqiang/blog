package com.cqeec.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cqeec.blog.entity.SystemUser;
import com.cqeec.blog.service.UserEditdataService;

@Controller
public class UserEditdataController {
	@Autowired
	private UserEditdataService userEditdataService;
	@ResponseBody
	@RequestMapping(value = "/user/editdata", method = RequestMethod.POST)
	public ModelAndView edit(RedirectAttributes model, HttpSession session,
			String id, String nickname, String netname, String address,
			String occupation, String password) {
		ModelAndView mav = new ModelAndView();
		userEditdataService.editData(id, nickname, netname, address,
				occupation, password);
		// 判断修改信息时是否有更改密码
		List<SystemUser> user = userEditdataService.checkPwdUpdate();
		String pwd = session.getAttribute("password").toString();
		for (SystemUser i : user) {
			if (!i.getPassword().equals(pwd)) {
				mav.addObject("message", "密码已更改，重新登陆");
				mav.setViewName("login");
			}else{
				session.setAttribute("nickname", nickname);
				session.setAttribute("netname", netname);
				session.setAttribute("address", address);
				session.setAttribute("nickname", nickname);
				session.setAttribute("occupation", occupation);
				model.addFlashAttribute("updateMessage", "修改成功");

				mav.setViewName("redirect:/user/main");
			}
			
		}
		return mav;
	}

	@RequestMapping("user/article")
	public String gotoEditArticle() {
		return "editArticle";
	}

	
//	@ResponseBody
//	@RequestMapping("/user/checkPwdIsUpdate")
//	public ModelAndView checkPwdIsUpdate(HttpSession session) {
//		ModelAndView mav = new ModelAndView();
//		List<SystemUser> user = userEditdataService.checkPwdUpdate();
//		String password = session.getAttribute("password").toString();
//		for (SystemUser i : user) {
//			if (!i.getPassword().equals(password)) {
//				mav.addObject("message", "密码已更改，重新登陆");
//				mav.setViewName("login");
//			}
//			
//		}
//		return mav;
//	}
}
