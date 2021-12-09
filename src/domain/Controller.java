package domain;

import database.FileHandler;
import demo.*;
import demo.Record;
import ui.Colours;
import ui.Userinterface;

import java.util.ArrayList;

public class Controller {

    /**
     *
     * @author Abdallah Ha
     * @author Ahsan Masood Iqbal
     * @author Battal R. Ozcan
     * @author Rashaun Godding
     *
     */

    boolean run = true;

    Userinterface ui = new Userinterface();
    Colours colours = new Colours();
    FileHandler fileHandler = new FileHandler();
    User user;

    public ArrayList<Member> memberList = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();
    public ArrayList<Record> recordList = new ArrayList<>();
    public ArrayList<Coach> coachList = new ArrayList<>();


    public void programStart() {
        memberList = fileHandler.getMembers();
        userList = fileHandler.getUsers();
        recordList = fileHandler.getRecords();
        user = new User(fileHandler.getUsers());
        coachList = user.getCoaches();
    }

    public void start() {
        ui.printWelcome();
        MemberList.programStart();
        programStart();
        Object loginUser = user.login();
        while (run) {
            if (loginUser instanceof Chairman) {
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Formand."));
                chairmanControl((Chairman) loginUser);
                break;
            } else if (loginUser instanceof Accounting) {
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Kasserer."));
                accountControl((Accounting) loginUser);
                break;
            } else if (loginUser instanceof Coach){
                ui.printMessage(colours.colourWhite("Du er nu logget ind som Træner"));
                coachControl((Coach) loginUser);
            } else if (loginUser == null){
                ui.printMessage(colours.colourRed("Forkert brugernavn eller kode!"));
                ui.printMessage("Prøv igen.");
                loginUser = user.login();


            }

        }

    }

    public void chairmanControl(Chairman chairman) {
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
    public void accountControl(Accounting accounting) {
        while (run) {
            accounting.accountMenu();
            switch (ui.userInputNumber()) {
                case 1 ->
                        //Overblik over indkomst til klubben
                        accounting.printAnnualIncome(memberList);
                case 2 ->
                        //Se listen over medlemmer der i restance
                        accounting.printDebtors();
                case 3 ->
                        //Se listen over priserne
                        accounting.subscriptionPrint();
                case 4 ->
                        //Se svømmers pris
                accounting.printMemberPrice(memberList);
                case 5 ->
                        //Bruger kan betale
                accounting.payPlayerDebt(memberList);
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
    public void coachControl(Coach coach){
        while (run) {
            coach.printCoachMenu();
            switch (ui.userInputNumber()) {
                case 1 ->
                        //Tjek resultater
                        coach.checkTopFive(recordList);

                case 2 ->
                        //Tjek svømmers bedste tid
                        coach.checkPlayerResult(memberList, recordList);
                case 3 ->
                        //Tilføj rekord
                        coach.addRecord(memberList);

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
