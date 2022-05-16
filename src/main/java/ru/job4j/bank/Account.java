package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Author
 * @version 1.0
 */
public class Account {
    /**
     * Банковский счет определяется полями:
     * реквизиты - переменная типа String;
     * баланс счета - переменная типа double;
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для получения значения поля счета - реквизит
     * @return возвращает реквизит счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для присвоения или изменения поля счета - реквизит
     * @param requisite реквизиты, присваиваемые счету
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения значения поля счета - баланс
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для присвоения или изменения поля счета - баланс
     * @param balance баланс, присваиваемый счету
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод принимает на вход счет и сравнивает его со счетом,
     * у которого вызывается метод, по реквизитам счета
     * @param o счет, с которым производится сравнение
     * @return true, если реквизиты счетов равны, или false, реквизиты
     * счетов не равны, если счет пустой или типы счетов не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод принимает на вход реквизиты счета
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}