package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan");
        student.setGroup("059");
        student.setDateEntrance("01.09.2000");
        System.out.println(student.getName() + " studes at group " + student.getGroup()
        + " from " + student.getDateEntrance());
    }
}
