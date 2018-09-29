/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.mockito;

import org.mockpractices.mockito.service.CalculatorService;

/**
 *
 * @author aco-ec-024
 */
public class MathApplication {
    
    private CalculatorService calculatorService;
    
    public void setCalculatorService(CalculatorService calculatorService){
      this.calculatorService = calculatorService;
   }
    
    public double add(double input1, double input2) {
        return calculatorService.add(input1, input2);
    }
    
    public double subtract(double input1, double input2) {
        return calculatorService.subtract(input1, input2);
    }
    
    public double multiply(double input1, double input2) {
        return calculatorService.multiply(input1, input2);
    }
    
    public double divide(double input1, double input2) {
        return calculatorService.divide(input1, input2);
    }
}
