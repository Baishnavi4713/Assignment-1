import java.util.Scanner;

class BankAccount {
    private String name;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Current Balance: " + balance);
        } else {
            System.out.println("Error: Insufficient funds. Current Balance: " + balance);
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Account
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, accountNumber, balance);
        account.displayAccountInfo();

        // Perform operations
        while (true) {
            System.out.println("\nChoose operation: 1. Deposit  2. Withdraw  3. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
            } else {
                break;
            }
        }

        System.out.println("Thank you for using our banking system!");
        scanner.close();
    }
}
