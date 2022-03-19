package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUl {
    public static void main(String[] args) {
        Item obj = new Item(123, "Kosarev");
        LocalDateTime currentDateTime = obj.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(currentDateTime.format(formatter));
        System.out.println(obj);
    }
}
