package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                rsl = users[i];
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User was not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if ((user.isValid() == false) || (user.getUsername().length() < 3)) {
            rsl = false;
            throw new UserInvalidException("User is not valid");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
        User[] users = {new User("Petr Arsentev", true)};
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException ea) {
            ea.printStackTrace();
        }
    }
}
