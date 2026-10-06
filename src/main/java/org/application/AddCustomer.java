package org.application;

import org.Config.Config;
import org.Entity.Bank_Accounts;
import org.Entity.Customer;
import org.Entity.Transactions;
import org.hibernate.Session;

public class AddCustomer {

        public void addnewCustomer(String customerName, String accountNumber, double initialBalance) {

                Session session = Config.getSession();

                session.beginTransaction();
                
                Customer cu = new Customer(customerName);
                session.persist(cu);

                Bank_Accounts bk = new Bank_Accounts(cu, accountNumber, initialBalance);
                session.persist(bk);

                Transactions tx = new Transactions(bk, "DEPOSIT", initialBalance);
                session.persist(tx);
                
                session.getTransaction().commit();

                session.close();
	}
}
