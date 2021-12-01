package demo;


import java.time.LocalDate;
import java.util.ArrayList;

public class Accounting {

    //Står for aflæsning af debt/gæld, og medlemmernes subscription pris, samt fremtidige betalinger

    private int subscription;
    private double juniorMemberSub = 1000;
    private double seniorMemberSub = 1600;
    private ArrayList<Member> membersDept = new ArrayList<>();

    public Accounting() {

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
