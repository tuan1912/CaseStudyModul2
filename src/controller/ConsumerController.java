package controller;

import model.Consumer;
import service.ConsumerServiceImpl;

import java.util.List;

public class ConsumerController {
    ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
    public List<Consumer> findAll(){
        return consumerService.findAll();
    }

    public Consumer createNewConsumer(String name, String dateOfBirth, String phoneNumber) {
        return consumerService.createNewConsumer(name, dateOfBirth, phoneNumber);

    }

    public int getIndexByConsumerId(int consumerId) {
        return consumerService.getIndexByConsumerId(consumerId);
    }

    public void changeConsumerInformation(int index, String name, String dateOfBirth, String phoneNumber) {
        consumerService.changeConsumerInformation(index,name,dateOfBirth,phoneNumber);
    }

    public void removeConsumer(int index) {
        consumerService.removeConsumer(index);
    }



}
