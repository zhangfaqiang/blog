package com.cqeec.blog.entity;

import java.util.Date;

public class Article {
	private SystemUser uid;//用户的id
	private String id;//标识
	private String title;//文章的标题
	private String content;//文章内容
	private String fenlei;//文章得分类
	public String getFenlei() {
		return fenlei;
	}
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	private Date riqi;//发布日期
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public SystemUser getUid() {
		return uid;
	}
	public void setUid(SystemUser uid) {
		this.uid = uid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	public Article(SystemUser uid, String id, String title, String content,
			Date riqi ,String fenlei) {
		super();
		this.uid = uid;
		this.id = id;
		this.title = title;
		this.content = content;
		this.riqi = riqi;
		this.fenlei=fenlei;
	}
	public Article(){
		super();
	}
	public Article(String id){
		super();
		this.id=id;
	}
}

