package org.Entity;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;

public class CustomIdGenerator implements IdentifierGenerator {
   private String prefix = "ACC";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        // Query the database or sequence for the next numeric value
        String query = "SELECT count(b) FROM Bank_Accounts b";
        Long count = session.createQuery(query, Long.class).getSingleResult();
        
        return prefix + String.format("%04d", count + 1); // e.g., INV-0001
    }
}