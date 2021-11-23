package demo;

import java.time.LocalDate;

public class Member {
    //LISTE - BETALINGSINFORMATION
    //BETALINGSKLASSE - Læser Age, og ud fra det giver respektivt
    //
    private boolean isComp = false;
    private boolean isSenior;
    private int memberID;
    private String name;
    private LocalDate age;
    private boolean active;
    private LocalDate startDate;

    //StringFormat: ISCOMP_ISSENIOR_MEMBERID_NAME_AGE_ACTIVE_STARTDATE;

    //Creates new user
    public Member(int memberID, String name, LocalDate age, boolean active) {
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


}

