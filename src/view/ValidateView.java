package view;

import java.util.Scanner;

public class ValidateView {
    public static Scanner scanner = new Scanner(System.in);
    public static void goAdminMenuOrQuit() {
        System.out.println("Enter 'quit' or anyone else ");
        String nextChoice = scanner.nextLine();
        if (!nextChoice.equalsIgnoreCase("quit")) {
            new Main().goAdministratorMenu();
        } else {
            System.exit(0);
        }
    }

    public static int chooseAdminMenu() {
        int choiceNumber = enterIntegerNumber();
        boolean isChoiceNumber = choiceNumber < 10 && choiceNumber >= 0;
        if (isChoiceNumber) return choiceNumber;
        else {
            System.err.println("Wrong! Re-type your choice ,again:");
            return chooseAdminMenu();
        }
    }

    public static int enterIntegerNumber() {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("Oops! Must be \"integer\"\n");
            System.out.println("Re-type:");
            return enterIntegerNumber();
        }
        return inputNumber;
    }






}
