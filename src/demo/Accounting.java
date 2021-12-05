package demo;


import ui.Userinterface;

import java.time.LocalDate;
import java.util.ArrayList;

public class Accounting extends User {

    //Står for aflæsning af debt/gæld, og medlemmernes subscription pris, samt fremtidige betalinger

    private int subscription;
    private double juniorMemberSub = 1000;
    private double seniorMemberSub = 1600;
    private double pensionMemberSub = (1600 * 25) / 100;
    private double passivMemberSub = 500;
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
                "  - Junior pris: " + juniorMemberSub + System.lineSeparator() +
                "  - Senior pris: " + seniorMemberSub + System.lineSeparator() +
                "  - Pensionister: " + pensionMemberSub + System.lineSeparator() +
                "  - Passive svømmere: " + passivMemberSub);
    }

    public void printDebtors()
    {
        for (Member member : MemberList.debitors())
        {
            System.out.println(membersDept.get(Integer.parseInt(member.getName())));
        }
    }


    public void getAge(Member member){
        int age = LocalDate.now().compareTo(member.getAge());
    }
    public void registerUserContingent(Member member){

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
