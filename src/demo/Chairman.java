package demo;

import database.FileHandler;
import ui.Colours;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Chairman extends User {

    MemberList memberList = new MemberList();
    FileHandler fileHandler = new FileHandler();

    Colours colours = new Colours();

    public ArrayList<Coach> coaches = new ArrayList<>();


    public Chairman(String user, String password) {
        super(user, password);
    }

    public void chairmanMenu() {
        ui.printMessage("""
                                
                Tast 1) - Opret Medlem.
                Tast 2) - Vis Medlem.
                Tast 3) - Slet Medlem.
                Tast 4) - Ændre Medlem.
                Tast 5) - Opret træner.
                Tast 9) - Log ud
                Tast 0) - Slut program""");
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
        Member member;
        if (isComp) {
            member = createCompetitiveMember(name, age, true);
        } else {
            member = new Member(idGenerator(), name, age, active);
        }
        memberList.getMembers().add(member);
        fileHandler.addObject(member);
        ui.printMessage("Bruger oprettet: " + member);
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
            for (Coach value : coaches) {
                if (coachID == value.getId()) {
                    coach = value;
                    invalidCoach = false;
                } else if (coachID != value.getId()) {
                    ui.printMessage("Ukendt ID");
                    break;
                }
            }
        }
        return new MemberCompetitive(idGenerator(), name, age, active, coach, disciplines);
    }

    public void getMemberList() {
        for (int i = 0; i < memberList.getMembers().size(); i++) {
            ui.printObject(memberList.getMembers().get(i));
        }
        if (memberList.getMembers().isEmpty()) {
            ui.printMessage("Der findes ingen medlemmer");
        }
    }

    public void createCoach() {
        Coach coach;
        int id = coaches.size() + 1;
        ui.printMessage("Trænerens navn:");
        String name = ui.userInput();
        //coach = new Coach(id, name);
        //coaches.add(coach);
    }

    public void printCoaches() {
        if (coaches.isEmpty()) {
            ui.printMessage("Der findes ingen trænere.");
        } else {
            ui.printObject(coaches);
        }
    }


    public void deleteMember() {
        Scanner sc = new Scanner(System.in);
        ui.printMessage("Indtast ID på medlemmet du ønsker at slette: ");

        for (int i = 0; i < memberList.getMembers().size(); i++) {
            if (memberList.getMembers().get(i).getId() == ui.intScanner()) {
                ui.printMessage("Ønsker du at slette medlemmet " + memberList.getMembers().get(i).getName() + "?");
                ui.printMessage("Indtast - Ja/Nej");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("Ja")) {
                    memberList.getMembers().remove(i);
                    ui.printMessage(colours.colourRed("Medlem er slettet"));
                    break;
                } else if (input.equalsIgnoreCase("Nej")) {
                    break;
                }
            }
        }

    }

    public void editMember() {
        memberList.getMembers();
        //if(member instanceof CompetitiveMember)
        ui.printMessage("Indtast ID på medlemmet du ønsker at redigere.");
        int member = ui.intScanner();
        for (int i = 0; i < memberList.getMembers().size(); i++) {
            if (memberList.getMembers().get(i).getId() == member) {
                ui.printMessage(memberList.getMembers().get(i).toString());
                ui.printMessage("Hvad ønsker du at ændre?");
                ui.printMessage("""
                        Tast 1) - For at ændre navn
                        Tast 2) - For at ændre fødselsdagsdato 
                        Tast 3) - For at ændre status (aktiv/passiv)""");
                switch (ui.intScanner()) {
                    case 1 -> {
                        ui.printMessage("Indtast nyt navn: ");
                        String name = ui.userInput();
                        memberList.getMembers().get(i).setName(name);
                        ui.printMessage("Navnet er ændret til: " + name);
                        fileHandler.editObject(memberList.getMembers().get(i));
                    }
                    case 2 -> {
                        ui.printMessage("Indtast ny alder: ");
                        LocalDate alder = ui.typeDate();
                        memberList.getMembers().get(i).setAge(alder);
                        fileHandler.editObject(memberList.getMembers().get(i));
                        ui.printMessage("Alder ændret til: " + alder);
                    }
                    case 3 -> {
                        ui.printMessage("Ændre medlemmets status til aktiv - tast ja");
                        ui.printMessage("Ændre medlemmets status til passiv - tast nej");
                        String input = ui.userInput();
                        if (input.equalsIgnoreCase("ja")) {
                            memberList.getMembers().get(i).setActive(true);
                        } else if (input.equalsIgnoreCase("nej")) {
                            memberList.getMembers().get(i).setActive(false);
                        }
                        fileHandler.editObject(memberList.getMembers().get(i));
                        ui.printMessage("Status er ændret");
                    }
                }
            }
        }
    }

    private int idGenerator() {
        int id;
        Random random = new Random();
        id = random.nextInt(9999);
        while (invalidID(id)) {
            id = random.nextInt(9999);
        }
        return id;
    }

    private boolean invalidID(int id) {
        boolean invalid = false;
        for (int i = 0; i < memberList.getMembers().size(); i++) {
            if (id == memberList.getMembers().get(i).getId()) {
                invalid = true;
                break;
            }
        }
        return invalid;
    }
}
