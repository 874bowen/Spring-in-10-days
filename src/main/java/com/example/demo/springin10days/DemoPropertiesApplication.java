package com.example.demo.springin10days;

//import org.apache.catalina.core.ApplicationContext;

import com.example.demo.springin10days.properties.SomeExternalService;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// @SpringBootApplication automatically defines a component scan on this package 'springin10days'
@Configuration// similar @ComponentScan("com.example.demo.springin10days")
@ComponentScan
// app.properties
@PropertySource("classpath:app.properties")
public class DemoPropertiesApplication {
	// What are the beans?
	// What are the dependencies of a bean
	// Where to search for a bean? =>< No need because we are in the same package = Component Scan

	public static void main(String[] args) {
		// new QuickSortAlgorithm() --> this is a bean
//		SomeExternalService binarySearch = new SomeExternalService(new QuickSortAlgorithm());

		// Application Context enables us to get the binarySearch from Spring => it manages all the beans

//		ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(DemoApplication.class, args);
		try {
			AnnotationConfigApplicationContext applicationContext =
					new AnnotationConfigApplicationContext(DemoPropertiesApplication.class);

			// when we are trying to get different instances of the SomeExternalService what we get is the same instance of binarySearch
			// These are called SINGLETON bean Scope -> by default spring uses this
			// PROTOTYPE bean Scope - New bean whenever requested
			// REQUEST bean Scope - One bean per HTTP request
			// SESSION bean Scope - One bean per HTTP session
			SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
			SomeExternalService service2 = applicationContext.getBean(SomeExternalService.class);
			System.out.println(service);
			System.out.println(service.returnServiceURL());
			System.out.println(service2);

		} catch (BeansException e) {
			throw new RuntimeException(e);
		}

	}

}
