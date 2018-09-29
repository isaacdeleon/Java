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
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockpractices.mockito.MathApplication;
import org.mockpractices.mockito.service.CalculatorService;
import org.mockpractices.mockito.service.impl.CalculatorServiceImpl;

/**
 *
 * @author aco-ec-024
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationSpyTest {
    
   private MathApplication mathApplication;
   private CalculatorService calcService;
   
   @Before
   public void setUp() {
       mathApplication = new MathApplication();
       CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
       calcService = Mockito.spy(calculatorServiceImpl);
       mathApplication.setCalculatorService(calcService);
   }
   
   @Test
   public void test() {
       Assertions.assertThat(mathApplication.add(20.0, 10.0)).isEqualTo(30.0);
   }
}
