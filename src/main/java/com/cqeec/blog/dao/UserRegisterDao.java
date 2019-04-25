package com.cqeec.blog.dao;

import com.cqeec.blog.entity.SystemUser;

public interface UserRegisterDao {
	public void addUser(SystemUser systemuser);

	public void save(SystemUser su);

}
