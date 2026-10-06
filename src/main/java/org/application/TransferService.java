package org.application;

import org.Config.Config;
import org.Entity.Bank_Accounts;
import org.Entity.Transactions;
import org.hibernate.Session;

public class TransferService {

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
		

        Session session = Config.getSession();

        session.beginTransaction();
        
        Bank_Accounts bk1 = session.find(Bank_Accounts.class, fromAccountNumber);
        Bank_Accounts bk2 = session.find(Bank_Accounts.class, toAccountNumber);
        
        Transactions tx1 = new Transactions(bk1, "WITHDRAWAL", amount);
        Transactions tx2 = new Transactions(bk2, "DEPOSIT", amount);
        
        session.persist(tx1);
        session.persist(tx2);
        
        session.getTransaction().commit();

        session.close();
	}
}
