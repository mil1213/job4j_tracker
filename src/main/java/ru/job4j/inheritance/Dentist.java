package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private Pacient pacient;

    public Dentist(String name, String surname, String education, String birthday, String hospital) {
        super(name, surname, education, birthday, hospital);
        this.pacient = pacient;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public String namePacient() {
        Pacient pacient = new Pacient("Korolev Petr", "Сaries 4");
        return pacient.getDiagnos();
    }
}
