package org.Entity;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false) 
    private Bank_Accounts bankAccount;

    private String transaction_type;

    private double amount;

    @CreationTimestamp 
    private LocalDateTime transaction_timestamp;

    public Transactions() {
    }

    public Transactions(Bank_Accounts bankAccount, String transaction_type, double amount) {        
        this.bankAccount = bankAccount;
        this.transaction_type = transaction_type;
        this.amount = amount;
        
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public Bank_Accounts getBankAccount() {
        return bankAccount;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransaction_timestamp() {
        return transaction_timestamp;
    }

}
