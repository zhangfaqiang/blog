package com.cqeec.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqeec.blog.entity.SystemUser;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SystemUser findSystemUser(String userName, String userPassword) {
		return (SystemUser)sessionFactory
				.getCurrentSession()
				.createQuery(
						"from SystemUser where username = :userName  and password = :userPassword")
				.setParameter("userName", userName)
				.setParameter("userPassword", userPassword).uniqueResult();
//一样的道理。。。
	}
}
