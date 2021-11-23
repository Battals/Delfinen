package domain;

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
    Colours colour = new Colours();

    ArrayList<Member> membersJunior;
    ArrayList<Member> membersSenior;


    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println(colour.colourBlue("Delfinen Svømmeklub."));

        boolean run = true;
        while (run) {
            try {
                ui.printMenu();
                int input = sc.nextInt();
                switch(input) {
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
                        System.out.println("Ukendt kommando");
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
}
