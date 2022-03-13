package ru.job4j.inheritance;

public class Builder extends Engineer {

    Project project;

    public Builder(String name, String surname, String education, String birthday, String college) {
        super(name, surname, education, birthday, college);
        this.project = project;
    }
}
