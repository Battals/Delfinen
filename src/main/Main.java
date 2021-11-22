package main;

import domain.Controller;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {

        System.out.println(LocalDate.now().compareTo(LocalDate.of(1999,7,29)));
        Controller db = new Controller();
        db.start();
    }
}
