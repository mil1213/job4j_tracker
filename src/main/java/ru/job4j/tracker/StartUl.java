package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUl {
    public static void main(String[] args){
        Item obj = new Item();
        LocalDateTime currentDateTime = obj.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(currentDateTime.format(formatter));
    }
}
