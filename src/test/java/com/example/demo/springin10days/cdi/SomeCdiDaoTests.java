package com.example.demo.springin10days.cdi;

import com.example.demo.springin10days.DemoCDIApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


//Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoCDIApplication.class) // load configuration by class
public class SomeCdiDaoTests {
    // Get this bean from the context
    @Autowired
    SomeCDIBusiness someCDIBusiness;
    @Test
    public void testBasicScenario(){
        // call method on binarySearch
        int result = someCDIBusiness.findGreatest();
        // check if the value is correct
        assertEquals(100, result);
    }
}
