package demo;

public class Coach extends User{

    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Coach(String user, String password, int id, String name){
        super(user,password);
        this.id = id;
    }

    public void printCoachMenu(){
        ui.printMessage("""
                
                Tast 1) - Se konkurrence resultater
                Tast 9) - Log ud
                Tast 0) - Slut program""");
    }

    @Override
    public String toString(){
    return "ID: " + id + " - " + "Trænerens navn: " + name;
    }
}
