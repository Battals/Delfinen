package main;

import demo.Accounting;
import domain.Controller;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        //talte måneder siden sidste start
        //Derefter, gangede måneder, samt subplan og addede til debt
        System.out.println(LocalDate.now().compareTo(LocalDate.of(1999,7,29)));

        Controller db = new Controller();
        db.start();
    }
}
