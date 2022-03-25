package ru.job4j.poly;

public interface Transport {
    public void drive();

    public void passengers(int quantity);

    public float refuel(int fuelAmount);
}
