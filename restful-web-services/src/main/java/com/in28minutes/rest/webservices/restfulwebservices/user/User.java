package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.beans.JavaBean;
import java.time.LocalDate;

@JavaBean
public class User {
	
	private int id;
	private String name;
	private LocalDate birDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirDate() {
		return birDate;
	}
	public void setBirDate(LocalDate birDate) {
		this.birDate = birDate;
	}
	public User(int id, String name, LocalDate birDate) {
		super();
		this.id = id;
		this.name = name;
		this.birDate = birDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birDate=" + birDate + "]";
	}
	
	
	
}
