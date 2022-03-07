package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y){
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int devide(int c) {
        return c / x;
    }

    public int sumAllOperations (int d) {
        return sum(d) + multiply(d) + minus(d) + devide(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(3);
        System.out.println("sum result for 3 = " + result);
        result = calculator.multiply(3);
        System.out.println("multiply result for 3 = " + result);
        result = minus(7);
        System.out.println("minus result for 7 = " + result);
        result = calculator.devide(15);
        System.out.println("devide result for 15 = " + result);
        result = calculator.sumAllOperations(20);
        System.out.println("sumAllOperations result for 20 = " + result);
    }
}
