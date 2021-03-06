package service;

import io.ConfigReadAndWrite;
import io.Path;
import model.Account;
import model.Consumer;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    static ConfigReadAndWrite<Account> configReadAndWrite = new ConfigReadAndWrite<>();
    public static List<Account> accounts = configReadAndWrite.readFromFile(Path.PATH_ACCOUNTS);
    ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
    public AccountServiceImpl() {
        try {
            if (!accounts.isEmpty()) {
                int maxAccountId = 0;
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountId() > maxAccountId) maxAccountId = accounts.get(i).getAccountId();
                }
                Account.id = maxAccountId;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() {
        configReadAndWrite.writeToFile(Path.PATH_ACCOUNTS, accounts);
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public void createNewAccount(String username, String password, int role, Consumer consumerDetails) {
        accounts.add(new Account(username, password, role, consumerDetails));
        writeToFile();
    }

    @Override
    public int getIndexByAccountId(int accountId) {
        int NOT_EXIST_ID = -1;
        for (int i = 0; i < accounts.size(); i++) {
            boolean isAccountId = accountId == accounts.get(i).getAccountId();
            if (isAccountId) return i;
        }
        return NOT_EXIST_ID;
    }

    @Override
    public void changeAccountPassword(int index, String password) {
        accounts.get(index).setPassword(password);
        writeToFile();
    }

    @Override
    public void changeAccountRole(int index, int role) {
        accounts.get(index).setRole_BasedAuthorization(role);
        writeToFile();
    }

    @Override
    public void changeAccountInformation(int index, String name, String dateOfBirth, String phoneNumber) {
        accounts.get(index).getConsumerDetails().setName(name);
        accounts.get(index).getConsumerDetails().setDateOfBirth(dateOfBirth);
        accounts.get(index).getConsumerDetails().setPhoneNumber(phoneNumber);
        consumerService.changeConsumerInformation(index,name,dateOfBirth,phoneNumber);
        writeToFile();
    }

    @Override
    public void removeAccount(int index) {
        accounts.remove(index);
        writeToFile();
    }


}
