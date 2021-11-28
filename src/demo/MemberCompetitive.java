package demo;

import java.time.LocalDate;
import java.util.ArrayList;

/*public class MemberCompetitive extends Member {

    private Coach coach;
    private ArrayList<Discipline> disciplines;

    //StringFormat: ISCOMP_ISSENIOR_MEMBERID_NAME_AGE_ACTIVE_STARTDATE_COACHID_CRAWL_RYGCRAWL_BUTTERFLY_BREASTSTROKE



    //Creates new member
    /*
    public MemberCompetitive(int memberID, String name, LocalDate age, boolean active,
                             Coach coach, ArrayList<Discipline> disciplines) {
        super(memberID, name, age, active);
        this.coach = coach;
        this.disciplines = disciplines;
    }

    //Creates existing member
    public MemberCompetitive(boolean isComp, int memberID, String name, LocalDate age,
                             boolean active, LocalDate startDate, Coach coach, ArrayList<Discipline> disciplines){
        super(isComp, memberID, name, age, active, startDate);
        this.coach = coach;
        this.disciplines = disciplines;
    }



    private String getDisciplinesData(){
        boolean crawl = false;
        boolean rygcrawl = false;
        boolean butterfly = false;
        boolean breaststroke = false;
        for(int i = 0; i < disciplines.size(); i++){
            Discipline discipline = disciplines.get(i);
            if(discipline==Discipline.CRAWL){
                crawl = true;
            }
            if(discipline==Discipline.RYGCRAWL){
                rygcrawl = true;
            }
            if(discipline==Discipline.BUTTERFLY){
                butterfly = true;
            }
            if(discipline==Discipline.BREASTSTROKE){
                breaststroke = true;
            }
        }

        return crawl + "_" + rygcrawl + "_" + butterfly + "_" + breaststroke;
    }
    @Override
    public String getData() {
        return super.getData() + "_" + coach.getCoachID() + "_" + getDisciplinesData();
    }
}*/

