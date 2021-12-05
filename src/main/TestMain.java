package main;

import demo.*;
import demo.Record;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestMain {
    ArrayList<Member> members;
    ArrayList<Record> records;
    RecordResults results = new RecordResults();
    private void start(){
        setMembers();
        setRecords();

        for(int i = 0; i < members.size(); i++){
            System.out.println(members.get(i));
        }

        System.out.println("\n\n\ntop5resultsBREASTSTROKE");
        ArrayList<Record> top5 = results.topFiveTimes(Discipline.BREASTSTROKE, records);
        for (int i = 0; i < top5.size(); i++) {
            System.out.println(top5.get(i));
        }


        System.out.println("\n\n\nmember best time\n\n\n");
        for(int i = 0; i < members.size(); i++){
            System.out.println(i + " member");
            if(members.get(i) instanceof MemberCompetitive){
                ArrayList<Record> bestTimes = results.memberBestTimes((MemberCompetitive) members.get(i),records);
                for(int j = 0; j < bestTimes.size(); j++){
                    if(bestTimes.get(j)==null){
                        System.out.println("no records in this discipline");
                    } else {
                        System.out.println("best time in the discipline, " + bestTimes.get(i).getDiscipline() + "\n" + bestTimes.get(j));
                    }
                }
            } else {
                System.out.println("non  comp " + members.get(i) + "\n\n");
            }
        }

        //AccountingSH sh = new AccountingSH();
        //System.out.println(sh.getMemberPrice(members.get(1)));

    }

    private void setMembers() {
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.CRAWL);
        disciplines.add(Discipline.BREASTSTROKE);
        members.add(new Member(false, 1, "Jack", LocalDate.of(1950, 5, 2), true, 0, LocalDate.now()));
        members.add(new MemberCompetitive(false, 2, "JackComp", LocalDate.of(1950, 5, 2), true, 0, LocalDate.now(), null, disciplines));

        this.members = members;
    }
    private void setRecords() {
        ArrayList<Record> records = new ArrayList<>();
        //public Record(int holder, double time, LocalDate date, Discipline discipline){
        records.add(new Record(2, 200.50, LocalDate.now(), 1, Discipline.BREASTSTROKE));
        records.add(new Record(2, 30.00, LocalDate.now(), 4, Discipline.BREASTSTROKE));
        records.add(new Record(2, 20.75, LocalDate.now(), 3, Discipline.BREASTSTROKE));
        records.add(new Record(2, 45.50, LocalDate.now(), 5, Discipline.BREASTSTROKE));
        records.add(new Record(2, 6.50, LocalDate.now(), 7, Discipline.BREASTSTROKE));
        records.add(new Record(2, 60.50, LocalDate.now(), 6, Discipline.BREASTSTROKE));
        records.add(new Record(2, 20.50, LocalDate.now(), 2, Discipline.BREASTSTROKE));

        this.records = records;
    }

    public static void main(String[] args) {
        TestMain ts = new TestMain();
        ts.start();
    }
    public TestMain(){
    }
}
