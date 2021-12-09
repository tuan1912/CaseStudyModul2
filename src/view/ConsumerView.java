package view;

import controller.ConsumerController;
import model.Consumer;

public class ConsumerView {
    ConsumerController consumerController = new ConsumerController();

    public Consumer createNewConsumer() {
        System.out.println("Enter consumer name:");
        String consumerName = ValidateView.enterConsumerName();
        System.out.println("Enter consumer phone number:");
        String consumerPhoneNumber = ValidateView.enterConsumerPhoneNumber();
        System.out.println("Enter consumer date of birth:");
        String consumerDateOfBirth = ValidateView.enterConsumerDateOfBirth();
        return consumerController.createNewConsumer(consumerName, consumerDateOfBirth, consumerPhoneNumber);
    }

}
