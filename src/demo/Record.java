package demo;

import java.time.LocalDate;

public class Record {

    private final int holder;
    private final double time;
    private final LocalDate date;
    private final int placement;
    private final Discipline discipline;
    //ID_TIME_DATE_PLACEMENT_DISCIPLINE

    //1) Hver swømmers bedste resultat inden for hver swømmediciplin; Klasse?
    //2) Træneren har oversigt, og kan se top 5 swømmere inden for hver swømmediciplin, fordelt senior og junior
    //3) En måde at se swømmerens bedste tid, inden for hver swømme diciplin, en måde at se top 5

    //NormalTraining
    public Record(int holder, double time, LocalDate date, int placement, Discipline discipline) {
        this.holder = holder;
        this.time = time;
        this.placement = placement;
        this.date = date;
        this.discipline = discipline;
        placement = 0;
    }

    //Competition
    public Record(int holder, double time, LocalDate date, Discipline discipline, int placement) {
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

    public String getData() {
        return holder + "_" + time + "_" + date + "_" + placement + "_" + discipline;
    }


    @Override
    public String toString() {
        return "Record{" +
                "holder=" + holder +
                ", time=" + time +
                ", date=" + date +
                ", placement=" + placement +
                ", discipline=" + discipline +
                '}';
    }
}
