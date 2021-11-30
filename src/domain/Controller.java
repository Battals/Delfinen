package domain;

import demo.*;
import ui.Colours;
import ui.Userinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    boolean run = true;

    User currentUser;
    Userinterface ui = new Userinterface();
    Colours colours = new Colours();
    Accounting accounting = new Accounting();


    public ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Member> restanceList = new ArrayList<>();

    ArrayList<Member> membersJunior;
    ArrayList<Member> membersSenior;

    public void login(){
        String username;
        String password;

        currentUser = fileHandler.registerLogin();
    }
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
                        getMemberList();
                        break;
                    case 3:
                        getrestanceList();
                        break;
                    case 4:
                        getMemberNames();
                        deleteMember();
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
                    //instance of Accountant("Hello welcome")
                    // else { "Only for accountants" }
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

    private int idGenerator(){
        int id;
        Random random = new Random();
        id = random.nextInt(9999);
        boolean invalid = true;
        while(invalid) {
            int duplicates = 0;
            id = random.nextInt(9999);
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getMemberID() == id) {
                    duplicates++;
                }
            }
            if(duplicates==0){
                invalid = false;
            }
        }
        return id;
    }

    public void createMember() {
        int memberID = memberList.size() + 1;
        int subscription = 0;
        int payment = 0;
        String swimmerType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fulde navn: ");
        String name = scanner.nextLine();
        System.out.println("Fødselsår?" + " Indtast [åååå]");
        int year = scanner.nextInt();
        System.out.println("Fødselsmåned? [mm]");
        int month = scanner.nextInt();
        System.out.println("Fødselsdag? [dd]");
        int day = scanner.nextInt();
        LocalDate age = LocalDate.of(year, month, day);
        if (LocalDate.now().getYear() - age.getYear() < 18) {
            subscription = 1000;
            swimmerType = "Juniorsvømmer";
        } else if (LocalDate.now().getYear() - age.getYear() > 60) {
            swimmerType = "Seniorsvømmer";
            subscription = 1200;
        } else {
            subscription = 1600;
            swimmerType = "Seniorsvømmer";

        }

        System.out.println("Kontigent = " + subscription);
        System.out.println("Ønsker medlemmet at betale nu? - Ja/Nej");
        String input = scanner.next();
        if (input.equalsIgnoreCase("Ja")) {
            payment = (+subscription);
        } else if (input.equalsIgnoreCase("Nej")) {
            payment = (subscription - subscription * 2);
        }

        System.out.println("Hvilken kategori tilhører medlemmet?");
        System.out.println("1. Konkurrencesvømmer");
        System.out.println("2. Motionist");
        System.out.println("3. Passiv");
        String memberType;


        switch (enterDigit()) {
            case 1:
                memberType = "Konkurrencesvømmer";
                Competitive competitive = new Competitive(memberID, name, age, subscription, memberType, swimmerType, payment);
                memberList.add(competitive);
                if (payment <= 0) {
                    restanceList.add(competitive);
                }

                break;
            case 2:
                memberType = "Motionist";
                Exerciser exerciser = new Exerciser(memberID, name, age, subscription, memberType, swimmerType, payment);
                memberList.add(exerciser);
                if (payment < 0) {
                    restanceList.add(exerciser);
                }
                break;
            case 3:
                memberType = "Passiv";
                subscription = 500;
                Passive passive = new Passive(memberID, name, age, subscription, memberType, swimmerType, payment);
                memberList.add(passive);
                if (payment < 0) {
                    restanceList.add(passive);
                }
                break;

        }


    }

    public void deleteMember() {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        System.out.println("Indtast ID på medlemmet du ønsker at slette: ");

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberID() == enterDigit()) {
                System.out.println("Ønsker du at slette medlemmet " + memberList.get(i).getName() + "?");
                System.out.println("Indtast - Ja/Nej");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("Ja")) {
                    memberList.remove(i);
                    ui.printMessage(colours.colourRed("Medlem er slettet"));
                    break;
                } else if (input.equalsIgnoreCase("Nej")) {
                    break;
                }
            }
        }

    }


    public void getrestanceList() {
        for (int i = 0; restanceList.size() < 0; i++) {
            System.out.println(restanceList.get(i).getName());
        }
        if (restanceList.isEmpty()) {
            System.out.println("Ingen medlemmeri restance");
        }
    }

    public void getMemberList() {
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i));
        }
        if (memberList.isEmpty()) {
            System.out.println("Der findes ingen medlemmer");
        }
    }

    public void getMemberNames() {
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(colours.colourGreen("ID: " + memberList.get(i).getMemberID()) + " / Navn: " + memberList.get(i).getName());
        }
    }


}
