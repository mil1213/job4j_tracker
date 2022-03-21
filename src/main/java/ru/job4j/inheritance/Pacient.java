package ru.job4j.inheritance;

public class Pacient {

    private String name;
    private String diagnos;

    public Pacient(String name, String diagnos) {
        this.name = name;
        this.diagnos = diagnos;
    }

    public String getName() {
        return name;
    }

    public String getDiagnos() {
        return diagnos;
    }
}
