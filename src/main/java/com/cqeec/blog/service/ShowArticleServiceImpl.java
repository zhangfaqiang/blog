package com.cqeec.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqeec.blog.dao.ShowArticleDao;
import com.cqeec.blog.entity.Article;
@Service
@Transactional
public class ShowArticleServiceImpl implements ShowArticleService {
@Autowired
private ShowArticleDao showArticleDao;
	
	@Override
	public List<Article> showArticle(String uid) {
		return showArticleDao.showArticle(uid);
	}

}
