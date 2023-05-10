package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.beans.JavaBean;
import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@JavaBean
public class User {
	
	private int id;
	
	@NotNull
	@NotEmpty 
	@Size(min=2,message = "Name size should be minimum 2")
	private String name;
	
	@Past(message = "Birth Date cannot be greater that current date")
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
