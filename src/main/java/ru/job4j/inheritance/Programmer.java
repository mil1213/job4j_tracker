package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private Project project;

    public Programmer(String name, String surname, String education, String birthday, String college) {
        super(name, surname, education, birthday, college);
        this.project = project;
    }

    public Project doProject() {
        Project project = new Project("ERP 1.0", "2015");
        return project;
    }
}
