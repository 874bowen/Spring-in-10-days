package com.example.demo.springin10days.basic;

import com.example.demo.springin10days.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


//Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= "/testContext.xml") // locations are the XML Locations
public class BinarySearchImplXMLTests {
    // Get this bean from the context
    @Autowired
    BinarySearchImpl binarySearch;
    @Test
    public void testBasicScenario(){
        // call method on binarySearch
        int result = binarySearch.binarySearch(new int[]{}, 5);
        // check if the value is correct
        assertEquals(3, result);
    }
}
