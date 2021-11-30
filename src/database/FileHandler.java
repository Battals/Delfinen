package database;


import demo.*;
import demo.Record;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FileHandler {

    File fileMembers = new File("data/members.txt");
    File fileRecords = new File("data/records.txt");
    File fileContingent = new File("data/contingent.txt");

    //MEMBERDATA:
    //ISCOMP_ID_NAME_AGE_ACTIVE_STARTDATE
    //boolean isComp, int id, String name, LocalDate age, boolean active, LocalDate startDate

    //COMPDATA:
    //ISCOMP_ID_NAME_AGE_ACTIVE_STARTDATE_COACHID_CRAWL_RYGCRAWL_BUTTERFLY_BREASTSTROKE
    //boolean isComp, int id, String name, LocalDate age, boolean active, LocalDate startDate, int coachID, Arraylist<Disciplin> disciplines

    //RECORDSDATA:
    //HOLDERID_DISCIPLINE_PLACEMENT_TIME_DATE

    //CONTINGENT???:
    //evt. int værdi i member, antal måneder der er blevet betalt for
    //Overall Status, int activeMonths, int inactiveMonths, int comp

    //Surface:
    public void createMember(Member member){
    }
    public void editMember(Member member){
    }
    public void deleteMember(Member member){
    }

    public void addRecord(Record record){
    }
    public void deleteRecord(Record record){
    }


    //System
    // public void addObject();

    //Converters
    public LocalTime stringToLocalTime(String time) {
        String[] data = time.split(":");
        int hours = Integer.parseInt(data[0]);
        int minutes = Integer.parseInt(data[1]);
        int seconds = Integer.parseInt(data[2]);
        return LocalTime.of(hours, minutes, seconds);
    }

    public LocalDate stringToLocalDate(String date) {
        String[] data = date.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);
        return LocalDate.of(year, month, day);
    }

    //StringReader
    //StringReader: Record
    public Record stringToRecord(String record) {
        String[] data = record.split("_");
        int placement = Integer.parseInt(data[0]);
        Member holder = null;
        LocalTime time = stringToLocalTime(data[2]);
        LocalDate date = stringToLocalDate(data[3]);
        Discipline discipline = Discipline.valueOf(data[4]);
        if (placement == 0) {
            return new Record(holder, time, date, discipline);
        } else {
            return new Record(holder, time, date, discipline, placement);
        }
    }

    /*//StringReader: Member
    public Member stringToMember(String member){
        String[] data = member.split("_");
        if(Boolean.getBoolean(data[0])){
            return stringToMemberCompetitive(data);
        } else {
            return stringToMemberNormal(data);
        }
    }
    public Member stringToMemberCompetitive(String[] data){
        boolean isComp = Boolean.getBoolean(data[0]);
        int memberID = Integer.parseInt(data[1]);
        String name = data[2];
        LocalDate age = stringToLocalDate(data[3]);
        boolean active = Boolean.getBoolean(data[4]);
        LocalDate startDate = stringToLocalDate(data[5]);
        Coach coach = null;
        ArrayList<Discipline> disciplines = null;
        return new MemberCompetitive(isComp, memberID, name, age, active, startDate, coach, disciplines);
    }
    public Member stringToMemberNormal(String[] data){
        boolean isComp = Boolean.getBoolean(data[0]);
        int memberID = Integer.parseInt(data[1]);
        String name = data[2];
        LocalDate age = stringToLocalDate(data[3]);
        boolean active = Boolean.getBoolean(data[4]);
        LocalDate startDate = stringToLocalDate(data[5]);
        return new Member(isComp, memberID, name, age, active, startDate);
    } */

}
