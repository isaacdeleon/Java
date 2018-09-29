/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.mockito.powermockito;

/**
 *
 * @author amk-ec-017
 */
public class VehicleStaticBlock {
 
    static {
        if (true) {
            throw new RuntimeException("static block exception");
        }
    }
    
    public VehicleStaticBlock() {
        System.out.println("construcot VehicleStaticBlock");
    }
}
