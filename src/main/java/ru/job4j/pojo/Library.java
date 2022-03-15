package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 50);
        Book second = new Book("Green book", 278);
        Book third = new Book("OVOD", 300);
        Book fourth = new Book("The living and the dead", 250);
        Book[] lib = new Book[4];
        lib[0] = first;
        lib[1] = second;
        lib[2] = third;
        lib[3] = fourth;
        for (int i = 0; i < lib.length; i++) {
            Book b = lib[i];
            System.out.println(b.getName() + " - " + b.getNumberOfPages());
        }
        System.out.println("Change books");
        Book temp = lib[0];
        lib[0] = lib[2];
        lib[2] = temp;
        for (int i = 0; i < lib.length; i++) {
            Book b = lib[i];
            System.out.println(b.getName() + " - " + b.getNumberOfPages());
        }
        System.out.println("Find the book:");
        for (int i = 0; i < lib.length; i++) {
            Book b = lib[i];
            if (b.getName() == "Clean code") {
                System.out.println(b.getName() + " - " + b.getNumberOfPages());
            }
        }
    }
}
