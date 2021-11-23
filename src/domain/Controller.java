package domain;

import demo.Accounting;
import demo.Member;
import ui.Colours;
import ui.Userinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    boolean run = true;

    Userinterface ui = new Userinterface();
    Accounting accounting = new Accounting();

    ArrayList<Member> membersJunior;
    ArrayList<Member> membersSenior;


    public void start() {

        ui.printWelcome();

        while (run) {
            try {
                ui.printMenu();
                switch(ui.userInputNumber()) {
                    case 1:
                        //Opretmedlem
                        break;
                    case 2:
                        //Vismedlemmer
                        break;
                    case 3:
                        //Sletmedlem
                        break;
                    case 4:
                        //Adm resultater
                        break;
                    case 5:
                        //Vis resultater
                        break;

                    default:
                        ui.printDefaultMessage();
                        break;


                }

            } catch (InputMismatchException e){
                System.out.println("Ukendt tegn");
            }
        }
    }

    public void distributeMembers(ArrayList<Member> members){
        for(int i = 0; i < members.size(); i++){
            if(LocalDate.now().compareTo(members.get(i).getAge())>=18){
                membersSenior.add(members.get(i));
            }
            if(LocalDate.now().compareTo(members.get(i).getAge())<18) {
                membersJunior.add(members.get(i));
            }
        }
    }

    public void holdopdeler(ArrayList<Member> members){

    }

    public void accountControl(){
        while (run){
            switch (ui.userInputNumber()){
                case 1:
                    //Overblik over inkomst til klubben
                    break;
                case 2:
                    //Se listen over medlemmer der i restance
                    break;
                case 3:
                    //Se listen over priserne
                    break;
            }
        }
    }
}
