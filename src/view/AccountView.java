package view;

import controller.AccountController;
import controller.ConsumerController;
import model.Consumer;

import java.util.Scanner;

public class AccountView {
    Scanner scanner = new Scanner(System.in);
    AccountController accountController = new AccountController();
    ConsumerController consumerController = new ConsumerController();
    ConsumerView consumerView = new ConsumerView();

    void goManageAccountMenu() {
        System.out.println("---$$$--Manage Accounts Menu--$$$---");
        System.out.println("   1. Show accounts                 ");
        System.out.println("   2. Create new account            ");
        System.out.println("   3. Remove account                ");
        System.out.println("   4. Change account password       ");
        System.out.println("   5. Change account information    ");
        System.out.println("   6. Change role                   ");
        System.out.println("   7. Go back Administrator Menu    ");
        System.out.println("             ---(^_^)---            ");
        switch (ValidateView.chooseManageAccountsMenu()) {
            case 1:
                showAccounts();
                goManageAccountMenu();
                break;
            case 2:
                createNewAccount();
                goManageAccountMenu();
                break;
            case 3:
                removeAccount();
                goManageAccountMenu();
                break;
            case 4:
                changeAccountPassword();
                goManageAccountMenu();
                break;
            case 5:
                changeAccountDetails();
                goManageAccountMenu();
                break;
            case 6:
                changeRole();
                break;
            case 7:
                break;
        }
    }

    public void showAccounts() {
        for (int i = 0; i < accountController.findAll().size(); i++) {
            System.out.println(accountController.findAll().get(i));
        }
    }

    public void createNewAccount() {
        System.out.println("Enter username:");
        String userName = ValidateView.enterAccountUserName();
        System.out.println("Enter password:");
        String password = ValidateView.enterAccountPassword();
        System.out.println("Enter role-based Authorization:");
        int role = ValidateView.enterRole();
        System.out.println("Enter consumer details:");
        Consumer consumer = consumerView.createNewConsumer();
        accountController.createNewAccount(userName, password, role, consumer);

    }

    public void removeAccount() {
        showAccounts();
        try {
            System.out.println(" Enter computer id you wanna remove:");
            int indexOfInputId = chooseAccount();
            accountController.removeAccount(indexOfInputId);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Doesn't exist id!");
        }

    }

    public int chooseAccount() {
        int chooseAccountId = ValidateView.enterIntegerNumber();
        return accountController.getIndexByAccountId(chooseAccountId);

    }

    public void changeAccountPassword() {
        System.out.println("Enter account id you wanna change:");
        int chooseAccountId = chooseAccount();
        if (chooseAccountId > -1) {
            System.out.println("Enter new password:");
            String newPassword = ValidateView.enterAccountPassword();
            accountController.changeAccountPassword(chooseAccountId, newPassword);
        } else System.err.println("Doesn't exist id!");
    }

    public void changeAccountDetails() {
        System.out.println("Enter account id you wanna change:");
        int chooseAccountId = chooseAccount();
        if (chooseAccountId > -1) {
            System.out.println("Enter new name:");
            String name = ValidateView.enterConsumerName();
            System.out.println("Enter new date of birth:");
            String dateOfBirth = ValidateView.enterConsumerDateOfBirth();
            System.out.println("Enter new phone number:");
            String phoneNumber = ValidateView.enterConsumerPhoneNumber();
            accountController.changeAccountInformation(chooseAccountId, name, dateOfBirth, phoneNumber);
        } else System.err.println("Doesn't exist id!");
    }
    public void changeRole(){
        System.out.println("Enter account id you wanna change:");
        int chooseAccountId = chooseAccount();
        if (chooseAccountId > -1) {
            System.out.println("Enter new role:");

        }


}
