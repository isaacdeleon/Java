/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.mockito.powermock;

/**
 *
 * @author aco-ec-024
 */
public class ClassPowerMockPractice {
    
    public final String printMessages(String message) { 
        return message;
    }
    
    private String privatePrintMessage(String message) {
        return message;
    }
    
    public String privateCall(String message) {
        return privatePrintMessage(message);
    }
    
    public static String printMessageStatic(String message) {
        return message;
    }
}
