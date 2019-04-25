package com.cqeec.blog.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqeec.blog.entity.Article;

@Repository
public class ShowArticleDaoImpl implements ShowArticleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> showArticle(String uid) {
	//这里是session里面传过来的uid
		return sessionFactory.getCurrentSession()
				.createQuery("from Article where uid.id = :uid")
				.setParameter("uid", uid)
				.list();
		}

}
