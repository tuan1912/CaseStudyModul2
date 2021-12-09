package view;

import controller.AccountController;
import model.Account;
import service.AccountServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    AccountView accountView = new AccountView();
    ComputerView computerView = new ComputerView();
    ConsumerView consumerView = new ConsumerView();
    AccountController accountController = new AccountController();
    AdditionalServiceView additionalServiceView = new AdditionalServiceView();

    public void goAdministratorMenu() {
        showAdministratorMenu();
        switch (ValidateView.chooseAdminMenu()) {
            case 1:
                computerView.showComputers();
                computerView.showComputerDetails();
                ValidateView.goAdminMenuOrQuit();
                break;
            case 2:
                computerView.createNewComputer();
                ValidateView.goAdminMenuOrQuit();
                break;
            case 3:
                computerView.changeComputerName();
                ValidateView.goAdminMenuOrQuit();
                break;
            case 4:
                computerView.removeComputer();
                ValidateView.goAdminMenuOrQuit();
                break;
            case 5:
                additionalServiceView.goAdditionalServiceMenu();
                ValidateView.goAdminMenuOrQuit();
                break;
            case 6:
                computerView.goChargeMenu();
                ValidateView.goAdminMenuOrQuit();
                break;
            case 7:
                accountView.goManageAccountMenu();
                ValidateView.goAdminMenuOrQuit();
                break;
            case 8:
                ValidateView.goAdminMenuOrQuit();
                break;
            case 0:
                exit();
                break;
        }
    }

    public void exit() {
        for (int i = 0; i < computerView.computerController.findAll().size(); i++) {
            computerView.computerController.turnOff(i);
        }
        System.exit(0);
    }

    private void showAdministratorMenu() {
        System.out.println("--$$$----CYBER GAME MANAGEMENTS----$$$--");
        System.out.println("  1.  Show computers                    ");
        System.out.println("  2.  Create new computer               ");
        System.out.println("  3.  Change computer information       ");
        System.out.println("  4.  Remove computer                   ");
        System.out.println("  5.  Additional service                ");
        System.out.println("  6.  Charge                            ");
        System.out.println("  7.  Manage accounts                   ");
        System.out.println("  8.  Show revenue                      ");
        System.out.println("  0.  Exit                              ");
        System.out.println("              ---(^_^)---               ");
    }

    public void login() {
        System.out.println("           *******LOGIN******* ");
        System.out.println("                Username:      ");
        System.out.println("                Password:      ");
        System.out.println("               ---(^_^)---     ");
        String userName = ValidateView.loginUserName();
        String password = ValidateView.enterAccountPassword();
        List<Account> accountList = AccountServiceImpl.accounts;
        boolean isAccount = false;
        int index = -1;
        for (int i = 0; i < accountList.size(); i++) {
            boolean isMatch = userName.equals(accountList.get(i).getUsername()) && password.equals(accountList.get(i).getPassword());
            if ((isMatch)) {
                isAccount = true;
                index = i;
                break;
            }
        }
        if (!isAccount) {
            if (userName.equals("nguyentuan") && password.equals("Tuan1992")) {
                System.out.println("                 Hi,Boss");
                System.out.println("              Welcome back!");
                System.out.println("               ---(^_^)---     ");
                new Main().goAdministratorMenu();
            } else login();
        } else {
            boolean isAdministrator = accountList.get(index).getRole_BasedAuthorization() == 0;
            if (isAdministrator) {
                System.out.println("                 Hi,Boss");
                System.out.println("              Welcome back!");
                System.out.println("               ---(^_^)---     ");
                new Main().goAdministratorMenu();
            } else {
                boolean isManager = accountList.get(index).getRole_BasedAuthorization() == 1;
                if (isManager) {
                    new Main().goManagerMenu();
                } else new Main().goConsumerMenu();
            }
        }
    }

    public void goManagerMenu() {
        System.out.println("Hihihihihihihihi");
    }

    public void goConsumerMenu() {
        System.out.println("            Come back a legend!");
    }

    public static void main(String[] args) {
        new Main().login();
    }


}
