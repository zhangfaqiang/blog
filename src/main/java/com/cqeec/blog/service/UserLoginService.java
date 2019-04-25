package com.cqeec.blog.service;


import com.cqeec.blog.entity.SystemUser;

public interface UserLoginService {
public SystemUser findSystemUser(String userName,String userPassword);
}