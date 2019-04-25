package com.cqeec.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqeec.blog.entity.Article;
import com.cqeec.blog.service.ShowArticleService;

@Controller
public class ShowArticleController {
	@Autowired
	private ShowArticleService showArticleService;

	@ResponseBody
	@RequestMapping(value = "/user/showArticle", method = RequestMethod.POST)
	public List<Article> showArticleByuid(HttpSession session) {
		String uid = session.getAttribute("userid").toString();
		
		List<Article> result = showArticleService.showArticle(uid);
			session.setAttribute("articleResult", result);
		return result;

	}
}
