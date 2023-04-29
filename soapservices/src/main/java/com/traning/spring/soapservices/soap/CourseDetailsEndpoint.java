package com.traning.spring.soapservices.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in29minutes.courses.CourseDetails;
import com.in29minutes.courses.GetCourseDetailsRequest;
import com.in29minutes.courses.GetCourseDetailsResponse;


@Endpoint
public class CourseDetailsEndpoint {
	//Methods
	//input-Request
	//output-Response
	// Request Namespace http://in29minutes.com/courses
	//Request GetCourseDetailsRequest
	
	@PayloadRoot(namespace = "http://in29minutes.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setDescription("Good for Javaq Developer");
		courseDetails.setName("Soap Course");
		response.setCourseDetails(courseDetails);
		return response;
	}
}
