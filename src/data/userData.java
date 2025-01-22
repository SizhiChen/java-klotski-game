package data;

import java.util.ArrayList;
import java.util.List;

public class userData {

    // Set the user data ArrayList
    private static final List<User> userData = new ArrayList<>();

    static {
        userData.add(new User("admin", "123456"));
    }

    public static boolean login(String username, String password) {
        for (User user : userData) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean usernameExit(String username) {
        for (User user : userData) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void addUser(String username, String password) {
        userData.add(new User(username, password));
    }
}
