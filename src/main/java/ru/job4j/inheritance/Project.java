package ru.job4j.inheritance;

public class Project {

    private String description;
    private String year;

    public Project(String description, String year) {
        this.description = description;
        this.year = year;
    }

    public String showInfoProject() {
        return "Information about project" + year + description;
    }
}
