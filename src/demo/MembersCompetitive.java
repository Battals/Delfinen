package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class MembersCompetitive extends Members {

    private Coach coach;
    private ArrayList<Record> records;

    public MembersCompetitive(String name, int memberID, LocalDate age, boolean active, LocalDate startDate) {
        super(name, memberID, age, active, startDate);
    }
}
