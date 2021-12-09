package view;

import controller.ComputerController;
import model.Computer;

import java.util.Scanner;

public class ComputerView {
    Scanner scanner = new Scanner(System.in);
    ComputerController computerController = new ComputerController();

    public void showComputers() {
        for (int i = 0; i < computerController.findAll().size(); i++) {
            System.out.println(computerController.findAll().get(i));
        }
    }

    public int chooseComputer() {
        int chooseComputerId = ValidateView.enterIntegerNumber();
        int indexOfInputComputerId = computerController.getIndexByComputerId(chooseComputerId);
        if (!computerController.findAll().isEmpty()) {
            if (indexOfInputComputerId > -1) return indexOfInputComputerId;
            else {
                System.err.println("Does'nt exist id! Re-type:");
                return chooseComputer();
            }
        } else {
            return indexOfInputComputerId;
        }

    }

    public void showComputerDetails() {
        System.out.println("Enter computer id you wanna see:");
        int chooseComputerDetails = chooseComputer();
        try {
            System.out.println(computerController.findAll().get(chooseComputerDetails));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Computers is null!");
        }

    }

    public void createNewComputer() {
        computerController.createNewComputer();
    }

    public void changeComputerName() {
        try {
            System.out.println("Enter computer id you wanna change information:");
            int indexOfInputId = chooseComputer();
            System.out.println("Enter new computer name:");
            String inputName = ValidateView.enterComputerName();
            computerController.changeComputerName(indexOfInputId, inputName);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Computers is null!");
        }
    }

    public void removeComputer() {
        try {
            System.out.println(" Enter computer id you wanna remove:");
            int indexOfInputId = chooseComputer();
            computerController.removeComputer(indexOfInputId);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Computers is null!");
        }
    }

    public void goChargeMenu() {
        System.out.println("1. Turn On/Off Computer");
        System.out.println("2. Check               ");
        System.out.println("3. Go back Administrator Menu");
        switch (chooseChargeMenu()) {
            case 1:
                turnOnOrOff();
                goChargeMenu();
                break;
            case 2:
                getCheck();
                goChargeMenu();
                break;
            case 3:
                break;
        }
    }
    public  int enterIntegerNumber() {
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

    public int chooseChargeMenu() {
        int choiceNumber = enterIntegerNumber();
        boolean isChoiceNumber = choiceNumber < 4 && choiceNumber > 0;
        if (isChoiceNumber) return choiceNumber;
        else {
            System.err.println("Wrong! Re-type your choice :");
            return chooseChargeMenu();
        }
    }

    public void turnOnOrOff() {
        showComputers();
        System.out.println("Enter computer id:");
        int indexOfInputId = chooseComputer();
        if (indexOfInputId > -1) {
            Computer com = computerController.findAll().get(indexOfInputId);
            System.out.println(com);
            computerController.isOnOrOff(indexOfInputId);
            System.out.println((com.getStatus()) ? com.getComputerName() + " is Availabe" : com.getComputerName() + " is Disable");
        } else {
            System.err.println("Does'nt exist id! ");
        }
    }
    public void getCheck(){
        showComputers();
        System.out.println("Enter computer id:");
        int indexOfInputId = chooseComputer();
        if (indexOfInputId > -1) {
            Computer com = computerController.findAll().get(indexOfInputId);
            try {
                long check =  (com.getElapsedTime()*5/1000);
                if(check>0)System.out.println(com.getComputerName()+" check = "+check+ "VND");
                else System.err.println("Please turn the computer \"OFF\" before get the bill!");
            }catch (Exception e){
                System.out.println("Something must have went wrong!");
            }

        }else System.err.println("Doesn't exist id!");
    }


}
