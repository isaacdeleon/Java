/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.mockito.powermockito;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author amk-ec-017
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Engine.class, CarScope.class,CarExt.class})
@SuppressStaticInitializationFor("org.mockpractices.mockito.powermockito.VehicleStaticBlock")
public class CarTest {
    
    @InjectMocks
    CarPrivate carPrivate;
    
    @Mock(name = "engine1")
    Engine engineMocked;
    
    @Mock(name = "engine2")
    Engine engineMocked2;
            
    /**
     * Test of start method, of class Car.
     */
    @Ignore
    @Test
    public void start_should_return_true_engine_ok() {
        Engine engine = PowerMockito.mock(Engine.class);
        PowerMockito.when(engine.start()).thenReturn(Engine.STARTED);
        Car car = new Car(engine);
        assertTrue(car.start());
    }
 
    /**
     * Test of start method, of class CarStatic.
     */
    @Ignore
    @Test
    public void start_should_return_true_engine_ok_static() {
        PowerMockito.mockStatic(Engine.class);
        PowerMockito.when(Engine.startStatic()).thenReturn(Engine.STARTED);
        CarStatic carStatic = new CarStatic();
        assertTrue(carStatic.start());
    }
    
    /**
     * Test of start method, of class CarSatic with Spy.
     */
    @Ignore
    @Test
    public void start_should_return_true_engine_ok_static_spy() {
        PowerMockito.mockStatic(Engine.class);
        PowerMockito.when(Engine.startStatic()).thenReturn(Engine.STARTED);
        CarStatic carStatic = PowerMockito.spy(new CarStatic());
        PowerMockito.when(carStatic.getEngineType()).thenReturn(Engine.Type.DIESEL);
        assertTrue(carStatic.start());
    }
    
    /**
     * Test of start method, of class CarPrivate on private variables.
     */
    @Ignore
    @Test
    public void start_should_return_true_engine_ok_private() {
        //PowerMockito.when(engineMocked.start()).thenReturn(Engine.STARTED);
        //assertTrue(carPrivate.start());
        
        PowerMockito.when(engineMocked2.start()).thenReturn(Engine.STARTED);
        assertTrue(carPrivate.start());
    }
    
    /**
     * Test of start method, of class CarScope on scope vairables.
     */
    @Ignore
    @Test
    public void start_should_return_true_engine_ok_scope() throws Exception {
        Engine engine = PowerMockito.mock(Engine.class);
        
        PowerMock.expectNew(Engine.class).andReturn(engine);
        PowerMock.replay(Engine.class);
        
        PowerMockito.when(engine.start()).thenReturn(Engine.STARTED);
        CarScope carScope = new CarScope();
        assertTrue(carScope.start());
    }
    
    /**
     * Test of start method, of class CarExte for supressin constructors.
     */
    @Ignore
    @Test
    public void start_should_return_true_engine_ok_supress() throws Exception {
        
        PowerMockito.suppress(PowerMockito.constructor(Vehicle.class));
        Engine engine = PowerMockito.mock(Engine.class);
        PowerMockito.when(engine.start()).thenReturn(Engine.STARTED);
        
        CarExt carExt = new CarExt(engine);
        assertTrue(carExt.start());
    }
    
    /**
     * Test of start method, of class CarExte for supressin static blocks.
     */
    @Test
    public void start_should_return_true_engine_ok_static_block() throws Exception {
        
        Engine engine = PowerMockito.mock(Engine.class);
        PowerMockito.when(engine.start()).thenReturn(Engine.STARTED);
        
        CarExtStaticBlock carExtStaticBlock = new CarExtStaticBlock(engine);
        assertTrue(carExtStaticBlock.start());
    }
}
