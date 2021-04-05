package com.company;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankingSystem bankingSystem = new BankingSystem();
		boolean log1= true;
		boolean log = true;
        boolean addAccount=true;
		boolean work = true;
		boolean systemadmin = true;
		boolean exit=false;
		boolean findA=true;
		boolean syslog=false;
		while (!exit) {
			System.out.println("1.Sign up\n" + "Enter info\n" +
					"2.Log in\n" + "Enter user ID and password\n" +
					"1.Existing accounts\n" + "Choose from list of accounts\n" +
					"1.WithDrawal\n" + "2.Deposit\n" + "3.Transfer\n" +
					"4.Check balance\n" + "5.Back\n" + "2.Add new account\n" +
					"Enter info\n" + "3.Log out\n" + "3.System Admin\n" + "Enter userID and password\n"
					+ "1.display users\n" + "2.display accounts\n" + "3.remove user\n"
					+ "4.Exit\n");
			int selection =0;
			System.out.println("Please select enter:");
			selection = sc.nextInt();
			sc.nextLine();
				if (selection == 1) {
					String firstName = sc.nextLine();
					String lastName = sc.nextLine();
					String id = sc.nextLine();
					String password = sc.nextLine();
					User user2 = new User(firstName, lastName, id, password);
					bankingSystem.register(user2);
				}
			if (selection == 2) {
				while (log)
				{

						User user3;
						String idLog = sc.nextLine();
						String passwordLog = sc.nextLine();
						bankingSystem.login(idLog,passwordLog);
						user3=bankingSystem.findUser(idLog,passwordLog);
						if (user3==null)
                        {
                            System.out.println("user doesn't exists or password is incorrect.");
                            log1=false;
                        }
						while (log1)
						{
							System.out.println("1.Existing accounts\n"+ "2.Add new account\n"+ "3.Log out\n");
							int selectLog= sc.nextInt();
							sc.nextLine();
							switch (selectLog)
							{
								case 1:
								{
                                    while (findA)
                                    {
                                        user3.printAllAvailableAccounts();
                                        String serial = sc.nextLine();
                                        Account account2=bankingSystem.findAccount(serial);
                                        if (account2==null)
                                        {
                                            System.out.println("can not Log into account");
                                            findA=false;
                                        }
                                        System.out.println("Logged into account");
                                        while (work)
                                        {
                                            System.out.println("1.Withdrawal"+ "2.Deposit"+ "3.Transfer" +"4.Check balance"+"5.Back");
                                            int choice= sc.nextInt();
                                            sc.nextLine();
                                            switch (choice){
                                                case 1:
                                                {
                                                    int withdrawal= sc.nextInt();
                                                    sc.nextLine();
                                                    user3.withdrawal(account2,withdrawal);
                                                    break;
                                                }
                                                case 2:
                                                {
                                                    int deposit= sc.nextInt();
                                                    sc.nextLine();
                                                    user3.deposit(account2,deposit);
                                                    break;
                                                }
                                                case 3:
                                                {
                                                    String destAccountSerial=sc.nextLine();
                                                    int transfer= sc.nextInt();
                                                    sc.nextLine();
                                                    user3.transfer(account2,bankingSystem.findAccount(destAccountSerial),transfer);
                                                    break;
                                                }
                                                case 4:
                                                {
                                                    user3.checkBalance(account2);
                                                    break;
                                                }
                                                case 5:
                                                {
                                                    work=false;
                                                    findA=false;
                                                    break;
                                                }
                                            }
                                        }
                                    }
									break;
								}
								case 2:
									{
                                           String typeAccount = sc.nextLine();
                                            int InitAccount = sc.nextInt();
                                            sc.nextLine();
                                            Account Aco=new Account(user3.getId(),user3.getFirstName(),user3.getLastName(),typeAccount,InitAccount);
                                            user3.addAccount(Aco);
                                            bankingSystem.addAccount(Aco);
                                            System.out.println("New account opened.");
                                            break;
								   }
								case 3:
								{
                                    System.out.println("Logged out");
									log1=false;
									break;
								}
							}
						}
                        log=false;
				}
                log1=true;
				log=true;
				work=true;
			}
            if (selection==3)
            {
                systemadmin=true;
                String userName=sc.nextLine();
                String password=sc.nextLine();
                if (userName.equals("sysadmin"))
                {
                    if (password.equals("1234"))
                    {
                        System.out.println("Logged in as sysadmin.");
                        syslog=true;
                    }
                }
                if (!syslog)
                {
                    System.out.println("Username or password is incorrect.");
                        systemadmin=false;
                }
                  while (systemadmin)
                   {
                    System.out.println("1.display users\n" +
                            "2.display accounts\n" +
                            "3.remove user\n" +
                            "4.remove account\n"+"5.back");
                    int choiceAdmin = sc.nextInt();
                    sc.nextLine();
                    switch (choiceAdmin)
                    {
                        case 1:
                        {
                            bankingSystem.displayUsers();
                            break;
                        }
                        case 2:
                        {
                            bankingSystem.displayAccounts();
                            break;
                        }
                        case 3:
                        {
                            String userId=sc.nextLine();
                             User ueserr=bankingSystem.findUser(userId);
                            if (ueserr==null)
                            {
                                System.out.println("User doesn’t exist.");
                            }
                            else
                            {
                                bankingSystem.removeUser(bankingSystem.findUser(userId));
                                System.out.println("User removed.");
                            }
                            break;
                        }
                        case 4:
                        {
                            String serial1 = sc.nextLine();
                            Account ac=bankingSystem.findAccount(serial1);

                            if (ac==null)
                            {
                                System.out.println("Account doesn’t exist.");
                            }
                            else
                            {
                                bankingSystem.removeAccount(bankingSystem.findAccount(serial1));
                                User removeu =bankingSystem.findUser(ac.getId());
                                removeu.removeAccount(ac);
                                System.out.println("Account removed.");
                            }

                            break;
                        }
                        case 5:
                        {
                              systemadmin=false;
                             break;
                        }
                    }
                }
            }
            if (selection==4)
            {
                exit=true;
            }
		}
	}
}
