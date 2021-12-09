package domain;

import database.FileHandler;
import demo.*;
import demo.Record;
import ui.Colours;
import ui.Userinterface;

import java.util.ArrayList;

public class Controller {

    boolean run = true;

    Userinterface ui = new Userinterface();
    Colours colours = new Colours();
    FileHandler fileHandler = new FileHandler();
    User user;

    public ArrayList<Member> memberList = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();
    public ArrayList<Record> recordList = new ArrayList<>();


    public void programStart() {
        memberList = fileHandler.getMembers();
        userList = fileHandler.getUsers();
        recordList = fileHandler.getRecords();
        user = new User(fileHandler.getUsers());
    }

    public void start() {
        ui.printWelcome();
        MemberList.programStart();
        programStart();
        Object loginUser = user.login();
        while (run) {
            if (loginUser instanceof Chairman) {
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Formand."));
                chairmanControl();
                break;
            } else if (loginUser instanceof Accounting) {
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Kasserer."));
                accountControl();
                break;
            } else if (loginUser instanceof Coach){
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Træner"));
                coachControl();
            } else if (loginUser == null){
                ui.printMessage(colours.colourRed("Forkert brugernavn eller kode!"));
                ui.printMessage("Prøv igen.");
                loginUser = user.login();


            }

        }

    }

    public void chairmanControl() {
        Chairman chairman = new Chairman("admin", "1234");
        while (run) {
            chairman.chairmanMenu();
            switch (ui.userInputNumber()) {
                case 1 ->
                        //Oprette medlem
                        chairman.createMember();
                case 2 ->
                        //Få listen over medlemmer
                        chairman.getMemberList();
                case 3 ->
                        //Slet medlem
                        chairman.deleteMember();
                case 4 ->
                        //Redigere på medlem
                        chairman.editMember();
                case 5 ->
                        //Opret en ny coach
                        chairman.createCoach();
                case 9 -> {
                        ui.printMessage("Logger ud");
                        //Starter forfra
                        start();
                }
                case 0 ->
                        //Slutter systemet
                        System.exit(0);
                default ->
                        ui.printDefaultMessage();
            }
        }
    }
    public void accountControl() {
        Accounting accounting = new Accounting("acc", "1234");
        while (run) {
            accounting.accountMenu();
            switch (ui.userInputNumber()) {
                case 1 ->
                        //Overblik over inkomst til klubben
                        accounting.printMonthlyIncome(memberList);
                case 2 ->
                        //Se listen over medlemmer der i restance
                        accounting.printDebtors();
                case 3 ->
                        //Se listen over priserne
                        accounting.subscriptionPrint();
                case 9 -> {
                        ui.printMessage("Logger ud");
                        //Starter forfra
                        start();
                }
                case 0 ->
                        //Slutter systemet
                        System.exit(0);
                default ->
                        ui.printDefaultMessage();
            }
        }
    }
    public void coachControl(){
        Coach coach = new Coach("coach","1234", 1, "test");
        while (run) {
            coach.printCoachMenu();
            switch (ui.userInputNumber()) {
                case 1 ->
                    //Tjek resultater
                    coach.checkTopFive(recordList);

                case 2 ->
                        //Tjek svømmers bedste tid
                    coach.checkPlayerResult(memberList, recordList);

                case 9 -> {
                        ui.printMessage("Logger ud");
                        //Starter forfra
                        start();
                }
                case 0 ->
                        //Slutter systemet
                        System.exit(0);
                default ->
                        ui.printDefaultMessage();
            }
        }
    }
}
