package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDuplicate() {
        PassportOffice office = new PassportOffice();
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        office.add(citizen1);
        Citizen citizen2 = new Citizen("2f44a", "Petr Petrov");
        assertFalse(office.add(citizen2));
    }
}