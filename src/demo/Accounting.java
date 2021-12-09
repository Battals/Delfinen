package demo;


import database.FileHandler;
import ui.Userinterface;

import java.time.LocalDate;
import java.util.ArrayList;

public class Accounting extends User {

    /**
     *
     * @author Abdallah Ha
     * @author Ahsan Masood Iqbal
     * @author Battal R. Ozcan
     * @author Rashaun Godding
     *
     */

    FileHandler fileHandler = new FileHandler();

    //Står for aflæsning af debt/gæld, og medlemmernes subscription pris, samt fremtidige betalinger

    double inactive = 500;
    double under18 = 1000;
    double over18 = 1600;
    double over60 = 1600 * 0.75;
    private final ArrayList<Member> membersDept = new ArrayList<>();

    Userinterface ui = new Userinterface();

    public Accounting(String user, String password) {
        super(user, password);
    }

    public void accountMenu() {
        ui.printMessage("""
                                
                Tast 1) - Få overblik over indkomst
                Tast 2) - Se medlemmer i restance
                Tast 3) - Se liste over kontingent priser
                Tast 4) - Se svømmers pris
                Tast 5) - Svømmer betaling
                Tast 9) - Log ud
                Tast 0) - Slut program""");
    }

    public void subscriptionPrint() {
        ui.printMessage("Kontingent priser:" + " kr." +    System.lineSeparator() +
                "  - Junior pris:      " + under18 + " kr." + System.lineSeparator() +
                "  - Senior pris:      " + over18 + " kr." +  System.lineSeparator() +
                "  - Pensionister:     " + over60 + " kr." +  System.lineSeparator() +
                "  - Passive svømmere: " + inactive + "  kr.");
    }

    public void printDebtors() {
        for (Member member : MemberList.debitors()) {
            if (member.getDebt() < 0) {
                ui.printObject(member);
            }
        }
    }

    //Metoder der skal bruges i controller
    public void payPlayerDebt(ArrayList<Member> members){
        ui.printMessage("Hvilken svømmer vil betale?");
        Member member = findMember(members);
        ui.printMessage("Hvor meget er der blevet betalt?");
        ui.printMessage("Kroner: ");
        double kroner = ui.intScanner();
        ui.printMessage("Øre: ");
        double cents = ui.intScanner();
        double payment = Double.sum(kroner, cents/100);
        member.removeDebt(payment);
        ui.printMessage("Brugerens nye gæld ligger på: " + member.getDebt() + "kr.");
        fileHandler.editObject(member);
    }
    public void printAnnualIncome(ArrayList<Member> members) {
        double monthlyIncome = 0;
        for (Member member : members) {
            monthlyIncome += getMemberPrice(member);
        }
        ui.printObject("Hvert år forventes der at få: " + monthlyIncome + " kr.");
    }
    public void printMemberPrice(ArrayList<Member> members) {
        Member member = findMember(members);
        ui.printMessage("Svømmer skal betale: " + getMemberPrice(member) + "kr. om året.");
    }



    //PaymentHandling
    //Add års pris til enkelt medlem
    public void addYearlyDebt(Member member) {
        member.addDebt(-getMemberPrice(member));
    }
    //Add års pris til alle medlemmer
    public void addYearlyDebtALL(ArrayList<Member> members) {
        for (Member member : members) {
            member.addDebt(-getMemberPrice(member));
        }
    }

    //PaymentCalculating
    public double getMemberPrice(Member member) {
        if (!member.isActive()) {
            return inactive;
        }
        int age = LocalDate.now().compareTo(LocalDate.of(1999, 7, 29));
        if (age < 18 && age > 0) {
            return under18;
        } else if (age < 60) {
            return over18;
        } else if (age > 65) {
            return over60;
        } else {
            return 0;
        }
    }
    public double calculateContingent(ArrayList<Member> members) {
        double result = 0;
        for (Member member : members) {
            result += getMemberPrice(member);
        }
        return result;
    }
    public void getAge(Member member) {
        int age = LocalDate.now().compareTo(member.getAge());
    }
    public ArrayList<Member> getMemberDept() {
        return membersDept;
    }
    public Member findMember(ArrayList<Member> members){
        Member member = null;
        while(member == null){
            for(int i = 0; i < members.size(); i++){
                ui.printMessage(String.valueOf(members.get(i)));
            }
            ui.printMessage("Skriv svømmerens id");
            int id = ui.intScanner();
            for(int i = 0; i < members.size(); i++){
                if(id==members.get(i).getId()){
                    member=members.get(i);
                }
            }
        }
        return member;
    }

    @Override
    public String getData() {
        return "ACCOUNTING_" + super.getData();
    }
}
