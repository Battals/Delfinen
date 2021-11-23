package demo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Record {

    private Member holder;
    private LocalTime time;
    private LocalDate date;
    private int placement;
    private Discipline discipline;

    //1) Hver swømmers bedste resultat inden for hver swømmediciplin; Klasse?
    //2) Træneren har oversigt, og kan se top 5 swømmere inden for hver swømmediciplin, fordelt senior og junior
    //3) En måde at se swømmerens bedste tid, inden for hver swømme diciplin, en måde at se top 5

    //NormalTraining
    public Record(Member holder, LocalTime time, LocalDate date, Discipline discipline){
        this.holder = holder;
        this.time = time;
        this.date = date;
        this.discipline = discipline;
        placement = 0;
    }

    //Competition
    public Record(Member holder, LocalTime time, LocalDate date, Discipline discipline, int placement){
        this.holder = holder;
        this.time = time;
        this.date = date;
        this.discipline = discipline;
        this.placement = placement;
    }


}
