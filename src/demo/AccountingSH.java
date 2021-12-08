package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class AccountingSH {


/*
For aktive medlemmer er kontingentet for ungdomssvømmere (under 18 år) 1000 kr. årligt,
for seniorsvømmere (18 år og over) 1600 kr. årligt.
For medlemmer over 60 årgives der 25 % rabat af seniortaksten.
For passivt medlemskab er taksten 500 kr. årligt.
 */

    double inactive = -500;
    double under18 = -1000;
    double over18 = -1600;
    double over60 = -1600 * 0.75;

    MemberList memberList = new MemberList();

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


    public void annualPay(){
        for (Member member : memberList.getMembers()){
            getMemberPrice(member);
        }
    }

}
