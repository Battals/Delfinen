package demo;

import java.time.LocalDate;

public class Members {

    private int memberID;
    private String name;
    private LocalDate age;
    private boolean active;
    private LocalDate startDate;

    //StringFormat: NAME_MEMBERID_AGE_ACTIVE_STARTDATE;
    public Members(int memberID, String name,  LocalDate age, boolean active, LocalDate startDate) {
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.active = active;
        this.startDate = startDate;
    }



    public String getData(){
        return memberID + "_" + name + "_" + age + "_" + active + "_" + startDate;
    }






}

