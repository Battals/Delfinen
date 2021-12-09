package demo;

import ui.Userinterface;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    /**
     *
     * @author Ahsan Masood Iqbal
     * @author Battal R. Ozcan
     *
     */

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

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Coach> getCoaches(){
        ArrayList<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < users.size(); i++){
            if(users.get(i) instanceof Coach){
                coaches.add((Coach) users.get(i));
            }
        }
        return coaches;
    }

    public String getData(){
        return user + "_" + password;
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
