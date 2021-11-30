package demo;

import java.time.LocalDate;
import java.util.Random;

public class Member2 {

    private boolean isComp = false;
    private int id;
    private String name;
    private LocalDate age;
    private boolean active;
    private double debt;
    private LocalDate startDate;

    //New Member
    public Member2(String name, LocalDate age, boolean active) {
        idGenerator();
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //new Member(name, age, active)
    //Super for Competitive
    public Member2(boolean isComp, String name, LocalDate age, boolean active) {
        idGenerator();
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //new CompetitiveMember(boolean isComp = true, String name, LocalDate age, boolean active, Coach coach, Arraylist<Discipline> disciplines)
    //Already Exists
    public Member2(boolean isComp, int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate){
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
        this.debt = debt;
        this.startDate = startDate;
    }


    private void idGenerator(){
        Random random = new Random();
        id = random.nextInt(9999);
    }
}
