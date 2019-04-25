package com.cqeec.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqeec.blog.dao.UserEditdataDao;
import com.cqeec.blog.entity.SystemUser;

@Service
@Transactional
public class UserEditdataServiceImpl implements UserEditdataService {
	@Autowired
	private UserEditdataDao userEditdataDao;
	@Override
	public void editData(String id,String nickname, String netname, String address,
			String occupation, String password) {
		userEditdataDao.editData(id,nickname,netname,address,occupation,password);
		
	}
	@Override
	public List<SystemUser> checkPwdUpdate() {
		
		return userEditdataDao.checkPwdIdUpdate();
	}

}
