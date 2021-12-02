package demo;

import java.util.ArrayList;

public class RecordResults {

    //1) Hver swømmers bedste resultat inden for hver swømmediciplin; Klasse?
    //2) Træneren har oversigt, og kan se top 5 swømmere inden for hver swømmediciplin, fordelt senior og junior
    //3) En måde at se swømmerens bedste tid, inden for hver swømme diciplin, en måde at se top 5


    public ArrayList<Record> memberBestTimes(MemberCompetitive member, ArrayList<Record> records) {
        ArrayList<Record> memberRecords = getMemberRecords(member, records);
        ArrayList<Record> bestTimes = new ArrayList<>();
        if(member.getDisciplines().contains(Discipline.CRAWL)) {
            bestTimes.add(bestDisciplineTime(Discipline.CRAWL, memberRecords));
        }
        if(member.getDisciplines().contains(Discipline.RYGCRAWL)) {
            bestTimes.add(bestDisciplineTime(Discipline.RYGCRAWL, memberRecords));
        }
        if(member.getDisciplines().contains(Discipline.BUTTERFLY)) {
            bestTimes.add(bestDisciplineTime(Discipline.BUTTERFLY, memberRecords));
        }
        if(member.getDisciplines().contains(Discipline.BREASTSTROKE)) {
            bestTimes.add(bestDisciplineTime(Discipline.BREASTSTROKE, memberRecords));
        }
        return bestTimes;
    }


    //Private
    private Record bestDisciplineTime(Discipline discipline, ArrayList<Record> records) {
        records = getDisciplineRecords(discipline, records);
        Record best = records.get(0);
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getDiscipline().equals(discipline)) {
                if (best.getTime() > best.getTime()) {
                    best = records.get(i);
                }
            }
        }
        return best;
    }
    private ArrayList<Record> getMemberRecords(Member member, ArrayList<Record> records){
        ArrayList<Record> memberRecords = new ArrayList<>();
        for(int i = 0; i < records.size(); i++){
            if(member.getId()==records.get(i).getHolder()){
                memberRecords.add(records.get(i));
            }
        }
        return memberRecords;
    }
    private ArrayList<Record> getDisciplineRecords(Discipline discipline, ArrayList<Record> records){
        ArrayList<Record> disciplineRecords = new ArrayList<>();
        for(int i = 0; i < records.size(); i++){
            if(records.get(i).getDiscipline().equals(discipline)){
                disciplineRecords.add(records.get(i));
            }
        }
        return disciplineRecords;
    }
}
