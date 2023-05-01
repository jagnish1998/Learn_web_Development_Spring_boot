package com.traning.spring.soapservices.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.traning.spring.soapservices.soap.bean.Course;
import com.traning.spring.soapservices.soap.service.CourseDetailsService.Status;

@Service
public class CourseDetailsService {
	
	public enum Status{
		SUCESS,FAILURE;
	}
	
	private static List<Course> courses = new ArrayList<>();
	
	static {
		Course course1 = new Course(1,"Spring", "10 steps");
		courses.add(course1);
		Course course2 = new Course(2,"Spring MVC", "23 steps");
		courses.add(course2);
		Course course3 = new Course(3,"Spring Boot", "130 steps");
		courses.add(course3);
		Course course4 = new Course(4,"Maven", "100 steps");
		courses.add(course4);
	}
	
	public Course findById(int id) {
		for(Course course:courses) {
			if(course.getId()==id) {
				return course;
			}
		}
		return null;
	}
	
	public List<Course> findAll(){
		return courses;
	}
	
	public Status deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId()==id) {
				iterator.remove();
				return Status.SUCESS;
			}
		}
		return Status.FAILURE;
	}
}
