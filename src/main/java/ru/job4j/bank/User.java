package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель клиента банка
 * @author Author
 * @version 1.0
 */
public class User {
    /**
     * Клинет определяется полями:
     * паспорт - переменная типа String;
     * имя - переменная типа String;
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения значения поля - паспорт клиента
     * @return возвращает паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для присвоения или изменения поля - паспорт
     * @param passport паспорт, присваиваемый клиенту
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения значения поля - имя клиента
     * @return возвращает имя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для присвоения или изменения поля - имя
     * @param username имя, присваиваемое клиенту
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод принимает на вход клиента и сравнивает его с клиентом,
     * у которого вызывается метод, по паспорту клиента
     * @param o клиент, с которым производится сравнение
     * @return true, если паспорта у клиентов равны, или false, если
     * паспорты не равны, если клиент пустой или типы клиентов не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод принимает на вход паспорт клиента
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}