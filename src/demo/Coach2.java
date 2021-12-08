package demo;

import java.util.Scanner;

public class Coach2 {
    public void run() {

        Scanner input = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        String userName = input.nextLine();
        String passWord = input.nextLine();

        String inUser = keyboard.nextLine();
        String inPass = keyboard.nextLine();

        if (inUser.equals(userName) && inPass.equals(passWord)) {
            System.out.println("Velkommen" + userName);
        } else {
            System.out.println("forkert kode, prøv igen");
        }

    }
}
