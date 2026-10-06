package org.Config;

import org.Entity.Bank_Accounts;
import org.Entity.Customer;
import org.Entity.Transactions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {

	    private static SessionFactory factory;

	    static {
	        try {
	            factory = new Configuration()
	                    .configure("hibernatepostgres.cfg.xml")
	                    .addAnnotatedClass(Customer.class)
	                    .addAnnotatedClass(Bank_Accounts.class)
	                    .addAnnotatedClass(Transactions.class)
	                    .buildSessionFactory();

	        } catch (Exception e) {
	            throw new ExceptionInInitializerError(e);
	        }
	    }

	    public static SessionFactory getFactory() {
	        return factory;
	    }

	    public static Session getSession() {
	        return factory.openSession();
	    }

}
