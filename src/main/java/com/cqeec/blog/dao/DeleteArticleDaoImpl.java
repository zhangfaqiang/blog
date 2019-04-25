package com.cqeec.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteArticleDaoImpl implements DeleteArticleDao {
@Autowired
private SessionFactory session;
	@Override
	public void deleteArticleByid(String id) {
		session.getCurrentSession().createQuery("DELETE FROM Article where id=:id")
		.setParameter("id", id)
		.executeUpdate();
		
	}

}
