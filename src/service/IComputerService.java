package service;

import model.Computer;

import java.util.List;

public interface IComputerService {
    void writeToFile();
    List<Computer> findAll();
    void createNewComputer();
    int getIndexByComputerId(int computerId);
    void changeComputerName(int index, String name);
    void removeComputer(int index);
}
