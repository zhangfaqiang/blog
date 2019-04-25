package com.cqeec.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqeec.blog.entity.Article;
@Repository
public class BaoCunArticleDaoImpl implements BaoCunArticleDao {
@Autowired
private SessionFactory sessionFactory;
	@Override
	
	public void insetArticle(Article article) {
		sessionFactory.getCurrentSession().save(article);
		
	}

}
