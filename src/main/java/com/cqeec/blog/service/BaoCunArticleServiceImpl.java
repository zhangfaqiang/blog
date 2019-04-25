package com.cqeec.blog.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqeec.blog.dao.BaoCunArticleDao;
import com.cqeec.blog.entity.Article;

@Service
@Transactional
public class BaoCunArticleServiceImpl implements BaoCunArticleService {
	@Autowired
	private BaoCunArticleDao baoCunArticleDao;

	@Override
	public void insertAriticle(Article article) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		format.format(date);
		article.setRiqi(date);
		baoCunArticleDao.insetArticle(article);
		
	}

}
