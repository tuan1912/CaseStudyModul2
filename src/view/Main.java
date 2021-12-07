package view;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    AccountView accountView = new AccountView();
    ComputerView computerView = new ComputerView();
    ConsumerView consumerView = new ConsumerView();
    public void goAdministratorMenu(){
        showAdministratorMenu();
        switch (ValidateView.chooseAdminMenu()){
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
                ValidateView.goAdminMenuOrQuit();
                break;
            case 6:
                ValidateView.goAdminMenuOrQuit();
                break;
            case 7:
                ValidateView.goAdminMenuOrQuit();
                break;

            case 8:
                ValidateView.goAdminMenuOrQuit();
                break;
            case 9:
                ValidateView.goAdminMenuOrQuit();
                break;
            case 0:
                exit();
                break;
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void showAdministratorMenu() {
        System.out.println("--$$$----CYBER GAME MANAGEMENTS----$$$--");
        System.out.println("  1.  Show computers                   ");
        System.out.println("  2.  Create new computer              ");
        System.out.println("  3.  Change computer information      ");
        System.out.println("  4.  Remove computer                  ");
        System.out.println("  5.  Additional service               ");
        System.out.println("  6.  Surcharge                        ");
        System.out.println("  7.  Charge                           ");
        System.out.println("  8.  Manage consumer accounts         ");
        System.out.println("  9.  Show revenue                     ");
        System.out.println("  0.  Exit                             ");
        System.out.println("              ---(^_^)---             ");
    }

    public static void main(String[] args) {
        new Main().goAdministratorMenu();
    }






}
