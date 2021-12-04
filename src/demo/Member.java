package demo;

import java.time.LocalDate;
import java.util.Random;

public class Member {

    private boolean isComp = false;
    private int id; //Må ikke redigeres



    private String name;

    public void setAge(LocalDate age) {
        this.age = age;
    }

    private LocalDate age;



    private boolean active;
    private double debt;
    private LocalDate startDate;

    //New Member
    public Member(String name, LocalDate age, boolean active) {
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //Super for Competitive
    public Member(boolean isComp, String name, LocalDate age, boolean active) {
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
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

    public int getId(){
        return id;
    }


    public String getName() {
        return name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge(){
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public void addDebt(double amount){
        debt += amount;
    }
    public double removeDebt(double amount){
        debt += amount;
        return debt;
    }

    public String getData() { //(FileHandler)
        return id + "_" + isComp + "_" + name + "_" + age + "_" + active + "_" + startDate;
    }


    @Override
    public String toString() {
        return "Member{" +
                "isComp=" + isComp +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", debt=" + debt +
                ", startDate=" + startDate +
                '}';
    }
}
