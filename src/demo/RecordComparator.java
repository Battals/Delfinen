package demo;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record> {

    @Override
    public int compare(Record o1, Record o2) {
        return compare(o1.getTime(), o2.getTime());
    }

    private int compare(double time, double time1) {
        return compare(time, time1);
    }
}
