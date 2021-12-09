package service;

import io.ConfigReadAndWrite;
import io.Path;
import model.Computer;
import java.util.List;

public class ComputerServiceImpl implements IComputerService{
    public static final int NOT_EXIST_ID = -1;
    static ConfigReadAndWrite<Computer> configReadAndWrite = new ConfigReadAndWrite<>();
    public static List<Computer> computers = configReadAndWrite.readFromFile(Path.PATH_COMPUTERS);
    public ComputerServiceImpl(){
        try {
            if(!computers.isEmpty())
            {
                int maxComputerId = 0;
                for (int i = 0; i < computers.size(); i++) {
                    if(computers.get(i).getComputerId()> maxComputerId) maxComputerId = computers.get(i).getComputerId();
                }
                Computer.id = maxComputerId;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }
    public void writeToFile(){
        configReadAndWrite.writeToFile(Path.PATH_COMPUTERS,computers);
    }

    @Override
    public List<Computer> findAll() {
        return computers;
    }

    @Override
    public void turnOff(int index) {
        computers.get(index).turnComputerOff();
        writeToFile();
    }

    @Override
    public void isOnOrOff(int index) {
        computers.get(index).isOnOrOff();
        writeToFile();
    }

    @Override
    public void createNewComputer() {
        computers.add(new Computer());
        writeToFile();
    }

    @Override
    public int getIndexByComputerId(int computerId) {
        for (int i = 0; i < computers.size(); i++) {
            if (computerId == computers.get(i).getComputerId())return i;
        }
        return NOT_EXIST_ID;
    }

    @Override
    public void changeComputerName(int index, String name) {
        computers.get(index).setComputerName(name);
        writeToFile();
    }

    @Override
    public void removeComputer(int index) {
        computers.remove(index);
        writeToFile();
    }


}
