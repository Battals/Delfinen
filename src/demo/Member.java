package demo;

import java.time.LocalDate;

public class Member {

    /**
     *
     * @author Battal R. Ozcan
     *
     */

    private boolean isComp = false;
    private final int id; //Må ikke redigeres
    private String name;
    private LocalDate age;

    private boolean active;
    private double debt;
    private final LocalDate startDate;
    private int pay;


    //New Member
    public Member(int id, String name, LocalDate age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
        startDate = LocalDate.now();
    }

    //Super for Competitive
    public Member(int id, boolean isComp, String name, LocalDate age, boolean active) {
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
        startDate = LocalDate.now();
    }

    //Already Exists(FileHandler)
    public Member(boolean isComp, int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate) {
        this.isComp = isComp;
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
        this.debt = debt;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDebt() {
        return debt;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public int getPay() {
        return pay;
    }

    public void addDebt(double amount) {
        debt += amount;
    }

    public double removeDebt(double amount) {
        debt += amount;
        return debt;
    }

    public String getData() { //(FileHandler)
        return id + "_" + isComp + "_" + name + "_" + age + "_" + active + "_" + startDate + "_" + debt;
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
