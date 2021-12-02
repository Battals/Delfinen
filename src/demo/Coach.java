package demo;

import java.util.ArrayList;

public class Coach {

    private int id;
    private String name;

    public ArrayList<Coach> coaches = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Coach(int id, String name){
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString(){
    return "ID: " + id + " - " + "Trænerens navn: " + name;
    }





}
