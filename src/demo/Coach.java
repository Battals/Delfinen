package demo;

public class Coach extends User {

    private int id;

    public Coach(String user, String password){
        super(user, password);
    }

    //Existing Coach
    public Coach(String user, String password, int id){
        super(user, password);
        this.id = id;
    }
}
