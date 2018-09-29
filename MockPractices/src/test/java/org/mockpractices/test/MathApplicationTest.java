/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.test;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockpractices.mockito.MathApplication;
import org.mockpractices.mockito.service.CalculatorService;
import org.mockpractices.mockito.service.impl.CalculatorServiceImpl;

/**
 *
 * @author aco-ec-024
 */
// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {
    
    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();
    
    //@Mock annotation is used to create the mock object to be injected
    
    CalculatorService calculatorService = Mockito.mock(CalculatorService.class);
    
    @Before
    public void setUp() {
        mathApplication.setCalculatorService(calculatorService);
    }
    
    @Test
    public void testAdd() {
        //add the behavior of calc service to add two numbers
        Mockito.when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
        Mockito.when(calculatorService.subtract(20.0, 10.0)).thenReturn(10.00);
        
        Assertions.assertThat(mathApplication.subtract(20.0, 10.0)).isEqualTo(10.0);
        
        //test functionality
        Assertions.assertThat(mathApplication.add(10.0, 20.0)).isEqualTo(30.0);
        Assertions.assertThat(mathApplication.add(10.0, 20.0)).isEqualTo(30.0);
        Assertions.assertThat(mathApplication.add(10.0, 20.0)).isEqualTo(30.0);
        
        Mockito.verify(calculatorService).subtract(20.0, 10.0);
        
        Mockito.verify(calculatorService,Mockito.times(3)).add(10.0, 20.0);
        
        Mockito.verify(calculatorService,Mockito.never()).multiply(10.0, 20.0);
        
    }
    
    @Test(expected = RuntimeException.class)
    public void testAddException() {
        Mockito.doThrow(new RuntimeException("Add Operation Not Implented")).when(calculatorService).add(10.0,20.0);
        Assertions.assertThat(mathApplication.add(10.0, 20.0)).isEqualTo(30.0);
    }
    
    @Test
    public void testAddStubbing() {
        
        Mockito.when(calculatorService.add(20.0, 10.0)).thenAnswer(new Answer<Double>() {
            
            @Override
            public Double answer(InvocationOnMock invocation) throws Throwable {
                //get the arguments passed to mock
                Object[] args = invocation.getArguments();
                
                for (int i = 0; i < args.length; i++) {
                    System.out.println(args[i]);
                }
                
                //get the mock
                Object mock = invocation.getMock();
                System.out.println(mock);
                
                return 30.0;
            }
        });
        
        Assertions.assertThat(mathApplication.add(20.0, 10.0)).isEqualTo(30.0);
    }
    
    @Test
    public void testReset() {
        
        Mockito.when(calculatorService.add(20.0, 10.0)).thenReturn(30.0);
        Assertions.assertThat(mathApplication.add(20.0, 10.0)).isEqualTo(30.0);
        
        Mockito.reset(calculatorService);
        Assertions.assertThat(mathApplication.add(20.0, 10.0)).isEqualTo(0); 
    }
    
    @Test
    public void testBehavior() {
        //Given
        BDDMockito.given(calculatorService.add(20.0, 10.0)).willReturn(30.0);
        
        //when
        double result = calculatorService.add(20.0, 10.0);
        
        //then
        Assertions.assertThat(result).isEqualTo(30.0);
    }
    
    @Test
    public void testTimeOuts() {
        
        //add the behavior to add numbers
        Mockito.when(calculatorService.add(20.0,10.0)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        Mockito.when(calculatorService.subtract(20.0,10.0)).thenReturn(10.0);
        
        Assertions.assertThat(calculatorService.subtract(20.0, 10.0)).isEqualTo(10.0);
        Assertions.assertThat(calculatorService.add(20.0, 10.0)).isEqualTo(30.0);
        
        //verify call to add method to be completed within 100 ms
        Mockito.verify(calculatorService, Mockito.timeout(100)).add(20.0, 10.0);
        
        //invocation count can be added to ensure multiplication invocations
        //can be checked within given timeframe
        Mockito.verify(calculatorService, Mockito.timeout(100).times(1)).subtract(20.0, 10.0);
    }
}
