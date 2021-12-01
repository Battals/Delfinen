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
    public ArrayList<Coach> coaches = new ArrayList<>();


    public ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Member> restanceList = new ArrayList<>();


    ArrayList<Member> membersJunior;
    ArrayList<Member> membersSenior;

    public void login(){
        String username;
        String password;

        //currentUser = fileHandler.registerLogin();
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
        Scanner sc = new Scanner(System.in);
        ui.printMessage("Fulde navn:");
        String name = sc.nextLine();
        ui.printMessage("Fødseldato: ");
        LocalDate age = typeDate();
        System.out.println("Aktivt medlemskab?");
        boolean active = ui.yesOrNo();
        ui.printMessage("Er medlemmet konkurrence svømmer?");
        boolean isComp = ui.yesOrNo();

        Member member;
        if (isComp){
            if (isComp){
                ui.printMessage("Opretter medlem");
                member = createCompetitiveMember(name, age, active);}
            else {
                ui.printMessage("Opretter motions medlem");
                member = new Member(name, age, active);


                System.out.println(member);
    }}}

    public void printCoaches(){
        for (int i = 0; i < coaches.size(); i++){
            System.out.println(coaches.get(i));
        }
    }

    public MemberCompetitive createCompetitiveMember(String name, LocalDate age, boolean active){
        Scanner sc = new Scanner(System.in);
        ui.printMessage("Udøvende svømmediscipliner.");
        ArrayList<Discipline> disciplines = new ArrayList<>();
        ui.printMessage("Crawl?");
        if(ui.yesOrNo()){
            disciplines.add(Discipline.CRAWL);
        }
        ui.printMessage("Rygcrawl?");
        if (ui.yesOrNo()){
            disciplines.add(Discipline.RYGCRAWL);
        }
        ui.printMessage("Butterfly?");
        if (ui.yesOrNo()){
            disciplines.add(Discipline.BUTTERFLY);
        }
        ui.printMessage("Brystswømning?");
        if (ui.yesOrNo()){
            disciplines.add(Discipline.BREASTSTROKE);
        }
        printCoaches();
        ui.printMessage("Vælg en træner ");
        int coachID = sc.nextInt();
        Coach coach = null;
        boolean invalidCoach = true;
        while(invalidCoach) {
            for (int i = 0; i < coaches.size(); i++) {
                if(coachID==coaches.get(i).getId()){
                    coach = coaches.get(i);
                    invalidCoach = false;
                }
            }
        }
        return new MemberCompetitive(name, age, active, coach, disciplines);
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
        for (int i = 0; i < restanceList.size(); i++) {
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

    public LocalDate typeDate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Fødselsår(ÅÅÅÅ): ");
        int year = sc.nextInt();
        while(year > LocalDate.now().getYear() || year < (LocalDate.now().getYear()) - 110){
            System.out.println("Ukendt år");
            year = sc.nextInt();
        }
        System.out.print("Fødselsmåned(MM): ");
        int month = sc.nextInt();
        while(month > 12 || month < 1){
            System.out.println("Ukendt måned");
            month = sc.nextInt();
        }
        System.out.println("Dag(DD): ");
        int day = sc.nextInt();
        while(day > 31 || day < 1){
            System.out.println("Ukendt dag");
            day = sc.nextInt();
        }

        return LocalDate.of(year, month, day);
    }


}
