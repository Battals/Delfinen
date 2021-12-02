package database;


import demo.*;
import demo.Record;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    File fileMembers = new File("data/members.txt");
    File fileRecords = new File("data/records.txt");
    File fileContingent = new File("data/contingent.txt");

    //MEMBERDATA:
    //ID_ISCOMP_NAME_AGE_ACTIVE_STARTDATE
    //int id, boolean isComp, String name, LocalDate age, boolean active, LocalDate startDate

    //COMPDATA:
    //ID_ISCOMP_NAME_AGE_ACTIVE_STARTDATE_COACHID_CRAWL_RYGCRAWL_BUTTERFLY_BREASTSTROKE
    //int id, boolean isComp, String name, LocalDate age, boolean active, LocalDate startDate, int coachID, Arraylist<Disciplin> disciplines

    //RECORDSDATA:
    //HOLDERID_DISCIPLINE_PLACEMENT_TIME_DATE

    //CONTINGENT???:
    //evt. int værdi i member, antal måneder der er blevet betalt for
    //Overall Status, int activeMonths, int inactiveMonths, int comp

    //DataHandling
    public void addObject(Object object){
        if(object instanceof Member){
            addData(((Member) object).getData(), fileMembers);
        }
        else if(object instanceof Record){
            addData(((Record) object).getData(),fileRecords);
        }
        else {
            System.out.println("invalid?(add object)");
        }
    }
    public void editObject(Object object){
        if(object instanceof Member){
            editData(((Member) object).getData(), fileMembers);
        }
        else if(object instanceof Record){
            editData(((Record) object).getData(),fileRecords);
        }
        else {
            System.out.println("invalid(edit object)?");
        }
    }
    public void removeObject(Object object){
    }

    //DataReading
    public ArrayList<Member> getMembers(){
        ArrayList<String> membersData = new ArrayList<>();
        try {
            Scanner sc = new Scanner(fileMembers);
            while(sc.hasNextLine()){
                membersData.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return getMembersToArray(membersData);
    }
    public ArrayList<Record> getRecords(){
        return null;
    }

    //Private Methods

    //Add Data
    private void addData(String data, File file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,file.exists()));
            writer.newLine();
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Delete Data
    private void deleteData(String data, File file){
    }
    //Edit Data
    private void editData(String data, File file){
        //https://stackoverflow.com/questions/31375972/how-to-replace-a-specific-line-in-a-file-using-java
        Path path = Paths.get(file.getPath());
        List<String> lines = null;
        String[] dataList = data.split("_");
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int line = findDataLine(dataList, file);
            if(line == -1){
                System.out.println("can't find data");
                return;
            }
            lines.set(line-1, data);
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int findDataLine(String[] data, File file){
        try {
            Scanner sc = new Scanner(file);
            int lineCount = 0;
            while(sc.hasNextLine()){
                lineCount++;
                String[] tempData = sc.nextLine().split("_");
                if(tempData[0].equals(data[0])){
                    return lineCount;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }


    //StringReaders
    private ArrayList<Member> getMembersToArray(ArrayList<String> data){
        ArrayList<Member> members = new ArrayList<>();
        for(int i = 0; i < data.size(); i++){
            if(stringReaderMember(data.get(i))!=null) {
                members.add(stringReaderMember(data.get(i)));
            }
        }
        return members;
    }
    private Member stringReaderMember(String memberData){
        Member member;
        try {
            String[] data = memberData.split("_");
            int id = Integer.parseInt(data[0]);
            boolean isComp = Boolean.parseBoolean(data[1]);
            String name = data[2];
            LocalDate age = stringReaderLocalDate(data[3]);
            boolean active = Boolean.parseBoolean(data[4]);
            int debt = 0;
            LocalDate startDate = stringReaderLocalDate(data[5]);
            if (isComp) {
                Coach coach = findCoach(data[6]);
                ArrayList<Discipline> disciplines = stringReaderDisciplines(data[7], data[8], data[9], data[10]);
                member = new MemberCompetitive(true, id, name, age, active, debt, startDate, coach, disciplines);
            } else {
                member = new Member(false, id, name, age, active, debt, startDate);
            }
            return member;
        } catch (ArrayIndexOutOfBoundsException ignored){}
        return null;
    }
    private Record stringReaderRecord(String recordData){
        return null;
    }
    //SubReaders
    private ArrayList<Discipline> stringReaderDisciplines(String crawl, String rygcrawl, String butterfly, String breaststroke){
        ArrayList<Discipline> disciplines = new ArrayList<>();
        if(Boolean.getBoolean(crawl)){
            disciplines.add(Discipline.CRAWL);
        }
        if(Boolean.getBoolean(rygcrawl)){
            disciplines.add(Discipline.RYGCRAWL);
        }
        if(Boolean.getBoolean(butterfly)){
            disciplines.add(Discipline.BUTTERFLY);
        }
        if(Boolean.getBoolean(breaststroke)){
            disciplines.add(Discipline.BREASTSTROKE);
        }
        return disciplines;
    }
    public LocalTime stringReaderLocalTime(String time) {
        String[] data = time.split(":");
        int hours = Integer.parseInt(data[0]);
        int minutes = Integer.parseInt(data[1]);
        int seconds = Integer.parseInt(data[2]);
        return LocalTime.of(hours, minutes, seconds);
    }
    public LocalDate stringReaderLocalDate(String date) {
        String[] data = date.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);
        return LocalDate.of(year, month, day);
    }

    //Junk(Skal laves her eller i andre klasser)
    private Coach findCoach(String coachID){
        return null;
    }
}
