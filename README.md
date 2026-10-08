Here's a summary of the changes made in the recent edits:
1. **Main.java**:
   - The method call to `addnewCustomer` was updated to remove the `accountNumber` parameter, reflecting a change in the method signature.
2. **AddCustomer.java**:
   - The `addnewCustomer` method signature was modified to remove the `accountNumber` parameter.
   - The instantiation of `Bank_Accounts` was updated to match the new constructor signature that no longer requires an `accountNumber`.
3. **Transactions.java**:
   - The `@JoinColumn` annotation for the `bankAccount` field was updated to use `account_number` instead of `account_id`, reflecting a change in the database schema or entity mapping.
4. **CustomIdGenerator.java**:
   - A new class `CustomIdGenerator` was added to generate custom account numbers with a prefix "ACC" followed by a numeric value based on the count of existing bank accounts.
5. **Bank_Accounts.java**:
   - The constructor for `Bank_Accounts` was updated to remove the `account_number` parameter, aligning with the changes made in `AddCustomer.java`.  
