/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.powermock.test;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockpractices.mockito.powermock.ClassPowerMockPractice;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author aco-ec-024
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassPowerMockPractice.class)
public class PowerMockTest {
    
    @Test
    public void testClassWithFinalMethods() throws Exception{
        
        String message = "Hello Powermockito";
        
        ClassPowerMockPractice classWithFinalMethodsMock = PowerMockito.mock(ClassPowerMockPractice.class);
        PowerMockito.whenNew(ClassPowerMockPractice.class).withNoArguments().thenReturn(classWithFinalMethodsMock);
        
        ClassPowerMockPractice object = new ClassPowerMockPractice();
        PowerMockito.verifyNew(ClassPowerMockPractice.class).withNoArguments();
        
        PowerMockito.when(object.printMessages(message)).thenReturn(message);
        String helloPowerMockito = object.printMessages(message);
        Mockito.verify(object).printMessages(message);
        Assertions.assertThat(helloPowerMockito).isEqualTo(message);
    }
    
    @Test
    public void testClassWithFinalMethods2() throws Exception{
        
        String message = "Hello Powermockito";
        
        ClassPowerMockPractice classWithFinalMethodsMock = PowerMockito.mock(ClassPowerMockPractice.class);
        PowerMockito.when(classWithFinalMethodsMock.printMessages(message)).thenReturn(message);
        
        String helloPowerMockito = classWithFinalMethodsMock.printMessages(message);
        Assertions.assertThat(message).isEqualTo(helloPowerMockito);
    }
    
    @Test
    public void testClassWithPrivateMethods() throws Exception{
        
        String message = "Hello PowerMockito";
        String expectation = "Expectation";
        
        ClassPowerMockPractice mock = PowerMockito.spy(new ClassPowerMockPractice());
        PowerMockito.doReturn(expectation).when(mock,"privatePrintMessage",message);
        
        String actual = mock.privateCall(message);
        Assertions.assertThat(expectation).isEqualTo(actual);
    }
    
    @Test
    public void testStaticMethod() {
        
        String message = "Hello PowerMockito"; 
        String expectation = "Expectation";
        
        PowerMockito.mockStatic(ClassPowerMockPractice.class);
        PowerMockito.when(ClassPowerMockPractice.printMessageStatic(message)).thenReturn(expectation);
        
        String actual = ClassPowerMockPractice.printMessageStatic(message);
        Assertions.assertThat(expectation).isEqualTo(actual);
    }
}
