import java.util.ArrayList;

/**
 * Class bank to construct a Bank class consist of Bank accounts
 */
public class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank()
    {
	  
        accounts = new ArrayList<>();
    }

    /**
     * Will add a bank account to the Bank does not return anything.
     * @param a is the bank account needed to be passed in in order to be added.
     */
    public void addAccount(BankAccount a) {accounts.add(a);}

    /**
     * Will calculate the total amount in all the accounts an return the double.
     * @return double the total amount in bank.
     */
    public double getTotalBalance()
    {
        double total = 0;
        for(BankAccount a : accounts)
        {
            total = total + a.getBalance();
        }
        return total;
    }

    /**
     Counts the number of bank accounts whose balance is less than a given value.
     @param atLeast the balance required to count an account
     @return the number of accounts having least the given balance
     */
    public int count(double atLeast)
    {
        int matches = 0;

        for(BankAccount a : accounts)
        {
            if (a.getBalance() >= atLeast)
                matches++;
        }
        return matches;
    }

    /**
     Finds a bank account with a given number.
     @param accountNumber the number to find
     @return the account with the given number, or null if there is no such account
     */
    public BankAccount find(int accountNumber)
    {
        for(BankAccount a : accounts)
        {
            if (a.getAccountNumber() == accountNumber)
                return a;
        }
        throw new BankException("There are no bank accounts corresponding to the account number: " + accountNumber);
    }

    /**
     Gets the bank account with the largest balance.
     @return the account with the largest balance, or null if the bank has no accounts
     */
    public BankAccount getMaximum()
    {
        if (accounts.isEmpty())
            throw new BankException("There are no BankAccounts in this Bank");

        BankAccount largest = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++)
        {
            BankAccount a = accounts.get(i);
            if (a.getBalance() > largest.getBalance())
                largest = a;
        }
        return largest;
    }

    /**
     * Will find the account that has the minimum amount stored in.
     * @return the bank account with minimum amount.
     */
    public BankAccount getMinimum()
    {
        if (accounts.isEmpty())
            throw new BankException("There are no BankAccounts in this Bank");

        BankAccount Smallest = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++)
        {
            BankAccount a = accounts.get(i);
            if (a.getBalance() < Smallest.getBalance())
                Smallest = a;
        }
        return Smallest;
    }

    /**
     * deposit helps the user to deposit money into specefic account.
     * @param bankAccountNumber needs to be an integer number representing the account
     * @param amount needs to be a double number that is going to be deposited into the account.
     */
    public void deposit (int bankAccountNumber, double amount)
    {
        if (amount <= 0)
            throw new BankException("The amount entered can not be equal or less than zero");
        BankAccount temp = null;
        for (BankAccount a: accounts)
        {
            if (a.getAccountNumber() == bankAccountNumber)
            {
                temp = a;
                break;
            }
        }

        if (temp == null)
            throw new BankException("No bank corresponding with " + bankAccountNumber +" account was found ");
        temp.deposit(amount);
    }

    /**
     * Withdraw will help the user withdraw money from specefic account.
     * @param bankAccountNumber has to be integer representing the account
     * @param amount has to be double representing the amount needs to be withdrawn.
     */
    public void withdraw (int bankAccountNumber, double amount)
    {
        if (amount <= 0)
            throw new BankException("The amount entered can not be equal or less than zero");
        BankAccount temp = null;
        for (BankAccount a: accounts)
        {
            if (a.getAccountNumber() == bankAccountNumber)
            {
                temp = a;
                break;
            }
        }

        if (temp == null)
            throw new BankException("No bank corresponding with " + bankAccountNumber +" account was found ");
        temp.withdraw(amount);
    }

    /**
     * Helps the user to print out the accounts under Bank account class
     * @return String representing bank accounts.
     */
    public String toString()
    {
        return "Bank " + accounts.toString();
    }
}
