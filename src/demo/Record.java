package demo;

import java.time.LocalDate;

public class Record {

    private int holder;
    private double time;
    private LocalDate date;
    private int placement;
    private Discipline discipline;

    //1) Hver swømmers bedste resultat inden for hver swømmediciplin; Klasse?
    //2) Træneren har oversigt, og kan se top 5 swømmere inden for hver swømmediciplin, fordelt senior og junior
    //3) En måde at se swømmerens bedste tid, inden for hver swømme diciplin, en måde at se top 5

    //NormalTraining
    public Record(int holder, double time, LocalDate date, Discipline discipline){
        this.holder = holder;
        this.time = time;
        this.date = date;
        this.discipline = discipline;
        placement = 0;
    }

    //Competition
    public Record(int holder, double time, LocalDate date, Discipline discipline, int placement){
        this.holder = holder;
        this.time = time;
        this.date = date;
        this.discipline = discipline;
        this.placement = placement;
    }

    public double getTime() {
        return time;
    }

    public int getHolder() {
        return holder;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public String getData(){
        return "test";
    }


}
