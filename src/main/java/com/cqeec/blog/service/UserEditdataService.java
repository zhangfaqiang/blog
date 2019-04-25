package com.cqeec.blog.service;

import java.util.List;

import com.cqeec.blog.entity.SystemUser;


public interface UserEditdataService {

	public void editData(String id,String nickname, String netname, String address,
			String occupation, String password);
	public List<SystemUser> checkPwdUpdate();
}
