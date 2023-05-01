package com.traning.spring.soapservices.soap;


import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable Webservices
@EnableWs
//SpringfConfiguration
@Configuration
public class WebServiceConfig  extends WsConfigurerAdapter{
	//MessageDispatcherServlet
		//ApplicationContext
	//URL -> /ws/*
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServelt(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(messageDispatcherServlet,"/ws/*");
	}
	

	
	//course-details.xsd	
	@Bean
	public XsdSchema courseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}
	
	// /ws/courses.wsdl
	//PortType - CoursePort
	//Namespace
	@Bean(name="course")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema) {
		DefaultWsdl11Definition definition  = new DefaultWsdl11Definition();
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://in29minutes.com/courses");
		definition.setLocationUri("/ws");
		definition.setSchema(courseSchema);
		
		return definition;
	}
	
	
//	Security with WS-security
//	-Authentication
//	-Digital signatures
//	-Certificates
	
//	Implementation -> XWss -XMl and web Services Security
//- XWSsecurityInterceptor
	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
		securityInterceptor.setSecurementActions("UsernameToken");
		securityInterceptor.setSecurementUsername("user");
		securityInterceptor.setSecurementPassword("password");
 
		return securityInterceptor;
	}
	// Interceptors.add -> XwsSecurityInterceptor
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}	
}
