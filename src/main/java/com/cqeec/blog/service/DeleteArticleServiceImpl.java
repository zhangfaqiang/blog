package com.cqeec.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqeec.blog.dao.DeleteArticleDao;

@Service
@Transactional
public class DeleteArticleServiceImpl implements DeleteArticleService {
@Autowired
private DeleteArticleDao deleteArticleDao;
	@Override
	public void deleteArticleByid(String id) {
		deleteArticleDao.deleteArticleByid(id);
		
	}

}
