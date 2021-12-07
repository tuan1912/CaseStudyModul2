package service;

import io.ConfigReadAndWrite;
import io.Path;
import model.Consumer;

import java.util.List;

public class ConsumerServiceImpl implements IConsumerService {
    public static final int NOT_EXIST_ID = -1;
    static ConfigReadAndWrite<Consumer> configReadAndWrite = new ConfigReadAndWrite<>();
    static List<Consumer> consumers = configReadAndWrite.readFromFile(Path.PATH_CONSUMERS);

    public ConsumerServiceImpl() {
        try {
            if (!consumers.isEmpty()) {
                int maxConsumerId = 0;
                for (int i = 0; i < consumers.size(); i++) {
                    if (consumers.get(i).getConsumerId() > maxConsumerId)
                        maxConsumerId = consumers.get(i).getConsumerId();
                }
                Consumer.id = maxConsumerId;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Consumer> findAll() {
        return consumers;
    }

    @Override
    public void writeToFile() {
        configReadAndWrite.writeToFile(Path.PATH_CONSUMERS, consumers);
    }

    @Override
    public void createNewConsumer(String name, String dateOfBirth, String phoneNumber) {
        consumers.add(new Consumer(name, dateOfBirth, phoneNumber));
        writeToFile();
    }

    @Override
    public int getIndexByConsumerId(int consumerId) {
        for (int i = 0; i < consumers.size(); i++) {
            boolean isConsumerId = consumerId == consumers.get(i).getConsumerId();
            if (isConsumerId) return i;
        }
        return NOT_EXIST_ID;
    }

    @Override
    public void changeConsumerInformation(int index, String name, String dateOfBirth, String phoneNumber) {
        consumers.get(index).setName(name);
        consumers.get(index).setDateOfBirth(dateOfBirth);
        consumers.get(index).setPhoneNumber(phoneNumber);
        writeToFile();
    }

    @Override
    public void removeConsumer(int index) {
        consumers.remove(index);
        writeToFile();
    }



}
