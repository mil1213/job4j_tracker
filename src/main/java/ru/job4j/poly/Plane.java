package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + "  летит по воздуху");
    }

    @Override
    public void consist() {
        System.out.println(getClass().getSimpleName() + "  имеет два крыла");
    }
}
