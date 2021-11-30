package ui;

import java.util.Scanner;

public class Userinterface {

    Scanner sc = new Scanner(System.in);
    Colours colour = new Colours();

    public void printMenu() {
        System.out.println("""
                
                Tast 1) - Opret nyt medlem.
                Tast 2) - Vis medlemmer.
                Tast 3) - Vis medlemmer i restance.
                Tast 4) - Slet medlem.
                Tast 5) - Vis resultater.""");


    }

    public void printWelcome(){
        System.out.println(colour.colourBlue("Delfinen Svømmeklub."));
    }

    public String userInputText(){
        return sc.nextLine();
    }

    public int userInputNumber(){
        return sc.nextInt();
    }

    public void printMessage(String s){
        System.out.println(s);
    }

    public void printDefaultMessage(){
        System.out.println("Ukendt kommando");
    }
}
