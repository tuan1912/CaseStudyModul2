package view;

import controller.AccountController;
import exception.OutOfTheOrdinary;
import model.Account;
import regex.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateView {
    public static Scanner scanner = new Scanner(System.in);
    static AccountController accountController = new AccountController();

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
            System.err.println("Wrong! Re-type your choice :");
            return chooseAdminMenu();
        }
    }

    public static int chooseChargeMenu() {
        int choiceNumber = enterIntegerNumber();
        boolean isChoiceNumber = choiceNumber < 2 && choiceNumber > 0;
        if (isChoiceNumber) return choiceNumber;
        else {
            System.err.println("Wrong! Re-type your choice :");
            return chooseChargeMenu();
        }
    }

    public static int chooseManageAccountsMenu() {
        int choiceNumber = enterIntegerNumber();
        boolean isChoiceNumber = choiceNumber < 7 && choiceNumber > 0;
        if (isChoiceNumber) return choiceNumber;
        else {
            System.err.println("Wrong! Re-type your choice ,again:");
            return chooseManageAccountsMenu();
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

    public static String enterComputerName() {
        String computerName;
        String regex = Regex.computerName;
        Pattern pattern = Pattern.compile(regex);
        try {
            computerName = scanner.nextLine();
            Matcher matcher = pattern.matcher(computerName);
            boolean match = matcher.matches();
            if (match) {
                return computerName;
            } else
                throw new OutOfTheOrdinary("That's out of the ordinary!\n" + "Use 2 - 10 characters with a mix of letters, numbers \n");
        } catch (OutOfTheOrdinary e) {
            e.getErrorMessage();
            System.out.println(" Re-type : ");
            return enterComputerName();
        }
    }

    public static String enterAccountUserName() {
        String accountUserName;
        String regex = Regex.accountUsername;
        Pattern pattern = Pattern.compile(regex);
        try {
            accountUserName = scanner.nextLine();
            for (Account acc : accountController.findAll()) {
                if (accountUserName.equalsIgnoreCase(acc.getUsername())) {
                    System.err.println("Duplicate accounts aren’t allowed. Re-type:");
                    return enterAccountUserName();
                }
            }
            Matcher matcher = pattern.matcher(accountUserName);
            boolean match = matcher.matches();
            if (match) {
                return accountUserName;
            } else
                throw new OutOfTheOrdinary("That's out of the ordinary!\n" + "Use 8 - 12 characters with a mix of letters, numbers \n");
        } catch (OutOfTheOrdinary e) {
            e.getErrorMessage();
            System.out.println(" Re-type : ");
            return enterAccountUserName();
        }
    }

    public static String loginUserName() {
        String accountUserName;
        String regex = Regex.accountUsername;
        Pattern pattern = Pattern.compile(regex);
        try {
            accountUserName = scanner.nextLine();
            Matcher matcher = pattern.matcher(accountUserName);
            boolean match = matcher.matches();
            if (match) {
                return accountUserName;
            } else
                throw new OutOfTheOrdinary("That's out of the ordinary!\n" + "Use 8 - 12 characters with a mix of letters, numbers \n");
        } catch (OutOfTheOrdinary e) {
            e.getErrorMessage();
            System.out.println(" Re-type : ");
            return loginUserName();
        }

    }

    public static String enterAccountPassword() {
        String accountPassword;
        String regex = Regex.accountPassword;
        Pattern pattern = Pattern.compile(regex);
        try {
            accountPassword = scanner.nextLine();
            Matcher matcher = pattern.matcher(accountPassword);
            boolean match = matcher.matches();
            if (match) {
                return accountPassword;
            } else
                throw new OutOfTheOrdinary("That's out of the ordinary!\n" + "Minimum eight characters, at least one uppercase letter, one lowercase letter and one number");
        } catch (OutOfTheOrdinary e) {
            e.getErrorMessage();
            System.out.println(" Re-type : ");
            return enterAccountPassword();
        }
    }

    public static String enterConsumerName() {
        String consumerName;
        String regex = Regex.consumerName;
        Pattern pattern = Pattern.compile(regex);
        try {
            consumerName = scanner.nextLine();
            Matcher matcher = pattern.matcher(consumerName);
            boolean match = matcher.matches();
            if (match) {
                return consumerName;
            } else
                throw new OutOfTheOrdinary("That's out of the ordinary!\n" + "Use 2 - 20 characters with a mix of letters, numbers ");
        } catch (OutOfTheOrdinary e) {
            e.getErrorMessage();
            System.out.println(" Re-type : ");
            return enterConsumerName();
        }
    }

    public static String enterConsumerPhoneNumber() {
        String consumerPhoneNumber;
        String regex = Regex.consumerPhoneNumber;
        Pattern pattern = Pattern.compile(regex);
        try {
            consumerPhoneNumber = scanner.nextLine();
            Matcher matcher = pattern.matcher(consumerPhoneNumber);
            boolean match = matcher.matches();
            if (match) {
                return consumerPhoneNumber;
            } else
                throw new OutOfTheOrdinary("That's out of the ordinary!\n" + "Use 10 characters of numbers ");
        } catch (OutOfTheOrdinary e) {
            e.getErrorMessage();
            System.out.println(" Re-type : ");
            return enterConsumerPhoneNumber();
        }
    }

    public static String enterConsumerDateOfBirth() {
        String consumerDateOfBirth;
        String regex = Regex.consumerDateOfBirth;
        Pattern pattern = Pattern.compile(regex);
        try {
            consumerDateOfBirth = scanner.nextLine();
            Matcher matcher = pattern.matcher(consumerDateOfBirth);
            boolean match = matcher.matches();
            if (match) {
                return consumerDateOfBirth;
            } else
                throw new OutOfTheOrdinary("That's out of the ordinary!\n" + "dd/mm/yyyy ");
        } catch (OutOfTheOrdinary e) {
            e.getErrorMessage();
            System.out.println(" Re-type : ");
            return enterConsumerDateOfBirth();
        }
    }

    public static int enterRole() {
        int role = enterIntegerNumber();
        if (role != 1 && role != 0 && role != 9) {
            System.err.println("wrong role!");
            return enterRole();
        } else return role;
    }


    public static int enterAdditionalServicePrice() {
        int additionalPrice = enterIntegerNumber();
        if (additionalPrice > 0) {
            return additionalPrice;
        } else {
            System.err.println("Not A Positive Integer\n Re-type:");
            return enterAdditionalServicePrice();
        }
    }

    public static int chooseAdditionalServiceMenu() {
        int choiceNumber = enterIntegerNumber();
        boolean isChoiceNumber = choiceNumber < 6 && choiceNumber > 0;
        if (isChoiceNumber) return choiceNumber;
        else {
            System.err.println("Wrong! Re-type your choice ,again:");
            return chooseAdditionalServiceMenu();
        }
    }


}
