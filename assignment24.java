/*
assignment 24
Create a class, named Account that stores customer name, account number and type of account. Perform following tasks:
Accept deposit from a customer and update the balance.
Display the balance.
Compute and deposit interest.
Permit withdrawal and update balance.
Check for the minimum balance, impose penalty, if necessary andupdate the balance.
Do not use constructors. use methods to initialize the class members.
 */
import java.util.Scanner;

class Account {
    private String customerName;
    private long accountNumber;
    private String accountType;
    private double balance;

    // Method to initialize the class members
    void initialize(String name, long accNumber, String accType, double bal) {
        customerName = name;
        accountNumber = accNumber;
        accountType = accType;
        balance = bal;
    }

    // Method to accept deposit and update balance
    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    // Method to display balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Method to compute and deposit interest
    void computeAndDepositInterest(double rate) {
        double interest = balance * (rate / 100);
        balance += interest;
        System.out.println("Interest of " + interest + " deposited.");
    }

    // Method to permit withdrawal and update balance
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to check for minimum balance, impose penalty if necessary, and update balance
    void checkMinimumBalance(double minBalance, double penalty) {
        if (balance < minBalance) {
            balance -= penalty;
            System.out.println("Penalty of " + penalty + " imposed.");
        }
    }
}

public class Main {
    public static void main(String ...args) {

        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        // Initialize account
        account.initialize("John Doe", 123456789, "savings", 5000);

        // Deposit money
        System.out.println("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        // Display balance
        account.displayBalance();

        // Compute and deposit interest
        account.computeAndDepositInterest(5.0);
        account.displayBalance();

        // Withdraw money
        System.out.println("Enter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);

        // Check minimum balance and impose penalty if necessary
        account.checkMinimumBalance(1000, 50);

        // Display final balance
        account.displayBalance();

        scanner.close();
    }
}
/*
Enter deposit amount: 
2000
2000.0 deposited successfully.
Current balance: 7000.0
Interest of 350.0 deposited.
Current balance: 7350.0
Enter withdrawal amount: 
7000
7000.0 withdrawn successfully.
Penalty of 50.0 imposed.
Current balance: 300.0

Process finished with exit code 0

 */
