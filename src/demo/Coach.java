package demo;

import java.util.ArrayList;

public class Coach extends User{

    private int id;
    private String name;

    public ArrayList<Coach> coaches = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Coach(String user, String password){
        super(user,password);
    }


    @Override
    public String toString(){
    return "ID: " + id + " - " + "Trænerens navn: " + name;
    }





}
