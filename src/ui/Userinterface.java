package ui;

import java.time.LocalDate;
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

    public String userInput(){
        return sc.nextLine();
    }

    public int userInputNumber(){
        return intScanner();
    }

    public void printMessage(String s){
        System.out.println(s);
    }

    public void printDefaultMessage(){
        System.out.println("Ukendt kommando");
    }
    public int intScanner(){
        String input = sc.nextLine();
        while(!input.matches("\\d+")){
            System.out.print("please type a number: ");
            input = sc.nextLine();
        }
        return Integer.parseInt(input);
    }
    public LocalDate typeDate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("year(YYYY): ");
        int year = sc.nextInt();
        while(year > LocalDate.now().getYear() || year < (LocalDate.now().getYear()) - 110){
            System.out.println("invalid birth year");
            year = sc.nextInt();
        }
        System.out.print("month(MM): ");
        int month = sc.nextInt();
        while(month > 12 || month < 1){
            System.out.println("invalid month");
            month = sc.nextInt();
        }
        System.out.println("day(DD): ");
        int day = sc.nextInt();
        while(day > 31 || day < 1){
            System.out.println("invalid day");
            day = sc.nextInt();
        }

        return LocalDate.of(year, month, day);
    }
    public boolean yesOrNo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ja/Nej");
        String answer = sc.nextLine().toLowerCase();
        while(!answer.equals("ja") && !answer.equals("nej")){
            System.out.println("Skriv venligt 'ja' eller 'nej'");
            answer = sc.nextLine();
        }
        return answer.equals("ja");
    }
}
