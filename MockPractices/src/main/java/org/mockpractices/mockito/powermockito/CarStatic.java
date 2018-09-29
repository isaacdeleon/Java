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
public class CarStatic {
    
    public boolean start() {
        if(getEngineType().equals(Engine.Type.DIESEL) && isVeryLowTempOutSide()) {
            Engine.preHeatEngine();
        }
        
        if(Engine.startStatic()== Engine.STARTED) {
            return true;
        }
        return false;
    }
    
    public boolean isVeryLowTempOutSide() {
        return false;
    }
    
    public Engine.Type getEngineType() {
        return null;
    }
}
