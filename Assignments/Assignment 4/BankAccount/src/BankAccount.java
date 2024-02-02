/**
 * Bank account class will create the BankAccount object
 * Bank accounts can be stored in the arraylist of class bank.
 */
public class BankAccount {
    private double balance;
    private int accountNumber;

    /**
     * Bank account constructor will get the bank account  and set the initial balance to zero.
     * @param anAccountNumber has to be an integer between 1000 and 9999, If the account is not as followed exception is thrown.
     */
    public BankAccount(int anAccountNumber){
        if ((anAccountNumber < 1000 || anAccountNumber > 9999))
            throw new BankAccountException("Bank Account Number entered must be 4 digits");
        balance = 0;
        accountNumber = anAccountNumber;
    }

    /**
     * Second Bank account constructor can be used when both the account number and initial balance is passed.
     * @param anAccountNumber has to be an integer between 1000 and 9999, If the account is not as followed exception is thrown.
     * @param initialBalance can be double value not negative.
     */
    public BankAccount(int anAccountNumber, double initialBalance){
        if ((anAccountNumber < 1000 || anAccountNumber > 9999))
            throw new BankAccountException("Bank Account Number entered must be 4 digits");
        if (initialBalance <0)
            throw new BankAccountException("The initial balance can not be less than zero");
        balance = initialBalance;
        accountNumber = anAccountNumber;
    }

    /**
     * @return the balance of the corresponding bank account.
     */
    public double getBalance() {

        return balance;
    }

    /**
     * @return the bank account number corresponding with the account.
     */
    public int getAccountNumber(){

        return accountNumber;
    }

    /**
     * Will add the passed amount to the bank account.
     * @param amount has to be a double that the user wants to add to the bank account.
     */
    public void deposit(double amount){

        balance += amount;
    }

    /**
     * Will withdraw the amount from the bank account.
     * @param amount has to be a double type, Exception is thrown if the balance is less than the amount requested to withdraw.
     */
    public void withdraw(double amount){
        if ( (balance - amount) < 0)
            throw new BankAccountException("You do not have sufficient fund to withdraw");
        balance -= amount;
    }

    /**
     * @return string of the bank account number and the balance.
     */
    @Override
    public String toString(){

        return "Account Number: " + accountNumber + "  balance: " + balance;
    }
}
