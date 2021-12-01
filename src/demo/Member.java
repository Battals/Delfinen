package demo;

import java.time.LocalDate;
import java.util.Random;

public class Member {

    private boolean isComp = false;
    private int id; //Må ikke redigeres
    private String name;
    private LocalDate age;
    private boolean active;
    private double debt;
    private LocalDate startDate;

    //New Member
    public Member(String name, LocalDate age, boolean active) {
        idGenerator();
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //new Member(name, age, active)
    //Super for Competitive
    public Member(boolean isComp, String name, LocalDate age, boolean active) {
        idGenerator();
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //new CompetitiveMember(boolean isComp = true, String name, LocalDate age, boolean active, Coach coach, Arraylist<Discipline> disciplines)
    //Already Exists(FileHandler)
    public Member(boolean isComp, int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate){
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

    public String getData() {
        return id + "_" + isComp + "_" + name + "_" + age + "_" + active + "_" + startDate;
    }
}
