package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String college;

    public Engineer(String name, String surname, String education, String birthday, String college) {
        super(name, surname, education, birthday);
        this.college = college;
    }

    public String getCollege() {
        return college;
    }
}
