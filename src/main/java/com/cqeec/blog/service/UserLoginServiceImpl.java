package com.cqeec.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqeec.blog.dao.UserLoginDao;
import com.cqeec.blog.entity.SystemUser;
@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService{
@Autowired
private UserLoginDao userLoginDao;
	@Override
	public SystemUser findSystemUser(String userName, String userPassword) {
		return userLoginDao.findSystemUser(userName,userPassword);
	}

}
