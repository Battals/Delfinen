package demo;

import java.time.LocalDate;

public class Passive extends Member{
    public Passive(int memberID, String name, LocalDate age, int subscription, String memberType, String swimmerType, int payment) {
        super(memberID, name, age, subscription, memberType, swimmerType, payment);
    }


}
