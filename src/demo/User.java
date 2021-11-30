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
            if (user.users.equals(userName) && user.password.equals(userPassword)){
                ui.printMessage("Du er nu logget in " + userName);
                completed = true;
            }
        }

        if (completed == false){
            ui.printMessage("Forkert brugernavn eller kode!");
        }
        return completed;
    }

    public void usersLogin(){
        User admin = new User("admin", "admin");
        User accounting = new User("accounting", "accounting");
        User coach = new User("coach", "1234");

        users.add(admin);
        users.add(accounting);
        users.add(coach);
    }
}
