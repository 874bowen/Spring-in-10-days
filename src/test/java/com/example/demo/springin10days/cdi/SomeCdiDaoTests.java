package com.example.demo.springin10days.cdi;

import com.example.demo.springin10days.DemoCDIApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static junit.framework.TestCase.assertEquals;


//Load the context
// test with mockito
@RunWith(MockitoJUnitRunner.class)
public class SomeCdiDaoTests {
    // create Mock
    @Mock
    SomeCDIDAO daoMock;
    // Inject Mock
    @InjectMocks
    SomeCDIBusiness someCDIBusiness;

    @Test
    public void testBasicScenario(){
        // call method on binarySearch
        // When daoMock.getData() method is called return int[]{2,4}
        Mockito.when(daoMock.getData()).thenReturn(new int[]{2, 4});
        int result = someCDIBusiness.findGreatest();
        // check if the value is correct
        assertEquals(4, result);
    }
    @Test
    public void testBasicScenarioEqualElements(){
        Mockito.when(daoMock.getData()).thenReturn(new int[]{2, 2});
        int result = someCDIBusiness.findGreatest();
        assertEquals(2, result);
    }
    @Test
    public void testBasicScenarioNoElements(){
        Mockito.when(daoMock.getData()).thenReturn(new int[]{});
        int result = someCDIBusiness.findGreatest();
        assertEquals(Integer.MIN_VALUE, result);
    }
}
