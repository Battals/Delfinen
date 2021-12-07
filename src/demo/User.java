package demo;

import ui.Userinterface;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Object login(){
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
                completed = true;
                return user;
                }
            }
        if (!completed){
            ui.printMessage("Forkert brugernavn eller kode!");
        }
        return user;
    }

    public void usersLogin(){
        User Chairman;
        User Accounting;
        User Coach;

        Chairman chairmanAccount = new Chairman("admin", "1234");
        Accounting accountControl = new Accounting("acc", "1234");
        //Coach coachControl = new Coach("coach", "1234");

        users.add(chairmanAccount);
        users.add(accountControl);
        //users.add(Coach);
    }

}
