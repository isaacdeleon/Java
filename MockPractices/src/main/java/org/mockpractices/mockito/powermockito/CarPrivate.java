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
public class CarPrivate {
    
    private Engine engine;
    private Engine engine2;
    
    public CarPrivate() {
        engine = new Engine();
        engine = new Engine();
    }
    
    public boolean start() {
        
        if(engine2.start() == Engine.STARTED) {
            return true;
        }
        return false;
    }
}
