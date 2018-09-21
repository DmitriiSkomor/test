package com.example.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) { //added
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

//	public static void main(String[] args){
//		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//		TestBean testBean =  context.getBean(TestBean.class);
//		System.out.println(testBean.getName());
//	}
}
