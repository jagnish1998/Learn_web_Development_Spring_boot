package com.traning.spring.soapservices.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in29minutes.courses.CourseDetails;
import com.in29minutes.courses.DeleteCourseDetailsRequest;
import com.in29minutes.courses.DeleteCourseDetailsResponse;
import com.in29minutes.courses.GetAllCourseDetailsRequest;
import com.in29minutes.courses.GetAllCourseDetailsResponse;
import com.in29minutes.courses.GetCourseDetailsRequest;
import com.in29minutes.courses.GetCourseDetailsResponse;
import com.traning.spring.soapservices.soap.bean.Course;
import com.traning.spring.soapservices.soap.exception.CourseNotFoundException;
import com.traning.spring.soapservices.soap.service.CourseDetailsService;
import com.traning.spring.soapservices.soap.service.CourseDetailsService.Status;


@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;
	//Methods
	//input-Request
	//output-Response
	// Request Namespace http://in29minutes.com/courses
	//Request GetCourseDetailsRequest
	
	@PayloadRoot(namespace = "http://in29minutes.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

		Course course = service.findById(request.getId());
		
		if(course==null) {
			throw new CourseNotFoundException("Invalid Course Id: "+request.getId());
		}
		
		return mapCourseDetails(course);
	}

	@PayloadRoot(namespace = "http://in29minutes.com/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse processCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {

		Status status = service.deleteById(request.getId());
		
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		
		if(status == Status.SUCESS) {
			response.setStatus(com.in29minutes.courses.Status.SUCESS);
		}
		else {
			response.setStatus(com.in29minutes.courses.Status.FAILURE);
		}
		
		return response;
	}
	
	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for(Course course:courses) {
			CourseDetails courseDetails = mapCourse(course);
			response.getCourseDetails().add(courseDetails);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setDescription(course.getDescription());
		courseDetails.setName(course.getName());
		return courseDetails;
	}
	
	@PayloadRoot(namespace = "http://in29minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {

		List<Course> courses = service.findAll();
		return mapAllCourseDetails(courses);
	}
}
