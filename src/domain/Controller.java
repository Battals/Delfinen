package domain;

import demo.*;
import ui.Colours;
import ui.Userinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    boolean run = true;

    Userinterface ui = new Userinterface();
    Colours colours = new Colours();
    Accounting accounting = new Accounting();
    public ArrayList<Member> memberList = new ArrayList<>();

    ArrayList<Member> membersJunior;
    ArrayList<Member> membersSenior;


    public void start() {

        ui.printWelcome();

        while (run) {
            try {
                ui.printMenu();
                switch (ui.userInputNumber()) {
                    case 1:
                        createMember();
                        System.out.println("Medlem oprettet");
                        break;
                    case 2:
                        //Vismedlemmer
                        break;
                    case 3:
                        deleteMember();
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

            } catch (InputMismatchException e) {
                System.out.println("Ukendt tegn");
            }
        }
    }

    public void distributeMembers(ArrayList<Member> members) {
        for (int i = 0; i < members.size(); i++) {
            if (LocalDate.now().compareTo(members.get(i).getAge()) >= 18) {
                membersSenior.add(members.get(i));
            }
            if (LocalDate.now().compareTo(members.get(i).getAge()) < 18) {
                membersJunior.add(members.get(i));
            }
        }
    }

    public void holdopdeler(ArrayList<Member> members) {

    }

    public void accountControl() {
        while (run) {
            switch (ui.userInputNumber()) {
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

    private int enterDigit() {
        Scanner sc = new Scanner(System.in);
        String tekst = sc.nextLine();
        return Integer.parseInt(tekst);
    }

    public void createMember() {
        int memberID = memberList.size() + 1;
        int subscription = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Navn: ");
        String name = scanner.nextLine();
        System.out.println("Fødselsår?" + "Indtast år-mm-dd");
        int year = scanner.nextInt();
        System.out.println("Fødselsmåned?");
        int month = scanner.nextInt();
        System.out.println("Fødselsdag?");
        int day = scanner.nextInt();
        LocalDate age = LocalDate.of(year, month, day);
        if (LocalDate.now().getYear() - age.getYear() < 18) {
            subscription = 1000;
        } else if (LocalDate.now().getYear() - age.getYear() > 60) {
            subscription = 1200;
        } else {
            subscription = 1600;
        }

        System.out.println("Hvilken kategori tilhører medlemmet?");
        System.out.println("1. Konkurrencesvømmer");
        System.out.println("2. Motionist");
        System.out.println("3. Passiv");
        String memberType;
        switch (enterDigit()) {
            case 1:
                memberType = "Konkurrencesvømmer";
                Competitive competitive = new Competitive(memberID, name, age, subscription, memberType);
                memberList.add(competitive);
                break;
            case 2:
                memberType = "Motionist";
                Exerciser exerciser = new Exerciser(memberID, name, age, subscription, memberType);
                memberList.add(exerciser);
                break;
            case 3:
                memberType = "Passiv";
                subscription = 500;
                Passive passive = new Passive(memberID, name, age, subscription, memberType);
                memberList.add(passive);
                break;

        }
    }

    public void deleteMember() {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        System.out.println("Medlemmets ID: ");
        while (a = false) {
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getMemberID() == enterDigit()) {
                    System.out.println("Ønsker du at slette medlemmet med ID\n" + memberList.get(i));
                    System.out.println("Ja/Nej");
                    while (b = false) {
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("Ja")) {
                            memberList.remove(i);
                            System.out.println(colours.colourRed("Medlem med ID " + i + " er slettet"));
                            b = true;
                        } else if (input.equalsIgnoreCase("Nej")) {
                            b = true;
                        }
                    }
                }

            }
        }


    }


}
