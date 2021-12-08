package demo;

import java.util.ArrayList;

public class RecordResults {

    //Tilføj discipline samt alle records, og du får ArrayList tilbage der har top 5: Arraynummer, 0 = 1st plads, 4 = 5th plads
    public ArrayList<Record> topFiveTimes(Discipline discipline, ArrayList<Record> records) {
        records = getDisciplineRecords(discipline, records);
        ArrayList<Record> topFive = new ArrayList<>();
        records.sort(new RecordComparator());
        for (int i = 0; i < 5; i++) {
            topFive.add(records.get(i));
        }
        return topFive;
    }

    //Tilføj member samt alle records, og du får ArrayList tilbage der har 0-4 Records, alle hvilket er den bedste tid inden for respektive disciplin
    public ArrayList<Record> memberBestTimes(MemberCompetitive member, ArrayList<Record> records) {
        ArrayList<Record> memberRecords = getMemberRecords(member, records);
        ArrayList<Record> bestTimes = new ArrayList<>();

        if (member.getDisciplines().get(0).equals(Discipline.CRAWL)) {
            bestTimes.add(bestDisciplineTime(Discipline.CRAWL, memberRecords));
        }
        if (member.getDisciplines().contains(Discipline.RYGCRAWL)) {
            bestTimes.add(bestDisciplineTime(Discipline.RYGCRAWL, memberRecords));
        }
        if (member.getDisciplines().contains(Discipline.BUTTERFLY)) {
            bestTimes.add(bestDisciplineTime(Discipline.BUTTERFLY, memberRecords));
        }
        if (member.getDisciplines().contains(Discipline.BREASTSTROKE)) {
            bestTimes.add(bestDisciplineTime(Discipline.BREASTSTROKE, memberRecords));
        }
        return bestTimes;
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
        if (records.isEmpty()) {
            return null;
        }
        for (Record record : records) {
            if (member.getId() == record.getHolder()) {
                memberRecords.add(record);
            }
        }
        return memberRecords;
    }

    private ArrayList<Record> getDisciplineRecords(Discipline discipline, ArrayList<Record> records) {
        ArrayList<Record> disciplineRecords = new ArrayList<>();
        if (records.isEmpty()) {
            return null;
        }
        for (Record record : records) {
            if (record.getDiscipline().equals(discipline)) {
                disciplineRecords.add(record);
            }
        }
        return disciplineRecords;
    }
}
