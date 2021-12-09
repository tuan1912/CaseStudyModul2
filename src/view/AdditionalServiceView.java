package view;

import controller.AdditionalServiceController;

import java.util.Scanner;

public class AdditionalServiceView {
    Scanner scanner = new Scanner(System.in);
    AdditionalServiceController additionalServiceController = new AdditionalServiceController();

    public void goAdditionalServiceMenu() {
        System.out.println("---$$$--Manage Additional Services Menu--$$$---");
        System.out.println("       1. Show  Additional Services            ");
        System.out.println("       2. Create New Additional Services       ");
        System.out.println("       3. Remove Additional Services           ");
        System.out.println("       4. Change Additional Services           ");
        System.out.println("       5. Go back Administrator Menu           ");
        System.out.println("                 ---(^_^)---                   ");
        switch (ValidateView.chooseAdditionalServiceMenu()) {
            case 1:
                showAdditionalSerVices();
                goAdditionalServiceMenu();
                break;
            case 2:
                create();
                goAdditionalServiceMenu();
                break;
            case 3:
                remove();
                goAdditionalServiceMenu();
                break;
            case 4:
                change();
                goAdditionalServiceMenu();
                break;
            case 5:
                break;
        }
    }

    public void showAdditionalSerVices() {
        for (int i = 0; i < additionalServiceController.findAll().size(); i++) {
            System.out.println(additionalServiceController.findAll().get(i));
        }
    }

    public void create() {
        System.out.println("Enter additional service name:");
        String name = scanner.nextLine();
        System.out.println("Enter additional service price:");
        int price = ValidateView.enterAdditionalServicePrice();
        additionalServiceController.createNewAdditionalService(name, price);
    }

    public void remove() {
        showAdditionalSerVices();
        try {
            System.out.println(" Enter computer id you wanna remove:");
            int indexOfInputId = chooseAdditionalService();
            additionalServiceController.removeAdditionalService(indexOfInputId);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Doesn't exist id!");
        }
    }

    public int chooseAdditionalService() {
        int chooseServiceId = ValidateView.enterIntegerNumber();
        return additionalServiceController.getIndexById(chooseServiceId);

    }
    public void change(){
        System.out.println("Enter additional service id you wanna change:");
        int chooseServiceId = chooseAdditionalService();
        if (chooseServiceId > -1) {
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new price:");
            int newPrice = ValidateView.enterAdditionalServicePrice();
            additionalServiceController.changeAdditionalServiceInfo(chooseServiceId, newName,newPrice);
        } else System.err.println("Doesn't exist id!");
    }




}