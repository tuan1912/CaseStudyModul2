package service;

import model.Account;
import model.Consumer;

import java.util.List;

public interface IAccountService {
    void writeToFile();
    List<Account> findAll();
    void createNewAccount(String username, String password, int role, Consumer consumerDetails);
    int getIndexByAccountId(int accountId);
    void changeAccountPassword(int index,String password);
    void changeAccountRole(int index, int role);
    void changeAccountInformation(int index, Consumer consumer);
    void removeAccount(int index);

}
