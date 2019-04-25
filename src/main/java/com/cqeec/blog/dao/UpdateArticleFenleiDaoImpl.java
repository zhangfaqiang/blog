package com.cqeec.blog.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqeec.blog.entity.Article;

@Repository
public class UpdateArticleFenleiDaoImpl implements UpdateArticleFenleiDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void updateFenLei(String fenlei, String id) {
		
		session.getCurrentSession()
				.createQuery(
						"UPDATE Article ar SET ar.fenlei=:fenlei WHERE ar.id=:id")
				.setParameter("fenlei", fenlei)
				.setParameter("id", id)
				.executeUpdate();
	}

	@Override
	public Article updateArticle(String id) {
		
		return (Article)session.getCurrentSession()
				.createQuery("from Article where id.id = :id")
				.setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public void saveupdateArticle(String title, String content, String id) {
		session.getCurrentSession()
		.createQuery(
				"UPDATE Article ar SET ar.title=:title,ar.content=:content WHERE ar.id=:id")
		.setParameter("title", title)
		.setParameter("content", content)
		.setParameter("id", id)
		.executeUpdate();
	}

}
