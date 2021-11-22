package demo;

public class Members {

    String name;
    int age;
    int memberId;
    boolean memberStatus;
    String team;


    public Members(String name, int age, int memberId, boolean memberStatus, String team) {
        this.name = name;
        this.age = age;
        this.memberId = memberId;
        this.memberStatus = memberStatus;
        this.team = team;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public int getMemberId(){
        return memberId;
    }

}

