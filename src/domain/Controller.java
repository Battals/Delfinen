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
    private ArrayList<Member> youthList = new ArrayList<>();
    private ArrayList<Member> seniorList = new ArrayList<>();

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
        Object loginUser = user.login();
        while (true) {
            if (Chairman.class.isInstance(loginUser)) {
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Formand."));
                chairmanControl();
                break;
            } else if (Accounting.class.isInstance(loginUser)) {
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Kasserer."));
                accountControl();
                break;
            } else if (Coach.class.isInstance(loginUser)){
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Træner"));
                coachControl();
            }

        }

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
                        login();
                        chairmanMenu


                        //createMember();
                        //System.out.println("Medlem oprettet");
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
                case 5 -> chairman.createCoach();
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
        AccountingSH accountingSH = new AccountingSH();
        while (run) {
            accounting.accountMenu();
            switch (ui.userInputNumber()) {
                case 1:
                    //Overblik over inkomst til klubben
                    //instance of Accountant("Hello welcome")
                    // else { "Only for accountants" }
                    accountingSH.annualPay();
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

    public void coachControl(){
        Coach coach = new Coach("coach","1234");
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


}
