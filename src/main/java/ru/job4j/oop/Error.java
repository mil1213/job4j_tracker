package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void print() {
        System.out.println(active + ", " + status + ", " + message);
    }

    public static void main(String[] args) {
        Error errorA = new Error();
        errorA.print();
        Error errorB = new Error(true, 2, "error B");
        errorB.print();
        Error errorC = new Error(true, 3, "error C");
        errorC.print();
    }
}
