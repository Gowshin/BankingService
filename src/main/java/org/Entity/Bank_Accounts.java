package org.Entity;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity 

public class Bank_Accounts {

	    @Id 
		@GeneratedValue(generator = "custom-id")
    	@GenericGenerator(name = "custom-id", strategy = "org.Entity.CustomIdGenerator")
	    private String account_number;

	    @ManyToOne 
	    @JoinColumn(name = "customer_id", nullable = false)
	    private Customer customer;

		@OneToMany(mappedBy = "bankAccount")
	    private List<Transactions> transactions;


	    private double balance;

	    public Bank_Accounts() {
	    }

	    public Bank_Accounts(Customer customer, double balance) {
	        this.customer = customer;
	        this.balance = balance;
	    }

	    public String getAccount_number() {
	        return account_number;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

		public List<Transactions> getTransactions() {
	        return transactions;
	    }

	    public double getBalance() {
	        return balance;
	    }

		public void setBalance(double newBalance) {
		    this.balance = newBalance;
		}
	
}
