package demo;

public class Colours {



    public static final String green = "\u001B[32m";
    public static final String reset = "\u001B[0m";
    public static final String white = "\u001B[37m";
    public static final String blue = "\u001B[34m";
    public static final String red = "\u001B[31m";

    public String colourGreen(String input) {
        return green + input + reset;
    }

    public String colourWhite(String input){
        return white + input + reset;
    }

    public String colourBlue(String input){
        return blue + input + reset;
    }

    public String colourRed(String input){
        return red + input + reset;}


}
