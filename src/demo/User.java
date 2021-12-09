package demo;

import ui.Userinterface;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    String user;
    String password;

    private final ArrayList<User> users = new ArrayList<>();
    Userinterface ui = new Userinterface();

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }


    public User(ArrayList<User> users) {
        this.users.addAll(users);
    }

    @Override
    public String toString() {
        return user + " : " + password;
    }

    public Object login() {
        Scanner login = new Scanner(System.in);
        String userName;
        String userPassword;

        ui.printMessage("Indtast brugernavn: ");
        userName = login.nextLine();

        ui.printMessage("Indtast kode: ");
        userPassword = login.nextLine();

        for (User user : users) {
            if (user.user.equals(userName) && user.password.equals(userPassword)) {
                return user;
            }
        }
        return user;
    }

}
