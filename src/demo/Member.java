package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Member {

    private boolean isComp = false;
    private int id; //Må ikke redigeres



    private String name;

    public void setAge(LocalDate age) {
        this.age = age;
    }

    private LocalDate age;

    MemberList memberList = new MemberList();


    private boolean active;
    private double debt;
    private LocalDate startDate;
    private int pay;

    int max = 1000;
    int min = 0;

    ArrayList<Member> listOfMember = new ArrayList<>();

    //New Member
    public Member(int id, String name, LocalDate age, boolean active) {
        this.id = id;
        this.name = name;
        this. age = age;
        this.active = active;
        startDate = LocalDate.now();
    }
    //Super for Competitive
    public Member(int id, boolean isComp, String name, LocalDate age, boolean active) {
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

    public int idGenerator(Member member) {
        Random random = new Random();
        int id = random.nextInt(9999);
        boolean invalid = true;
        while (invalid) {
            int duplicates = 1;
            id = random.nextInt(9999);
            for (int i = 0; i < memberList.getMembers().size(); i++) {
                if (memberList.getMembers().get(i).getId() == id) {
                    duplicates++;
                }
            }
            if (duplicates == 0) {
                invalid = false;
            }
        }
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

    public LocalDate getAge(){
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public int getPay() {
        return pay;
    }

    public void addDebt(double amount){
        debt += amount;
    }
    public double removeDebt(double amount){
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
