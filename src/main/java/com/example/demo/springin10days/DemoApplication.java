package com.example.demo.springin10days;

//import org.apache.catalina.core.ApplicationContext;

import com.example.demo.springin10days.basic.BinarySearchImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @SpringBootApplication automatically defines a component scan on this package 'springin10days'
@Configuration// similar @ComponentScan("com.example.demo.springin10days")
@ComponentScan
public class DemoApplication {
	// What are the beans?
	// What are the dependencies of a bean
	// Where to search for a bean? =>< No need because we are in the same package = Component Scan

	public static void main(String[] args) {
		// new QuickSortAlgorithm() --> this is a bean
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

		// Application Context enables us to get the binarySearch from Spring => it manages all the beans

//		ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(DemoApplication.class, args);
		try {
			AnnotationConfigApplicationContext applicationContext =
					new AnnotationConfigApplicationContext(DemoApplication.class);

			// when we are trying to get different instances of the binarySearchImpl what we get is the same instance of binarySearch
			// These are called SINGLETON bean Scope -> by default spring uses this
			// PROTOTYPE bean Scope - New bean whenever requested
			// REQUEST bean Scope - One bean per HTTP request
			// SESSION bean Scope - One bean per HTTP session
			BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
			BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
			System.out.println(binarySearch);
			System.out.println(binarySearch1);
			int result = binarySearch.binarySearch(new int[] {12, 4, 6 }, 3);
			System.out.println(result);
			applicationContext.close();
		} catch (BeansException e) {
			throw new RuntimeException(e);
		}

	}

}
