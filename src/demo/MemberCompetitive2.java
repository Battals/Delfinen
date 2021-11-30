package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class MemberCompetitive2 extends Member2 {

    private Coach2 coach;
    private ArrayList<Discipline> disciplines;

    public MemberCompetitive2(String name, LocalDate age, boolean active, Coach2 coach, ArrayList<Discipline> disciplines) {
        super(true, name, age, active);
        this.disciplines = disciplines;
        this.coach = coach;
    }
    public MemberCompetitive2(boolean isComp, int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate, Coach2 coach, ArrayList<Discipline> disciplines) {
        super(isComp, id, name, age, active, debt, startDate);
    }
}
