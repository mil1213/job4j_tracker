package ru.job4j.poly;

public class Bbus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + "  едет по дороге");
    }

    @Override
    public void consist() {
        System.out.println(getClass().getSimpleName() + "  имеет автомобильные колеса");
    }
}
