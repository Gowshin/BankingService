package org.application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Banking System Application");
		System.out.println("1.Adding a new customer and creating a bank account...");
		System.out.println("2.Transferring funds between accounts...");
		System.out.println("3.Viewing transaction history for an account...");
		System.out.println("Enter your choice (1-3): ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		if (choice == 1) {
			System.out.print("Enter customer name: ");
			String customerName = scanner.nextLine();
			System.out.print("Enter account number: ");
			String accountNumber = scanner.nextLine();
			System.out.print("Enter initial balance: ");
			double initialBalance = scanner.nextDouble();

			AddCustomer addCustomer = new AddCustomer();
			addCustomer.addnewCustomer(customerName, accountNumber, initialBalance);

		}else if (choice == 2) {
			System.out.print("Enter source account number: ");
			String fromAccountNumber = scanner.nextLine();
			System.out.print("Enter destination account number: ");
			String toAccountNumber = scanner.nextLine();
			System.out.print("Enter amount to transfer: ");
			double amount = scanner.nextDouble();

			TransferService transferService = new TransferService();
			transferService.transferFunds(fromAccountNumber, toAccountNumber, amount);
		
		}else if (choice == 3) {
			System.out.print("Enter account number to view transaction history: ");
			String accountNumber = scanner.nextLine();

			TransactionHistory transactionHistory = new TransactionHistory();
			transactionHistory.viewTransactionHistory(accountNumber);
			scanner.close();
		}else {
			System.out.println("Invalid choice. Exiting the application.");
		}
		
		scanner.close();
	}
}