package demo;

import java.util.ArrayList;

public class RecordResults {

    //Tilføj discipline samt alle records, og du får ArrayList tilbage der har top 5: Arraynummer, 0 = 1st plads, 4 = 5th plads
    public ArrayList<Record> topFiveTimes(Discipline discipline, ArrayList<Record> records) {
        records = getDisciplineRecords(discipline, records);
        if(records.isEmpty()){
            return null;
        }
        ArrayList<Record> topFive = new ArrayList<>();
        records.sort(new RecordComparator());
        int count = records.size();
        for (int i = 0; i < records.size(); i++) {
            if(!(count<=0)) {
                topFive.add(records.get(i));
                count--;
            }
        }
        return topFive;
    }

    //Tilføj member samt alle records, og du får ArrayList tilbage der har 0-4 Records, alle hvilket er den bedste tid inden for respektive disciplin
    public ArrayList<Record> memberBestTimes(Member member, ArrayList<Record> records) {
        ArrayList<Record> memberRecords = getMemberRecords(member, records);
        ArrayList<Record> bestTimes = new ArrayList<>();
        if(member instanceof MemberCompetitive) {
            if (((MemberCompetitive) member).getDisciplines().contains(Discipline.CRAWL)) {
                bestTimes.add(bestDisciplineTime(Discipline.CRAWL, memberRecords));
            }
            if (((MemberCompetitive) member).getDisciplines().contains(Discipline.RYGCRAWL)) {
                bestTimes.add(bestDisciplineTime(Discipline.RYGCRAWL, memberRecords));
            }
            if (((MemberCompetitive) member).getDisciplines().contains(Discipline.BUTTERFLY)) {
                bestTimes.add(bestDisciplineTime(Discipline.BUTTERFLY, memberRecords));
            }
            if (((MemberCompetitive) member).getDisciplines().contains(Discipline.BREASTSTROKE)) {
                bestTimes.add(bestDisciplineTime(Discipline.BREASTSTROKE, memberRecords));
            }
            return bestTimes;
        } else {
            return null;
        }
    }

    //Private
    private Record bestDisciplineTime(Discipline discipline, ArrayList<Record> records) {
        records = getDisciplineRecords(discipline, records);
        if (records.isEmpty()) {
            return null;
        }
        Record best = records.get(0);
        for (Record record : records) {
            if (record.getDiscipline().equals(discipline)) {
                if (best.getTime() > record.getTime()) {
                    best = record;
                }
            }
        }
        return best;
    }

    private ArrayList<Record> getMemberRecords(Member member, ArrayList<Record> records) {
        ArrayList<Record> memberRecords = new ArrayList<>();
        System.out.println(member);
        if (records.isEmpty()) {
            return null;
        }
        for (Record record : records) {
            if (member.getId() == record.getHolder()) {
                memberRecords.add(record);
            }
        }
        if(memberRecords.isEmpty()){
            return null;
        }
        return memberRecords;
    }

    private ArrayList<Record> getDisciplineRecords(Discipline discipline, ArrayList<Record> records) {
        ArrayList<Record> disciplineRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getDiscipline().equals(discipline)) {
                disciplineRecords.add(record);
            }
        }
        return disciplineRecords;
    }
}
