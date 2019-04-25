package com.cqeec.blog.dao;

import com.cqeec.blog.entity.SystemUser;

public interface UserLoginDao {
public SystemUser findSystemUser(String userName, String userPassword);
}
