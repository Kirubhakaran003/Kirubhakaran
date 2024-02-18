package com.gl.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.gl.configuration.Employee_Configuration;


public class Employee_Dispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		// return null;
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		// return null;
		return new Class[] { Employee_Configuration.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		// return null;
		return new String[] { "/" };
	}

}
