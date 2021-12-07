package view;

import controller.ComputerController;

public class ComputerView {
    ComputerController computerController = new ComputerController();

    public void showComputers() {
        for (int i = 0; i < computerController.findAll().size(); i++) {
            System.out.println(computerController.findAll().get(i));
        }
    }

    public int chooseShowComputerDetails() {
        int chooseComputerId = ValidateView.enterIntegerNumber();
        int indexOfInputComputerId = computerController.getIndexByComputerId(chooseComputerId);
        if (!computerController.findAll().isEmpty()) {
            if (indexOfInputComputerId > -1) return indexOfInputComputerId;
            else {
                System.err.println("Does'nt exist id! Re-type:");
                return chooseShowComputerDetails();
            }
        } else {
            return indexOfInputComputerId;
        }

    }

    public void showComputerDetails() {
        System.out.println("Enter computer id you wanna see:");
        int chooseComputerDetails = chooseShowComputerDetails();
        try {
            System.out.println(computerController.findAll().get(chooseComputerDetails));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Computers is null!");
        }

    }
    public void createNewComputer(){
        computerController.createNewComputer();
    }


}
