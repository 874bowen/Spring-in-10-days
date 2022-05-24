package com.example.demo.springin10days;

//import org.apache.catalina.core.ApplicationContext;

import com.example.demo.springin10days.xml.XmlPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Configuration
//@ComponentScan("com.example.demo.componentScan") //without this it'll take the springin10days package only
public class DemoXmlContexrApplication {
    // What are the beans?
    // What are the dependencies of a bean
    // Where to search for a bean? =>< No need because we are in the same package = Component Scan
    private static Logger LOGGER = LoggerFactory.getLogger(DemoScopeApplication.class);
    public static void main(String[] args) {
        // new QuickSortAlgorithm() --> this is a bean
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

        // Application Context enables us to get the binarySearch from Spring => it manages all the beans

        try {
            ClassPathXmlApplicationContext applicationContext =
                    new ClassPathXmlApplicationContext("applicationContext.xml");
            LOGGER.info("Beans Loaded -> {}", (Object)applicationContext.getBeanDefinitionNames());
            // [xmlJdbcConnection, xmlPersonDAO]
            XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
            System.out.println(xmlPersonDAO);
            LOGGER.info("{} {}", xmlPersonDAO, xmlPersonDAO.getXmlJdbcConnection());
        } catch (BeansException e) {
            throw new RuntimeException(e);
        }

    }

}
