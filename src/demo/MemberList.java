package demo;

import database.FileHandler;

import java.util.ArrayList;
import java.util.Calendar;

public class MemberList {

    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Member> debitors = new ArrayList<>();
    static FileHandler fileHandler = new FileHandler();

    public static void programStart() {
        members = fileHandler.getMembers();
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Member> getDebitors() {
        return debitors;
    }

    public static ArrayList<Member> debitors() {
        for (Member member : members) {
            if (member.getPay() < Calendar.getInstance().get(Calendar.YEAR)) {
                debitors.add(member);
            }
        }
        return debitors;
    }
}
