package com.cqeec.blog.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqeec.blog.entity.SystemUser;
@Repository
public class UserRegisterDaoImpl implements UserRegisterDao{
	@Autowired
	private SessionFactory session;
	@Override
	public void addUser(SystemUser systemuser) {
		//如果hibernate的配置文件是给的assigned这里需要手动赋值
		//systemuser.setId(UUID.randomUUID().toString().toUpperCase());
		session.getCurrentSession().save(systemuser);
	}
	@Override
	public void save(SystemUser su) {
		//su.setId(UUID.randomUUID().toString().toUpperCase());
		session.getCurrentSession().save(su);
	}
	
	

}
