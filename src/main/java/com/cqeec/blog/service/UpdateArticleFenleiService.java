package com.cqeec.blog.service;


import com.cqeec.blog.entity.Article;


public interface UpdateArticleFenleiService {

public void updateFenLei(String fenlei, String id);

public Article updateArticle(String id);

public void saveupdateArticle(String title, String content, String id);

}
