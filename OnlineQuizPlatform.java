import java.util.Scanner;

public class OnlineQuizPlatform {
    
    private static double balance = 0.0;

    // Method to show the menu
    public static void showMenu() {
        System.out.println("\nWelcome to the Banking Application");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }

    // Method to deposit money
    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Deposited: " + depositAmount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Method to withdraw money
    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("Withdrawn: " + withdrawAmount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // Keep showing menu until user exits
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    depositMoney(scanner);
                    break;
                case 2:
                    withdrawMoney(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you for using the Banking Application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
