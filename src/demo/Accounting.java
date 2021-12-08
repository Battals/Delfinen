package demo;


import ui.Userinterface;

import java.time.LocalDate;
import java.util.ArrayList;

public class Accounting extends User {

    //Står for aflæsning af debt/gæld, og medlemmernes subscription pris, samt fremtidige betalinger

    private int subscription;
    double inactive = 500;
    double under18 = 1000;
    double over18 = 1600;
    double over60 = 1600 * 0.75;
    private ArrayList<Member> membersDept = new ArrayList<>();

    Userinterface ui = new Userinterface();

    public Accounting(String user, String password) {
        super(user, password);
    }

    public void accountMenu(){
        ui.printMessage("""
                
                Tast 1) - Få overblik over indkomst
                Tast 2) - Se medlemmer i restance
                Tast 3) - Se liste over kontingent priser
                Tast 9) - Log ud
                Tast 0) - Slut program""");
    }

    public void subscriptionPrint(){
        ui.printMessage("Kontingent priser:" + System.lineSeparator() +
                "  - Junior pris: " + under18 + System.lineSeparator() +
                "  - Senior pris: " + over18 + System.lineSeparator() +
                "  - Pensionister: " + over60 + System.lineSeparator() +
                "  - Passive svømmere: " + inactive);
    }

    public void printDebtors()
    {
        for (Member member : MemberList.debitors()) {
            if(member.getDebt()<0){
                System.out.println(member);
                //
            }
        }
    }

    //PaymentHandling
    public void addMonthlyDebt(Member member){
        member.addDebt(getMemberPrice(member));
    }
    public void addMonthlyDebtALL(ArrayList<Member> members){
        for(Member member : members) {
            member.addDebt(getMemberPrice(member));
        }
    }
    public void payDebt(Member member, double amount){
        double newDebt = member.removeDebt(amount);
        System.out.println("new debt: " + newDebt);
    }
    public void printMonthlyIncome(ArrayList<Member> members){
        double monthlyIncome = 0;
        for(int i = 0; i < members.size(); i++){
            monthlyIncome += getMemberPrice(members.get(i));
        }
        System.out.println("Hvert år forventes der at få: " + monthlyIncome + "kr.");
    }
    //PaymentCalculating
    public double getMemberPrice(Member member) {
        if(!member.isActive()){
            return inactive;
        }
        int age = LocalDate.now().compareTo(LocalDate.of(1999,7,29));
        if(age < 18 && age > 0){
            return under18;
        } else if(age < 60){
            return over18;
        } else if(age > 65){
            return over60;
        } else {
            return 0;
        }
    }
    public double calculateContingent(ArrayList<Member> members) {
        double result = 0;
        for(int i = 0; i < members.size(); i++){
            result += getMemberPrice(members.get(i));
        }
        return result;
    }


    public void getAge(Member member){
        int age = LocalDate.now().compareTo(member.getAge());
    }


    /*public int subscriptionFee(Member members) {
        int payment = 0;
        if (members.isActive()){
            if (LocalDate.now().compareTo(members.getAge()) < 18) {
                payment = juniorMemberSub;
            } else if (LocalDate.now().compareTo(members.getAge()) < 60) {
                payment = seniorMemberSub;
            } else if (LocalDate.now().compareTo(members.getAge()) > 60){
                int pensionerDiscount = (1600 * 25) / 100;
                payment = seniorMemberSub - pensionerDiscount;
            } else {
                payment = 500;
            }
        }
        return payment;
    }*/

    public ArrayList<Member> getMemberDept() {
        return membersDept;
    }





}
