package controller;

import service.ComputerServiceImpl;

public class ComputerController {
    ComputerServiceImpl computerService = new ComputerServiceImpl();
    public void createNewComputer() {
        computerService.createNewComputer();
    }
    public int getIndexByComputerId(int computerId) {
        return computerService.getIndexByComputerId(computerId);
    }
    public void changeComputerName(int index, String name) {
        computerService.changeComputerName(index,name);
    }
    public void removeComputer(int index) {
        computerService.removeComputer(index);
    }









}
