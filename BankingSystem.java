package com.company;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.UUID;

public class BankingSystem {
    ArrayList<User> users;
    ArrayList<Account> accounts;

    public BankingSystem() {
        users = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public void displayUsers() {
        int i = 1;
        for (User item : users) {
            System.out.print("User " + i + ":");
            item.printUserData();
            i++;
        }
    }

    public void displayAccounts() {
        int i = 1;
        for (Account item : accounts) {
            System.out.print("Account " + i + ":");
            item.printAccountData();
            i++;
        }
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public Account findAccount(String serial) {
        for (Account item : accounts) {
            if (item.getSerial().equals(UUID.fromString(serial))) {
                return item;
            }
        }
        return null;
    }

    public User findUser(String id, String password) {
        for (User item : users) {
            if (item.getPassword().equals(password)) {
                if (item.getId().equals(id)) {
                    return item;
                }
            }
        }
        return null;
    }

    public User findUser(String id) {
        for (User item : users) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void register(User user) {
        Iterator<User> it = users.iterator();
        boolean existUser = false;
        while (it.hasNext()) {
            User i = it.next();
            if (i.getId().equals(user.getId())) {
                System.out.println("user already exists.");
                existUser = true;
            }
        }
        if (!existUser) {
            users.add(user);
            System.out.println("user created.");
        }
    }

    public void login(String id, String password) {
        for (User i : users) {
            if (i.getId().equals(id)) {
                if (i.getPassword().equals(password)) {
                    System.out.println("Logged in.");

                }
            }
        }
    }
}





