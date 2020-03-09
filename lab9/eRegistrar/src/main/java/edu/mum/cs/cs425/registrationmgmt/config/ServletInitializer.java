package edu.mum.cs.cs425.registrationmgmt.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import edu.mum.cs.cs425.registrationmgmt.ERegistrarApplication;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ERegistrarApplication.class);
	}

}