package com.cqeec.blog.entity;

import java.util.List;


public class SystemUser {
	private String id;// 标识列
	private String username;// 账号
	private String nickname;// 昵称
	private String password;// 密码
	private String password2;//确认密码
	private String netname;//网名
	private String address;//地址
    private String occupation;//职业
    private List<Article> article;
	public SystemUser(String id, String username, String nickname,
			String password, String password2, String netname, String address,
			String occupation, List<Article> article) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.password2 = password2;
		this.netname = netname;
		this.address = address;
		this.occupation = occupation;
		this.article = article;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public SystemUser(String id) {
		this.id = id;
	}

	public SystemUser(String id, String username, String nickname,
			String password, String password2, String netname, String address,
			String occupation) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.password2 = password2;
		this.netname = netname;
		this.address = address;
		this.occupation = occupation;
	}



	public String getNetname() {
		return netname;
	}



	public void setNetname(String netname) {
		this.netname = netname;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public SystemUser() {
		
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
