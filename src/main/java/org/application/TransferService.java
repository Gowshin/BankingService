package org.application;

import org.Config.Config;
import org.Entity.Bank_Accounts;
import org.Entity.Transactions;
import org.hibernate.Session;

public class TransferService {

        public void transferFunds(String sourceAccountNumber,
                                  String destinationAccountNumber,
                                  double amount) {

                Session session = Config.getSession();

                session.beginTransaction();

                Bank_Accounts source = session.createQuery(
                                "from Bank_Accounts where account_number = :accountNumber",
                                Bank_Accounts.class)
                        .setParameter("accountNumber", sourceAccountNumber)
                        .uniqueResult();

                Bank_Accounts destination = session.createQuery(
                                "from Bank_Accounts where account_number = :accountNumber",
                                Bank_Accounts.class)
                        .setParameter("accountNumber", destinationAccountNumber)
                        .uniqueResult();

                if (source == null) {
                        System.out.println("Source account not found.");
                        session.getTransaction().rollback();
                        session.close();
                        return;
                }

                if (destination == null) {
                        System.out.println("Destination account not found.");
                        session.getTransaction().rollback();
                        session.close();
                        return;
                }

                if (sourceAccountNumber.equals(destinationAccountNumber)) {
                        System.out.println("Source and destination accounts cannot be same.");
                        session.getTransaction().rollback();
                        session.close();
                        return;
                }

                if (amount <= 0) {
                        System.out.println("Amount must be greater than zero.");
                        session.getTransaction().rollback();
                        session.close();
                        return;
                }

                if (source.getBalance() < amount) {
                        System.out.println("Insufficient balance.");
                        session.getTransaction().rollback();
                        session.close();
                        return;
                }

                // Update balances
                source.setBalance(source.getBalance() - amount);
                destination.setBalance(destination.getBalance() + amount);

                // Create transaction records
                Transactions sourceTransaction =
                        new Transactions(source, "TRANSFER", amount);

                Transactions destinationTransaction =
                        new Transactions(destination, "TRANSFER", amount);

                session.persist(sourceTransaction);
                session.persist(destinationTransaction);

                session.getTransaction().commit();

                session.close();

                System.out.println("Transfer successful!");
        }
}