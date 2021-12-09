package controller;

import model.Computer;
import service.ComputerServiceImpl;

import java.util.List;

public class ComputerController {
    ComputerServiceImpl computerService = new ComputerServiceImpl();
    public List<Computer> findAll(){
        return computerService.findAll();
    }
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
    public void turnOff(int index){
        computerService.turnOff(index);
    }
    public void isOnOrOff(int index) {
        computerService.isOnOrOff(index);
    }








}
