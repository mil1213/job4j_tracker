package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
         this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> nameCheck = n -> n.getName().contains(key);
        Predicate<Person> surnameCheck = n -> n.getSurname().contains(key);
        Predicate<Person> phoneCheck = n -> n.getPhone().contains(key);
        Predicate<Person> adressCheck = n -> n.getAddress().contains(key);
        Predicate<Person> combine = n -> nameCheck.or(surnameCheck).or(phoneCheck).or(adressCheck).test(n);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
