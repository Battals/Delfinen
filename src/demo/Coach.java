package demo;

import java.util.ArrayList;

public class Coach extends User{

    private int id;
    private String name;

    RecordResults recordResults = new RecordResults();

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Coach(String user, String password, int id, String name){
        super(user,password);
        this.id = id;
        this.name = name;
    }

    public void printCoachMenu(){
        ui.printMessage("""
                
                Tast 1) - Se konkurrence resultater
                Tast 2) - Se svømmers bedste resultater
                Tast 9) - Log ud
                Tast 0) - Slut program""");
    }

    public void checkPlayerResult(ArrayList<Member> members, ArrayList<Record> records) {
        if(records==null){
            ui.printMessage("der findes ingen rekorder");
            return;
        } else if(records.isEmpty()){
            ui.printMessage("der findes ingen rekorder");
            return;
        }
        ArrayList<Record> playerRecords;
        ui.printMessage("Hvilken svømmer vil du tjekke resultater for?");
        Member member = findMember(members);
        playerRecords = recordResults.memberBestTimes(member, records);
        if (playerRecords == null) {
            ui.printMessage("Denne svømmer har ingen rekorder");
            return;
        }
        for (int i = 0; i < playerRecords.size(); i++) {
            if(playerRecords.get(i)!=null) {
                ui.printMessage(playerRecords.get(i).getDiscipline().name() +": ");
                ui.printMessage(String.valueOf(playerRecords.get(i)));
            }
        }
    }
    public void checkTopFive(ArrayList<Record> records){
        printTopFive(Discipline.CRAWL, recordResults.topFiveTimes(Discipline.CRAWL, records));
        printTopFive(Discipline.RYGCRAWL, recordResults.topFiveTimes(Discipline.RYGCRAWL, records));
        printTopFive(Discipline.BUTTERFLY, recordResults.topFiveTimes(Discipline.BUTTERFLY, records));
        printTopFive(Discipline.BREASTSTROKE, recordResults.topFiveTimes(Discipline.BREASTSTROKE, records));
    }
    public void printTopFive(Discipline discipline, ArrayList<Record> records){
        ui.printMessage("Top 5 resultater inden for: " + discipline.name());
        if(records==null){
            ui.printMessage("Der findes ingen bedste tider inden for disciplinen: " + discipline.name());
            return;
        }
        try {
            for (int i = 0; i < records.size(); i++) {
                ui.printMessage(String.valueOf(records.get(i)));
            }
        } catch (ArrayIndexOutOfBoundsException e){
            ui.printMessage("Der findes ingen bedste tider inden for disciplinen: " + discipline.name());
        }

    }


    public Member findMember(ArrayList<Member> members){
        Member member = null;
        while(member == null){
            for(int i = 0; i < members.size(); i++){
                ui.printMessage(String.valueOf(members.get(i)));
            }
            ui.printMessage("Skriv svømmerens id");
            int id = ui.intScanner();
            for(int i = 0; i < members.size(); i++){
                if(id==members.get(i).getId()){
                    member=members.get(i);
                }
            }
        }
        return member;
    }

    @Override
    public String toString(){
    return "ID: " + id + " - " + "Trænerens navn: " + name;
    }
}
