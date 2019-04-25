package com.cqeec.blog.dao;

import java.util.List;

import com.cqeec.blog.entity.SystemUser;


public interface UserEditdataDao {

public void editData(String id,String nickname, String netname, String address,
		String occupation, String password);

public List<SystemUser> checkPwdIdUpdate();

}
