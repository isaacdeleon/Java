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
public class Engine {

    public static final int STARTED = 1;
    public static final int NOT_STARTED = 2;

    public enum Type {
        DIESEL,
        PETROL
    }
    
    public int start() {
        if (areAllComponentsOk()) {
            return STARTED;
        }
        return NOT_STARTED;
    }

    private boolean areAllComponentsOk() {
        //supposed fail  case
        if (1==1) {
            throw new  RuntimeException("exception testing class");
        }
        return false;
    }
    
    
    public static int startStatic() {
        if (areAllComponentsOkStatic()) {
            return STARTED;
        }
        return NOT_STARTED;
    }
    
    private static boolean areAllComponentsOkStatic() {
        //supposed fail  case
        if (1==1) {
            throw new  RuntimeException("exception testing class");
        }
        return false;
    }
    
    public static void preHeatEngine() {
        //heating actions
    }
}
