package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Accounting {

    private int subscription;
    private int juniorMemberSub = 1000;
    private int seniorMemberSub = 1600;
    private ArrayList<Member> membersDept = new ArrayList<>();

    public Accounting() {

    }


    public int subscriptionFee(Member members) {
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
    }

    public ArrayList<Member> getMemberDept() {
        return membersDept;
    }




}
