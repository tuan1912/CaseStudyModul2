package controller;

import model.Account;
import model.Consumer;
import service.AccountServiceImpl;

import java.util.List;

public class AccountController {
    AccountServiceImpl accountService = new AccountServiceImpl();
    public List<Account> findAll(){
        return accountService.findAll();
    }
    public void createNewAccount(String username, String password, int role, Consumer consumerDetails) {
        accountService.createNewAccount(username,password,role,consumerDetails);
    }
    public int getIndexByAccountId(int accountId) {
        return accountService.getIndexByAccountId(accountId);
    }
    public void changeAccountPassword(int index, String password) {
        accountService.changeAccountPassword(index,password);
    }
    public void changeAccountRole(int index, int role) {
        accountService.changeAccountRole(index,role);
    }
    public void changeAccountInformation(int index, Consumer consumer) {

    }
    public void removeAccount(int index) {
        accountService.removeAccount(index);
    }





}
