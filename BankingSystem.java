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
        for (User str : users) {
            System.out.print("User " + i + ":");
            str.printUserData(str);
            i++;
        }
    }

    public void displayAccounts() {
        int i = 1;
        for (Account str : accounts) {
            System.out.print("Account " + i + ":");
            str.printAccountData();
            i++;
        }
    }

    public void addUser(User user) {
        users.add(user);
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
        for (Account str : accounts) {
            if (str.getSerial().equals(UUID.fromString(serial))) {
                return str;
            }
        }
       return null;
    }
    public User findUser(String id,String password) {
        for (User str : users) {
            if (str.getPassword().equals(password))
            {
                if (str.getId().equals(id))
                {
                    return str;
                }
            }
        }
       return null;
    }
    public User findUser(String id) {
        for (User str : users) {
                if (str.getId().equals(id))
                {
                    return str;
                }
        }
        return null;
    }
    public void register(User user)
    {
        Iterator<User> it = users.iterator();
        boolean existUser = false;
        while(it.hasNext()) {
            User i = it.next();
            if(i.getId().equals(user.getId())) {
                System.out.println("user already exists.");
                existUser=true;
            }
        }
        if (existUser==false)
        {
            users.add(user);
            System.out.println("user created.");
        }
    }
    public void login(String id, String password)
    {
        Iterator<User> it = users.iterator();
        while(it.hasNext()) {
            User i = it.next();
            if(i.getId().equals(id)) {
                if(i.getPassword().equals(password))
                {
                    System.out.println("Logged in.");

                }
            }
        }
    }
}





