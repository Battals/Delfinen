package demo;

import ui.Userinterface;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    String user;
    String password;

    private ArrayList<User> users = new ArrayList<>();

    Userinterface ui = new Userinterface();

    public User(String user, String password){
        this.user = user;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return user + " : " + password;
    }

    public boolean login(){
        Scanner login = new Scanner(System.in);
        String userName;
        String userPassword;
        boolean completed;

        completed = false;

        ui.printMessage("Indtast brugernavn: ");
        userName = login.nextLine();

        ui.printMessage("Indtast kode: ");
        userPassword = login.nextLine();

        for (User user : users){
            if (user.user.equals(userName) && user.password.equals(userPassword)){
                ui.printMessage("Du er nu logget in " + userName);
                completed = true;
                break;
                }
            }
        if (!completed){
            ui.printMessage("Forkert brugernavn eller kode!");
        }
        return completed;
    }

    public void usersLogin(){
        User Chairman;
        User Accounting;
        User Coach;

        Chairman = new User("admin", "1234");
        Accounting = new User("acc", "1234");
        Coach = new User("coach", "1234");

        users.add(Chairman);
        users.add(Accounting);
        users.add(Coach);
    }
}
