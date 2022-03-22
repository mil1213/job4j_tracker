package ru.job4j.io;

import java.util.Scanner;

public class Matchers {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + "  введите число от 1 до 3:");
            int matchers = Integer.parseInt(input.nextLine());
            if (matchers <= 3 && matchers > 0 && matchers <= count) {
                turn = !turn;
                count -= matchers;
                System.out.println("На столе осталось " + count + " спичек");
            } else {
                System.out.println("Вы ошиблись. Введите число еще раз: ");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}