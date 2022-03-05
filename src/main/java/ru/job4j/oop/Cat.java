package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + " has " + this.food + " for dinner");
    }

    public void meat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.meat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        Cat black = new Cat();
        black.meat("fish");
        black.giveNick("Black");
        black.show();
    }
}
