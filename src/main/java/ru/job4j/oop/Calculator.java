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

    public int sumAllOperations (int y, int a, int b, int c) {
        return sum(y) + multiply(a) + minus(b) + devide(c);
    }

    public static void main(String[] args) {
        int y = 3;
        int a = 3;
        int b = 7;
        int c = 20;
        Calculator calculator = new Calculator();
        int result = sum(y);
        System.out.println("sum result for 3 = " + result);
        result = calculator.multiply(a);
        System.out.println("multiply result for 3 = " + result);
        result = minus(b);
        System.out.println("minus result for 7 = " + result);
        result = calculator.devide(c);
        System.out.println("devide result for 15 = " + result);
        result = calculator.sumAllOperations(y, a, b, c);
        System.out.println("sumAllOperations result = " + result);
    }
}
