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

    //Member:
    //String Format: ISCOMP_MEMBERID_NAME_AGE_ACTIVE_STARTDATE
    //Data Format: boolean isComp, int memberID, String name, LocalDate age, boolean active, LocalDate startDate

    //MemberCompetitive:
    //String Format: ISCOMP_MEMBERID_NAME_AGE_ACTIVE_STARTDATE_COACHID_CRAWL_RYGCRAWL_BUTTERFLY_BREASTSTROKE
    //Data Format: boolean isComp, int memberID, String name, LocalDate age, boolean active, LocalDate startDate, Coach coach, ArrayList<Discipline> disciplines

    //Record:
    //String Format: PLACEMENT_HOLDERID_TIME_DATE_DISCIPLINE
    //Data Format: PLACEMENT_Member holder, LocalTime time, LocalDate date, Discipline discipline

    //Example: 12_Jake_1999-07-29_true_2021-11-22_1_true_false_false_true

    //Surface:
    public void addMember(Member member) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/members.txt", fileMembers.exists()));
            writer.newLine();
            writer.write(member.getData());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRecord(Record record) {
    }

    public void addContingent(String object) {
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
