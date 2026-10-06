package org.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity 

public class Bank_Accounts {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int account_id;

	    @ManyToOne 
	    @JoinColumn(name = "customer_id", nullable = false)
	    private Customer customer;

		@OneToMany(mappedBy = "bankAccount")
	    private List<Transactions> transactions;

	    private String account_number;

	    private double balance;

	    public Bank_Accounts() {
	    }

	    public Bank_Accounts(Customer customer, String account_number, double balance) {
	        this.customer = customer;
	        this.account_number = account_number;
	        this.balance = balance;
	    }

	    public int getAccount_id() {
	        return account_id;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

		public List<Transactions> getTransactions() {
	        return transactions;
	    }

	    public String getAccount_number() {
	        return account_number;
	    }

	    public double getBalance() {
	        return balance;
	    }
	
}
