package domain;

import database.FileHandler;
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

    FileHandler fileHandler = new FileHandler();
    public ArrayList<Coach> coaches = new ArrayList<>();


    User user = new User();

    //fileHandler.addObject();
    //hver gang et nyt objekt laves

    //fileHandler.editObject();
    //Hver gang et objekt redigeres

    //fileHandler.deleteObject();
    //Behøver vi ikke, maybe idk


    public ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Member> restanceList = new ArrayList<>();

    public void programStart() {
        memberList = fileHandler.getMembers();
    }


    ArrayList<Member> membersJunior;
    ArrayList<Member> membersSenior;

    public void login() {
        String username;
        String password;

        //currentUser = fileHandler.registerLogin();
    }

    public void start() {
        ui.printWelcome();
        MemberList.programStart();
        user.usersLogin();
            while (true) {
                if (user.login()) break;

            }
            accountControl();
            chairmanControl();

    }

    /*public void start() {
        ui.printWelcome();
        MemberList.programStart();
        user.usersLogin();


        while (run) {
            while (user.login() == false){

            }

            chairmanControl();
            accountControl();
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
                        //getrestanceList();
                        accountControl();
                        break;
                    case 4:
                        getMemberNames();
                        deleteMember();
                        break;
                    case 5:
                        createCoach();
                        break;
                    case 6:
                        editMember();
                        break;
                    default:
                        ui.printDefaultMessage();
                        break;


                }

            } catch (InputMismatchException e) {
                System.out.println("Ukendt tegn");
            }
        }
    }*/

    public void chairmanControl() {
        Chairman chairman = new Chairman("admin", "1234");
        while (run) {
            chairman.chairmanMenu();
            switch (ui.userInputNumber()) {
                case 1 -> chairman.createMember();
                case 2 -> chairman.getMemberList();
                case 3 -> chairman.deleteMember();
                case 4 -> chairman.editMember();
                case 9 -> {
                    ui.printMessage("Logger ud");
                    start();
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Ukendt tegn!");
            }
        }
    }

    public void accountControl() {
        Accounting accounting = new Accounting("acc", "1234");
        while (run) {
            accounting.accountMenu();
            switch (ui.userInputNumber()) {
                case 1:
                    //Overblik over inkomst til klubben
                    //instance of Accountant("Hello welcome")
                    // else { "Only for accountants" }

                    break;
                case 2:
                    //Se listen over medlemmer der i restance
                    accounting.printDebtors();
                    break;
                case 3:
                    //Se listen over priserne
                    accounting.subscriptionPrint();
                    break;
                case 9:
                    ui.printMessage("Logger ud");
                    start();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Ukendt tegn!");
            }
        }
    }

    /*public void distributeMembers(ArrayList<Member> members) {
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

    private int enterDigit() {
        Scanner sc = new Scanner(System.in);
        String tekst = sc.nextLine();
        return Integer.parseInt(tekst);
    }

    private int idGenerator() {
        Random random = new Random();
        int id = random.nextInt(9999);
        boolean invalid = true;
        while (invalid) {
            int duplicates = 0;
            id = random.nextInt(9999);
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getId() == id) {
                    duplicates++;
                }
            }
            if (duplicates == 0) {
                invalid = false;
            }
        }
        return id;
    }

    public void createMember() {
        ui.printMessage("Fulde navn:");
        String name = ui.userInput();
        ui.printMessage("Fødseldato: ");
        LocalDate age = ui.typeDate();
        ui.printMessage("Aktivt medlemskab?");
        boolean active = ui.yesOrNo();
        ui.printMessage("Er medlemmet konkurrence svømmer?");
        boolean isComp = ui.yesOrNo();
        int id = idGenerator();
        //(int id, String name, LocalDate age, boolean active)
        Member member;
        if (isComp) {
            member = createCompetitiveMember(name, age, true);
        } else {
            member = new Member(name, age, active);
        }
        memberList.add(member);
        fileHandler.addObject(member);
    }

    public MemberCompetitive createCompetitiveMember(String name, LocalDate age, boolean active) {
        Scanner sc = new Scanner(System.in);
        ui.printMessage("Udøvende svømmediscipliner.");
        ArrayList<Discipline> disciplines = new ArrayList<>();
        ui.printMessage("Crawl?");
        if (ui.yesOrNo()) {
            disciplines.add(Discipline.CRAWL);
        }
        ui.printMessage("Rygcrawl?");
        if (ui.yesOrNo()) {
            disciplines.add(Discipline.RYGCRAWL);
        }
        ui.printMessage("Butterfly?");
        if (ui.yesOrNo()) {
            disciplines.add(Discipline.BUTTERFLY);
        }
        ui.printMessage("Brystswømning?");
        if (ui.yesOrNo()) {
            disciplines.add(Discipline.BREASTSTROKE);
        }
        printCoaches();
        ui.printMessage("Vælg en træner ");
        int coachID = sc.nextInt();
        Coach coach = null;
        boolean invalidCoach = true;
        while (invalidCoach) {
            for (int i = 0; i < coaches.size(); i++) {
                if (coachID == coaches.get(i).getId()) {
                    coach = coaches.get(i);
                    invalidCoach = false;
                }
            }
        }
        return new MemberCompetitive(name, age, active, coach, disciplines);
    }

    public void printCoaches() {
        for (int i = 0; i < coaches.size(); i++) {
            System.out.println(coaches.get(i));
        }
        if (coaches.isEmpty()) {
            ui.printMessage("Der findes ingen trænere");
        }
    }

    public void createCoach() {
        Coach coach;
        int id = coaches.size() + 1;
        ui.printMessage("Trænerens navn:");
        String name = ui.userInput();
        coach = new Coach(id, name);
        coaches.add(coach);
    }


    public void deleteMember() {
        Scanner sc = new Scanner(System.in);
        boolean a = false;
        boolean b = false;
        System.out.println("Indtast ID på medlemmet du ønsker at slette: ");

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == enterDigit()) {
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


    public void editMember() {
        getMemberList();
        //if(member instanceof CompetitiveMember)
        ui.printMessage("Indtast ID på medlemmet du ønsker at redigere.");
        int member = ui.intScanner();
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == member) {
                ui.printMessage(memberList.get(i).toString());
                ui.printMessage("Hvad ønsker du at ændre?");
                ui.printMessage("""
                        Tast 1) - For at ændre navn
                        Tast 2) - For at ændre fødselsdagsdato 
                        Tast 3) - For at ændre status (aktiv/passiv)""");
                switch (ui.intScanner()) {
                    case 1:
                        ui.printMessage("Indtast nyt navn: ");
                        String name = ui.userInput();
                        memberList.get(i).setName(name);
                        ui.printMessage("Navnet er ændret: ");
                        fileHandler.editObject(memberList.get(i));
                        break;
                    case 2:
                        ui.printMessage("Indtast ny alder: ");
                        LocalDate alder = ui.typeDate();
                        memberList.get(i).setAge(alder);
                        fileHandler.editObject(memberList.get(i));
                        ui.printMessage("Alder ændret");
                        break;
                    case 3:
                        ui.printMessage("Ændre medlemmets status til aktiv - tast ja");
                        ui.printMessage("Ændre medlemmets status til passiv - tast nej");
                        String input = ui.userInput();
                        if (input.equalsIgnoreCase("ja")) {
                            memberList.get(i).setActive(true);
                        } else if (input.equalsIgnoreCase("nej")) {
                            memberList.get(i).setActive(false);
                        }
                        fileHandler.editObject(memberList.get(i));
                        ui.printMessage("Status ændret");
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
            System.out.println(colours.colourGreen("ID: " + memberList.get(i).getId()) + " / Navn: " + memberList.get(i).getName());
        }
    }

    public LocalDate typeDate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fødselsår(ÅÅÅÅ): ");
        int year = sc.nextInt();
        while (year > LocalDate.now().getYear() || year < (LocalDate.now().getYear()) - 110) {
            System.out.println("Ukendt år");
            year = sc.nextInt();
        }
        System.out.print("Fødselsmåned(MM): ");
        int month = sc.nextInt();
        while (month > 12 || month < 1) {
            System.out.println("Ukendt måned");
            month = sc.nextInt();
        }
        System.out.println("Dag(DD): ");
        int day = sc.nextInt();
        while (day > 31 || day < 1) {
            System.out.println("Ukendt dag");
            day = sc.nextInt();
        }

        return LocalDate.of(year, month, day);
    }*/


}
