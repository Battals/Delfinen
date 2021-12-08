package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class MemberCompetitive extends Member {

    private final Coach coach;
    private final ArrayList<Discipline> disciplines;

    public MemberCompetitive(int id, String name, LocalDate age, boolean active, Coach coach, ArrayList<Discipline> disciplines) {
        super(id, true, name, age, active);
        this.disciplines = disciplines;
        this.coach = coach;
    }

    public MemberCompetitive(boolean isComp, int id, String name, LocalDate age, boolean active, double debt, LocalDate startDate, Coach coach, ArrayList<Discipline> disciplines) {
        super(isComp, id, name, age, active, debt, startDate);
        this.coach = coach;
        this.disciplines = disciplines;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    private String disciplinesGetData() {
        boolean crawl = false;
        boolean rygCrawl = false;
        boolean butterfly = false;
        boolean brystswømning = false;
        for (Discipline discipline : disciplines) {
            if (discipline == Discipline.CRAWL) {
                crawl = true;
            }
            if (discipline == Discipline.RYGCRAWL) {
                rygCrawl = true;
            }
            if (discipline == Discipline.BUTTERFLY) {
                butterfly = true;
            }
            if (discipline == Discipline.BREASTSTROKE) {
                brystswømning = true;
            }
        }
        return crawl + "_" + rygCrawl + "_" + butterfly + "_" + brystswømning;
    }


    @Override
    public String getData() {
        return super.getData() + "_" + coach.getId() + "_" + disciplinesGetData();
    }


    @Override
    public String toString() {
        return super.toString() + "MemberCompetitive{" +
                "coach=" + coach +
                ", disciplines=" + disciplinesGetData() +
                '}';
    }
}
