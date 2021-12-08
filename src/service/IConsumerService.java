package service;

import model.Consumer;

import java.util.List;

public interface IConsumerService {
    List<Consumer> findAll();
    void writeToFile();
    Consumer createNewConsumer(String name, String dateOfBirth, String phoneNumber);
    int getIndexByConsumerId(int consumerId);
    void changeConsumerInformation(int index,String name, String dateOfBirth, String phoneNumber);
    void removeConsumer(int index);
}
