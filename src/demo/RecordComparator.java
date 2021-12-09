package demo;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record> {

    /**
     *
     * @author Abdallah Ha
     * @author Rashaun Godding
     *
     */

    @Override
    public int compare(Record o1, Record o2) {
        return Double.compare(o1.getTime(), o2.getTime());
    }

}
