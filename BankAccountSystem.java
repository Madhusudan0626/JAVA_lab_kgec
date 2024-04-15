/*
Assignment 23. Design a class to represent a bank account, include the following details:
Data members:
(a)Name of the depositors
(b)Account number
(c)Type of account
(d)Balance amount in the account

Methods:
(a)To assign initial values
(b)To deposit an amount
(c)To withdraw an amount after checking balance
(d)To display the name and balance

Assume that a bank maintain two kinds of account for its customers, one called saving account and the other is current account. The savings account provides compound interest and withdrawal facility but no cheque book facility. The current account provides cheque book facility but no interest. Current account holders should also maintain a minimum balance and if the balance falls below this level, a service charge is to be imposed.

Perform following operations:
(a)Accept deposit from a customer and update the balance.
(b)Display the balance.
(c)Compute and deposit interest.
(d)Permit withdrawal and update the balance.
(e)Check for the minimum balance, impose penalty, if necessary and update the balance.
(f)Do not use any constructors, Use methods to initialize the class members.
 */
import java.util.Scanner;

class BankAccount {
    private String depositorName;
    private int accountNumber;
    private String accountType;
    private double balance;

    public void assignInitialValues(String name, int accNum, String accType, double initBalance) {
        depositorName = name;
        accountNumber = accNum;
        accountType = accType;
        balance = initBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void display() {
        System.out.println("Depositor Name: " + depositorName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }

    public void computeInterest(double rate) {
        if (accountType.equalsIgnoreCase("savings")) {
            double interest = balance * rate / 100;
            balance += interest;
            System.out.println("Interest of $" + interest + " credited.");
        } else {
            System.out.println("Current account does not earn interest.");
        }
    }

    public void checkMinimumBalance(double minBalance, double penalty) {
        if (accountType.equalsIgnoreCase("current") && balance < minBalance) {
            balance -= penalty;
            System.out.println("Minimum balance penalty of $" + penalty + " imposed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.print("Enter depositor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter account type (savings/current): ");
        String accType = scanner.next();
        System.out.print("Enter initial balance: ");
        double initBalance = scanner.nextDouble();

        account.assignInitialValues(name, accNum, accType, initBalance);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Display\n4. Compute Interest (Savings)\n5. Check Minimum Balance (Current)\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.display();
                    break;
                case 4:
                    if (accType.equalsIgnoreCase("savings")) {
                        System.out.print("Enter interest rate: ");
                        double rate = scanner.nextDouble();
                        account.computeInterest(rate);
                    } else {
                        System.out.println("Interest can only be computed for savings account.");
                    }
                    break;
                case 5:
                    if (accType.equalsIgnoreCase("current")) {
                        System.out.print("Enter minimum balance: ");
                        double minBalance = scanner.nextDouble();
                        System.out.print("Enter penalty amount: ");
                        double penalty = scanner.nextDouble();
                        account.checkMinimumBalance(minBalance, penalty);
                    } else {
                        System.out.println("Minimum balance check is only for current account.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

/*
Enter depositor name: Madhusudan
Enter account number: 10023
Enter account type (savings/current): current
Enter initial balance: 3000

1. Deposit
2. Withdraw
3. Display
4. Compute Interest (Savings)
5. Check Minimum Balance (Current)
6. Exit
Enter choice: 5
Enter minimum balance: 2000
Enter penalty amount: 20

1. Deposit
2. Withdraw
3. Display
4. Compute Interest (Savings)
5. Check Minimum Balance (Current)
6. Exit
Enter choice: 4
Interest can only be computed for savings account.

1. Deposit
2. Withdraw
3. Display
4. Compute Interest (Savings)
5. Check Minimum Balance (Current)
6. Exit
Enter choice: 3
Depositor Name: Madhusudan
Account Number: 10023
Account Type: current
Balance: $3000.0

1. Deposit
2. Withdraw
3. Display
4. Compute Interest (Savings)
5. Check Minimum Balance (Current)
6. Exit
Enter choice: 6
Exiting...

Process finished with exit code 0

 */
