package ru.job4j.poly;

public class Usage {
    public static void main(String[] args) {
        Vehicle bus = new Bbus();
        Vehicle plane = new Plane();
        Vehicle train = new Train();

        Vehicle[] vehicles = new Vehicle[]{bus, plane, train};
        for (Vehicle v : vehicles) {
            v.move();
            v.consist();
            System.out.println();
        }
    }
}
