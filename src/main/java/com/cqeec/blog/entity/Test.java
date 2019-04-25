package com.cqeec.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="test")
public class Test {
	@Id
	@Column(columnDefinition = "char(36)")
	public String id;
}
