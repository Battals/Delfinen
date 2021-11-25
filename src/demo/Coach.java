import demo.Member;
import java.time.LocalDate;
import java.util.Scanner;


public class Coach extends Member {

    public class Coach e(int memberID, String name, String memberType){


    private int coachID;
    private String name;

    }

    public static void printMenu() {
        }

        private static void switchMenu (Scanner input,int choice);

        {int choice;

            Scanner input = new Scanner(System.in);

            System.out.println("Velkommen tilbage");

            System.out.println("Indtast nummeret til den funktion du ønsker at bruge");
            System.out.println("[1] Se Top 5 resultat for juniordivision");
            System.out.println("[2] Se Top 5 resultat for seniordivision");
            System.out.println("[3] Rediger Top 5 resultat for juniordivision");
            System.out.println("[4] Rediger Top 5 resultat for seniordivision");
            System.out.println("[5] LOG UD");

            choice = input.nextInt();
            /* switchMenu(input, choice);
        */



            switch (choice) {
                case 1:
                   // printRecordResult;
                    break;
                case 1:
                  //  printRecordResults();
                    break;
                case 2:
                    //resultsToFile();
                    break;
                case 3:
                    addResult(input);
                    break;
                case 4:
                    addResult();
                    break;
                case 5:
                    System.out.println("På gensyn");

                default:
                    System.out.println("Pr?v igen");
                    printMenu();
            }
        }



    private static void addResult(Scanner input) {
    }

}



