package database;


import demo.Member;
import demo.Record;

public class FileHandler {
    //Member:
    //ISCOMP_ISSENIOR_MEMBERID_NAME_AGE_ACTIVE_STARTDATE


    //MemberComp:
    //ISCOMP_ISSENIOR_MEMBERID_NAME_AGE_ACTIVE_STARTDATE_COACHID_CRAWL_RYGCRAWL_BUTTERFLY_BREASTSTROKE
    //boolean isComp, boolean isSenior, int memberID, String name, LocalDate age, boolean active, LocalDate startDate,
    //Coach coach, ArrayList<Discipline> disciplines

    //Record:
    //PLACEMENT_HOLDER_TIME_DATE_DISCIPLINE

    public void addMember(Member member){

    }



    //Converter
    public Record stringToRecord(String record){
        String[] data = record.split("_");

    }

    public String recordToString(Record record){

    }

    public Member stringToMember(String member){
        String[] data = member.split("_");
    }
    public String memberToString(Member member){

    }

}
