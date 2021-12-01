package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class MemberCompetitive extends Member {

    private Coach coach;
    private ArrayList<Discipline> disciplines;

    public MemberCompetitive(String name, LocalDate age, boolean active, Coach coach, ArrayList<Discipline> disciplines) {
        super(true, name, age, active);
        this.disciplines = disciplines;
        this.coach = coach;
    }
    public MemberCompetitive(boolean isComp, int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate, Coach coach, ArrayList<Discipline> disciplines) {
        super(isComp, id, name, age, active, debt, startDate);
    }
}
