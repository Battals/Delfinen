package ui;

import java.time.LocalDate;
import java.util.Scanner;

public class Userinterface {

    Scanner sc = new Scanner(System.in);
    Colours colour = new Colours();

    public int userInputNumber() {
        return intScanner();
    }

    public void printObject(Object object){
        System.out.println(object);
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void printWelcome() {
        printMessage(colour.colourBlue("Delfinen Svømmeklub."));
    }

    public void printDefaultMessage() {
        printMessage("Ukendt kommando");
    }

    public String userInput() {
        return sc.nextLine();
    }

    public int intScanner() {
        String input = sc.nextLine();
        while (!input.matches("\\d+")) {
            printMessage("please type a number: ");
            input = sc.nextLine();
        }
        return Integer.parseInt(input);
    }

    public LocalDate typeDate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("year(YYYY): ");
        int year = sc.nextInt();
        while (year > LocalDate.now().getYear() || year < (LocalDate.now().getYear()) - 110) {
            System.out.println("invalid birth year");
            year = sc.nextInt();
        }
        System.out.print("month(MM): ");
        int month = sc.nextInt();
        while (month > 12 || month < 1) {
            System.out.println("invalid month");
            month = sc.nextInt();
        }
        System.out.println("day(DD): ");
        int day = sc.nextInt();
        while (day > 31 || day < 1) {
            System.out.println("invalid day");
            day = sc.nextInt();
        }

        return LocalDate.of(year, month, day);
    }

    public boolean yesOrNo(){
        Scanner sc = new Scanner(System.in);
        printMessage("Ja/Nej");
        String answer = sc.nextLine().toLowerCase();
        while (!answer.equals("ja") && !answer.equals("nej")) {
            printMessage("Skriv venligt 'ja' eller 'nej'");
            answer = sc.nextLine();
        }
        return answer.equals("ja");
    }
}