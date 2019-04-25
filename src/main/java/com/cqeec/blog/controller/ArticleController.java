package com.cqeec.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqeec.blog.entity.Article;
import com.cqeec.blog.service.BaoCunArticleService;
import com.cqeec.blog.service.DeleteArticleService;
import com.cqeec.blog.service.UpdateArticleFenleiService;

@Controller
public class ArticleController {
	@Autowired
	private BaoCunArticleService baoCunArticleService;
	@Autowired
	private DeleteArticleService deleteArticleService;
	@Autowired
	private UpdateArticleFenleiService updateArticleFenleiService; 
	//返回JSON的格式
	//保存文章
	@ResponseBody
	@RequestMapping("user/baocunarticle")
	public Map<String,Object> baoCunArticle(Article article) {
		Map<String,Object> map=new HashMap<String,Object>();
		try{
		 baoCunArticleService.insertAriticle(article);
		map.put("code", "保存成功");}
		catch (Exception e){
			e.printStackTrace();
			map.put("code", "保存失败");
		}
		return map;
	}
	//删除文章
	@ResponseBody
	@RequestMapping("/user/deleteArticle")
	public Map<String,Object> deleteArticle(String id){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
		deleteArticleService.deleteArticleByid(id);
		map.put("message","删除成功");
		}catch(Exception e){
			e.printStackTrace();
			map.put("message", "删除失败");
		}
		return map;
	}
	//修改文章分类
	@ResponseBody
	@RequestMapping("user/updateFenLei")
	public Map<String,Object> updateFenLei(String fenlei ,String id){
		
		Map<String,Object> map=new HashMap<String,Object>();
		try{
		updateArticleFenleiService.updateFenLei(fenlei,id);
		map.put("message", "修改成功");
		}catch(Exception e){
			map.put("message", "修改失败");
		}
		return map;
		
	}
	//修改文章(获取单个文章)
	@ResponseBody
	@RequestMapping("user/updateArticle")
	public Map<String,Object>  updateArticle(String id ,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		Article dangeResult = updateArticleFenleiService.updateArticle(id);
		map.put("dangeResult", dangeResult);
		return map;
	}
	//保存修改的文章
	@ResponseBody
	@RequestMapping("user/saveupdateArticle")
	public Map<String,Object> saveupdateArticle(String title,String content ,String id){
		
		Map<String,Object> map=new HashMap<String,Object>();
		try{
		updateArticleFenleiService.saveupdateArticle(title,content,id);
			map.put("message", "修改成功");
		}catch(Exception e){
			map.put("message", "修改失败");
		}
		return map;
		
	}
}
