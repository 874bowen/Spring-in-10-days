package com.example.demo.springin10days;

//import org.apache.catalina.core.ApplicationContext;

import com.example.demo.springin10days.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoScopeApplication {
	// What are the beans?
	// What are the dependencies of a bean
	// Where to search for a bean? =>< No need because we are in the same package = Component Scan
	private static Logger LOGGER = LoggerFactory.getLogger(DemoScopeApplication.class);
	// we were doing logging using System.out.println now let's use the SLF4J Logger above
	public static void main(String[] args) {
		// new QuickSortAlgorithm() --> this is a bean
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

		// Application Context enables us to get the binarySearch from Spring => it manages all the beans

		ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(DemoScopeApplication.class, args);
		// when we are trying to get different instances of the binarySearchImpl what we get is the same instance of binarySearch
		// These are called SINGLETON bean Scope -> by default spring uses this
		// PROTOTYPE bean Scope - New bean whenever requested
		// REQUEST bean Scope - One bean per HTTP request
		// SESSION bean Scope - One bean per HTTP session
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		// Singleton in spring means you have one instance per application context
		// By GangOfFour definition even if multiple application context you should have one
		// instance of the particular class
		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());
		LOGGER.info("{}", personDAO.getJdbcConnection());

		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO.getJdbcConnection());
	}

}
