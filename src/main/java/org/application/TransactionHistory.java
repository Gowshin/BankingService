package org.application;

import java.util.List;

import org.Entity.Bank_Accounts;
import org.Entity.Transactions;
import org.hibernate.Session;
import org.Config.Config;

public class TransactionHistory {

    public void viewTransactionHistory(String accountNumber) {

        Session session = Config.getSession();

        Bank_Accounts bankAccount = session.find(Bank_Accounts.class, accountNumber);

        if (bankAccount != null) {
            List<Transactions> transactions = bankAccount.getTransactions();

            System.out.println("Transaction History for Account Number: " + accountNumber);
            for (Transactions transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getTransaction_id() +
                        ", Type: " + transaction.getTransaction_type() +
                        ", Amount: " + transaction.getAmount() +
                        ", Date: " + transaction.getTransaction_timestamp());
            }
        } else {
            System.out.println("No account found with account number: " + accountNumber);
        }

        session.close();
    }
}