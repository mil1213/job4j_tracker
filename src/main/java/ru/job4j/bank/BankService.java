package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшего банковского сервиса
 * @author Author
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов и привязанных к ним счетов осуществляется в коллекции типа HashMap
     * ключ - клиент типа User, значение - счета клиента в коллекции типа List
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя, если его нет в списке клиентов
     * @param user клиент, который добавляется
     */
    public void addUser(User user) {
       users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавляет счет в список счетов клиента, если такой клиент есть в списке,
     * и если у клиента нет данного счета в списке
     * @param passport паспорт клиента, по которому проверяется наличие клиента в списке
     * @param account счет, который добавляем
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет клиента по паспорту в списке клиентов
     * @param passport паспорт искомого клиента
     * @return возвращает клиента или null, если клиента нет в списке
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет счет по заданным реквизитам у клиента, который есть в списке
     * @param passport паспорт клиента
     * @param requisite реквизиты счета
     * @return возвращает счет или null, если клиента или счета нет в списке
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод переводит деньги со счета на счет, изменяет баланс счетов
     * @param srcPassport паспорт клиента - отправителя
     * @param srcRequisite реквизиты счета - отправителя
     * @param destPassport паспорт клиента - получателя
     * @param destRequisite реквизиты счета - получателя
     * @param amount сумма, которая переводится
     * @return возвращает true, если баланс счетов изменился, и false,
     * если один из счетов null или баланс счета-отправителя меньше
     * суммы перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                              String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}