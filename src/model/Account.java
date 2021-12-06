package model;

import java.util.Scanner;

public class Account {
    Scanner scanner = new Scanner(System.in);
    static final int ROLE_ADMINISTRATOR = 0, ROLE_MANAGER = 1, ROLE_CONSUMER = 9;
    public static int id = 0;
    private int accountId;
    private String username;
    private String password;
    private int role_BasedAuthorization;
    private Consumer consumerDetails;

    public Account() {

    }

    public Account(String username, String password, int role, Consumer consumerDetails) {
        accountId = ++id;
        this.username = username;
        this.password = password;
        this.consumerDetails = consumerDetails;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getRole_BasedAuthorization() {
        return role_BasedAuthorization;
    }

    public void setRole_BasedAuthorization(int role_BasedAuthorization) {
        this.role_BasedAuthorization = role_BasedAuthorization;
    }

    public Consumer getConsumerDetails() {
        return consumerDetails;
    }

    public void setConsumerDetails(Consumer consumerDetails) {
        this.consumerDetails = consumerDetails;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role_BasedAuthorization=" + role_BasedAuthorization +
                ", consumerDetails=" + consumerDetails +
                '}';
    }
}
