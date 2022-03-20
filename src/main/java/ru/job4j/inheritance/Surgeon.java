package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private Pacient pacient;

    public Surgeon(String name, String surname, String education, String birthday, String hospital) {
        super(name, surname, education, birthday, hospital);
        this.pacient = pacient;
    }

    public Pacient toHeal() {
        Pacient pacient = new Pacient("Ivanov Ivan", "Appendicitis");
        return pacient;
    }
}
