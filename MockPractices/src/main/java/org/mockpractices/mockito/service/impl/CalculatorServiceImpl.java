/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.mockito.service.impl;

import org.mockpractices.mockito.service.CalculatorService;

/**
 *
 * @author aco-ec-024
 */
public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public double add(double input1, double input2) {
        return input1 + input2; 
    }

    @Override
    public double subtract(double input1, double input2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double multiply(double input1, double input2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double divide(double input1, double input2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
