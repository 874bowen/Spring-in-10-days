package com.example.demo.springin10days;

//import org.apache.catalina.core.ApplicationContext;

import com.example.demo.componentScan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.componentScan") //without this it'll take the springin10days package only
public class DemoComponentScan {
    // What are the beans?
    // What are the dependencies of a bean
    // Where to search for a bean? =>< No need because we are in the same package = Component Scan
    private static Logger LOGGER = LoggerFactory.getLogger(DemoScopeApplication.class);
    // we were doing logging using System.out.println now let's use the SLF4J Logger above
    public static void main(String[] args) {
        // new QuickSortAlgorithm() --> this is a bean
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

        // Application Context enables us to get the binarySearch from Spring => it manages all the beans

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoComponentScan.class);
        // when we are trying to get different instances of the binarySearchImpl what we get is the same instance of binarySearch
        // These are called SINGLETON bean Scope -> by default spring uses this
        // PROTOTYPE bean Scope - New bean whenever requested
        // REQUEST bean Scope - One bean per HTTP request
        // SESSION bean Scope - One bean per HTTP session
        ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
        ComponentDAO componentDAO2 = applicationContext.getBean(ComponentDAO.class);
        // Singleton in spring means you have one instance per application context
        // By GangOfFour definition even if multiple application context you should have one
        // instance of the particular class
        LOGGER.info("{}", componentDAO);
        LOGGER.info("{}", componentDAO.getJdbcConnection());
        LOGGER.info("{}", componentDAO.getJdbcConnection());

        LOGGER.info("{}", componentDAO2);
        LOGGER.info("{}", componentDAO2.getJdbcConnection());
    }

}
