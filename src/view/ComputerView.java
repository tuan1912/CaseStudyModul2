package view;

import controller.ComputerController;

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
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Computers is null!");
        }
    }

    public void removeComputer(){
        try {
            System.out.println(" Enter computer id you wanna remove:" );
            int indexOfInputId = chooseComputer();
            computerController.removeComputer(indexOfInputId);
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Computers is null!");
        }
    }


}
