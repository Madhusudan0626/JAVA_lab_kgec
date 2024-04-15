/*
 Modify the assignment number 23 with following changes:
Create a class Account that stores customer name, account
number and type of account. From this, derive the classes
Curr-acct and Sav-acct to make them more specific to their requirements
. Include necessary methods in order to achieve the following tasks:
(a)Accept deposit from a customer and update the balance.
(b)Display the balance.
(c)Compute and deposit interest.
(d)Permit withdrawal and update the balance.
(e)Check for the minimum balance, impose penalty,
if necessary and update the balance.
(f)Do not use any constructors, Use methods to initialize the class members.
 */
import java.util.Scanner;

class Account {
    protected String customerName;
    protected int accountNumber;
    protected String accountType;
    protected double balance;

    public void setInitialValues(String name, int accNum, String accType, double initBalance) {
        customerName = name;
        accountNumber = accNum;
        accountType = accType;
        balance = initBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }

    public void displayBalance() {
        System.out.println("Depositor Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void computeInterest(double rate) {
        System.out.println("Account type does not earn interest.");
    }

    public void checkMinimumBalance(double minBalance, double penalty) {
        System.out.println("Account type does not have minimum balance check.");
    }
}

class CurrAcct extends Account {
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient funds or below minimum balance of $1000.");
        }
    }

    @Override
    public void checkMinimumBalance(double minBalance, double penalty) {
        if (balance < minBalance) {
            balance -= penalty;
            System.out.println("Minimum balance penalty of $" + penalty + " imposed.");
        }
    }
}

class SavAcct extends Account {
    @Override
    public void computeInterest(double rate) {
        double interest = balance * rate / 100;
        balance += interest;
        System.out.println("Interest of $" + interest + " credited.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Display Balance\n5. Compute Interest (Savings)\n6. Check Minimum Balance (Current)\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account = createAccount(scanner);
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.displayBalance();
                    } else {
                        System.out.println("Create an account first.");
                    }
                    break;
                case 5:
                    if (account instanceof SavAcct) {
                        SavAcct savingsAccount = (SavAcct) account;
                        System.out.print("Enter interest rate: ");
                        double rate = scanner.nextDouble();
                        savingsAccount.computeInterest(rate);
                    } else {
                        System.out.println("Interest can only be computed for savings account.");
                    }
                    break;
                case 6:
                    if (account instanceof CurrAcct) {
                        CurrAcct currentAccount = (CurrAcct) account;
                        System.out.print("Enter minimum balance: ");
                        double minBalance = scanner.nextDouble();
                        System.out.print("Enter penalty amount: ");
                        double penalty = scanner.nextDouble();
                        currentAccount.checkMinimumBalance(minBalance, penalty);
                    } else {
                        System.out.println("Minimum balance check is only for current account.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static Account createAccount(Scanner scanner) {
        System.out.print("Enter depositor name: ");
        String name = scanner.next();
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter account type (savings/current): ");
        String accType = scanner.next();
        System.out.print("Enter initial balance: ");
        double initBalance = scanner.nextDouble();

        Account account;
        if (accType.equalsIgnoreCase("savings")) {
            account = new SavAcct();
        } else if (accType.equalsIgnoreCase("current")) {
            account = new CurrAcct();
        } else {
            System.out.println("Invalid account type. Account not created.");
            return null;
        }

        account.setInitialValues(name, accNum, accType, initBalance);
        return account;
    }
}
