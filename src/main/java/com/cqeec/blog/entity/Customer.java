package com.cqeec.blog.entity;

public class Customer {
	private String id;
	private String name;
	private Integer age;
	private String sex;
	private String city;
	//一对一属性字段
	private SystemUser systemUser;

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return "Customer [id=" + id + ",name=" + name + ",age=" + age + ",sex="
				+ sex + ",city=" + city + "]";
	}
}
