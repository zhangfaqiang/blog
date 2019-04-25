package com.cqeec.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqeec.blog.entity.SystemUser;
import com.cqeec.blog.service.UserRegisterService;

@Controller
public class UserRegisterController {
	@Autowired
	private UserRegisterService registerService;
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/user/register")
	public ModelAndView gotoRegister(SystemUser systemuser) {
		ModelAndView model = new ModelAndView();
		if(systemuser.getUsername()==null||!systemuser.getUsername().equals("")&&systemuser.getNickname()==null||!systemuser.getNickname().equals("")&&systemuser.getPassword()==null||!systemuser.getPassword().equals("")&&systemuser.getPassword2()==null||!systemuser.getPassword2().equals("")){
			model.addObject("message", "注册成功！");
			registerService.addUser(systemuser);
			model.setViewName("register");
		}else{
			model.addObject("message", "注册失败！");
			model.setViewName("register");
		}
		return model;
	}
}
