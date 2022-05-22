package com.example.demo;

//import org.apache.catalina.core.ApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	// What are the beans?
	// What are the dependencies of a bean
	// Where to search for a bean? =>< No need because we are in the same package = Component Scan

	public static void main(String[] args) {
		// new QuickSortAlgorithm() --> this is a bean
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

		// Application Context enables us to get the binarySearch from Spring => it manages all the beans

		ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(DemoApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] {12, 4, 6 }, 3);
		System.out.println(result);
	}

}
