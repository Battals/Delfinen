package demo;

import ui.Colours;

import java.time.LocalDate;
import java.util.ArrayList;

public class Member {
    //LISTE - BETALINGSINFORMATION
    //BETALINGSKLASSE - Læser Age, og ud fra det giver respektivt
    //
    private boolean isComp = false;
    private boolean isSenior;
    Colours colour = new Colours();

    private int memberID;
    private String name;
    private LocalDate age;
    private int subscription;
    private String memberType;
    private String swimmerType;
    private boolean active;
    private int payment;
    private static int memberCount;
    private LocalDate startDate;

    //StringFormat: ISCOMP_ISSENIOR_MEMBERID_NAME_AGE_ACTIVE_STARTDATE;


    //Creates new user
    public Member(int memberID, String name, LocalDate age, int subscription, String memberType, String swimmerType, int payment){
        //this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.subscription = subscription;
        this.memberType = memberType;
        this.swimmerType = swimmerType;
        this.payment = payment;
        memberCount++;
        this.memberID = memberCount;
        if (memberType.equalsIgnoreCase("Passive")){
            subscription = 500;
        }

    }

    /*public Member(int memberID, String name, LocalDate age, boolean active) {
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.active = active;
        startDate = LocalDate.now();
    }

    //Creates new competitive member
    public Member(boolean isComp, int memberID, String name, LocalDate age, boolean active) {
        this.isComp = isComp;
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.active = active;
        startDate = LocalDate.now();
    }

    //Creates existing member
    public Member(boolean isComp, int memberID, String name, LocalDate age, boolean active, LocalDate startDate) {
        this.isComp = isComp;
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.active = active;
        this.startDate = startDate;
    }
*/
    private void setAgeGroup() {
        if (LocalDate.now().compareTo(age) >= 18) {
            isSenior = true;
        }
        if (LocalDate.now().compareTo(age) < 18) {
            isSenior = false;
        }
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getAge() {
        return age;
    }

    public String getData() {
        return memberID + "_" + name + "_" + age + "_" + active + "_" + startDate;
    }

    public int getMemberID(){
        return memberID;
    }

    public String getName(){ return name;}

    @Override
    public String toString(){
        return colour.colourGreen("\nMedlemsID: " + memberID) + " - " + colour.colourWhite("\nMedlemmets navn: ") +
                name + " - " + colour.colourWhite("\nFødselsdagsdato: ") +  age + " - " +
                colour.colourWhite("\nKontigent: ") +  subscription + " - " + colour.colourWhite("\nMedlemstype: ")+
                memberType + " - " +colour.colourWhite("\nSvømmertype: ")  +  swimmerType + " - " + colour.colourWhite("\nBetalingstatus: ")
                + payment + "kr.";
    }





}

