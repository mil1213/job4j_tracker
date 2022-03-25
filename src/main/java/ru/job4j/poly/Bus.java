package ru.job4j.poly;

import java.sql.SQLOutput;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус отправляется");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Число пассажиров: " + quantity);
    }

    @Override
    public float refuel(int fuelAmount) {
       return fuelAmount * 50;
    }
}
