package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод ищет клиента по паспорту в списке клиентов
     * @param passport паспорт искомого клиента
     * @return возвращает Optional клиента или пустой Optional, если клиента нет в списке
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет по заданным реквизитам у клиента, который есть в списке
     * @param passport паспорт клиента
     * @param requisite реквизиты счета
     * @return возвращает Optional счет или пустой Optional, если клиента или счета нет в списке
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent() && accountDest.isPresent() && accountSrc.get().getBalance() >= amount) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}