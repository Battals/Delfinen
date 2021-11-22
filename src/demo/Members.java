package demo;

import java.time.LocalDate;

public class Members {
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

    //StringFormat: ISCOMP_ISSENIOR_NAME_MEMBERID_AGE_ACTIVE_STARTDATE;

    //Normalt
    public Members(int memberID, String name,  LocalDate age, boolean active, LocalDate startDate) {
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.active = active;
        this.startDate = startDate;
    }
    //Competitive
    public Members(boolean isComp, int memberID, String name,  LocalDate age, boolean active, LocalDate startDate) {
        this.isComp = isComp;
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.active = active;
        this.startDate = startDate;
    }

    private void setAgeGroup(){
        if(LocalDate.now().compareTo(age) >= 18){
            isSenior = true;
        }
        if(LocalDate.now().compareTo(age) < 18){
            isSenior = false;
        }
    }

    public LocalDate getAge() {
        return age;
    }

    public String getData(){
        return memberID + "_" + name + "_" + age + "_" + active + "_" + startDate;
    }






}

