package com.ftn.JhipsterThymeleaf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
//@ComponentScan({"com.ftn.JhipsterThymeleaf.controller","com.ftn.JhipsterThymeleaf.dao.Impl","com.ftn.JhipsterThymeleaf.dao","com.ftn.JhipsterThymeleaf.service","com.ftn.JhipsterThymeleaf.service.impl","com.ftn.JhipsterThymeleaf.util"})
public class JhipsterThymeleaf extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JhipsterThymeleaf.class);
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JhipsterThymeleaf.class, args);
	}

}
