package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Database {

    boolean run = true;

    Userinterface ui = new Userinterface();
    Colours colour = new Colours();


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

}
