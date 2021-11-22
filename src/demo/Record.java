package demo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Record {

    private Members holder;
    private LocalTime time;
    private LocalDate date;
    private int placement;
    private Discipline discipline;

    //NormalTraining
    public Record(Members holder, LocalTime time, LocalDate date, Discipline discipline){
        this.holder = holder;
        this.time = time;
        this.date = date;
        this.discipline = discipline;
        placement = 0;
    }

    //Competition
    public Record(Members holder, LocalTime time, LocalDate date, Discipline discipline, int placement){
        this.holder = holder;
        this.time = time;
        this.date = date;
        this.discipline = discipline;
        this.placement = placement;
    }


}
