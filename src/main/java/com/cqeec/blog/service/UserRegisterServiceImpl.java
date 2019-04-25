package com.cqeec.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqeec.blog.dao.UserRegisterDao;
import com.cqeec.blog.entity.SystemUser;
@Service
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService{
	@Autowired
	private UserRegisterDao registerDao;
	@Override
	public void addUser(SystemUser systemuser) {
		registerDao.addUser(systemuser);
	}
	@Override
	public void save(SystemUser su) {
		registerDao.save(su);
	}

}
