package com.basic.anonim.impl;

import com.basic.anonim.Machine;
import com.basic.anonim.Plant;

public class Main {

    public static void main(String[] args) {
        Machine machine = new Machine() {
            @Override
            public void start() {
                System.out.println("Camera Snapping.....");
            }
        };
        machine.start();

        Plant plant = new Plant() {
            public void grow() {
                System.out.println("Plant Growing");
            }
        };
        plant.grow();
    }
}
