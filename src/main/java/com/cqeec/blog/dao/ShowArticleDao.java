package com.cqeec.blog.dao;

import java.util.List;

import com.cqeec.blog.entity.Article;

public interface ShowArticleDao {


	public List<Article> showArticle(String uid);
}
