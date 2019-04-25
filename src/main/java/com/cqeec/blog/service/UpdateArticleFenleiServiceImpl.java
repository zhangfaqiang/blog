package com.cqeec.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqeec.blog.dao.UpdateArticleFenleiDao;
import com.cqeec.blog.entity.Article;

@Service
@Transactional
public class UpdateArticleFenleiServiceImpl implements
		UpdateArticleFenleiService {
@Autowired
private UpdateArticleFenleiDao updateArticleFenleiDao;
	
	@Override
	public void updateFenLei(String fenlei, String id) {
		updateArticleFenleiDao.updateFenLei(fenlei,id);
	}

	@Override
	public Article updateArticle(String id) {
		
		return updateArticleFenleiDao.updateArticle(id);
	}

	@Override
	public void saveupdateArticle(String title, String content, String id) {
		updateArticleFenleiDao.saveupdateArticle(title,content,id);
	}

}
