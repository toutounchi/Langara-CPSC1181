import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bank Tester Class will test the various functions from BankAccount and The Bank Class.
 */
public class BankTest {
    public static void main(String[] args) {
        //Bank account for various function the bank and some variables for calculation is initialized.
        BankAccount found;
        int selection, accountNum;
        int option;
        double initialAm, depositAm, withdrawAm;
        Bank tDbank = new Bank();
        do {
            //Program will continue until the user enters digit 1.
            try {
                //this block will be tried for any possible exception.
                Scanner input = new Scanner(System.in);
                menu();
                selection = input.nextInt();
                input.nextLine();

                switch (selection) {
                    case 1:
                        //Case 1 is to help the user add a bank account through the bank account.
                        System.out.println("***Adding a new Bank account***");
                        System.out.println("Please enter the account number between 1000 and 9999:");
                        accountNum = input.nextInt();
                        input.nextLine();
                        System.out.println("What is the initial amount for the account?");
                        initialAm = input.nextDouble();
                        input.nextLine();
                        tDbank.addAccount(new BankAccount(accountNum, initialAm));
                        System.out.println("Bank Account successfully recorde in the bank.");
                        break;

                    case 2:
                        //Case 2 is to help the user to find the balance and test the getBalance function of the bank account.
                        System.out.println("\n***Get the balance of a BankAccount based on the account number***");
                        found = findAccount(tDbank);
                        System.out.println("\nBalance on the corresponding account is: " + found.getBalance());
                        break;

                    case 3:
                        //Case 3 is to deposit the money into the existing bank account from the Bank class.
                        System.out.println("\n***Deposit money to an existing BankAccount***");
                        System.out.println("How much would you like to deposit?");
                        depositAm = input.nextDouble();
                        System.out.println("What is the Corresponding bank account number?");
                        accountNum =input.nextInt();
                        tDbank.deposit(accountNum,depositAm);
                        System.out.println("successful deposit");
                        break;

                    case 4:
                        //Case 4 is to deposit the money through Bank class.
                        System.out.println("\n***Withdraw money from an existing BankAccount***");
                        System.out.println("How much would you like to withdraw");
                        withdrawAm = input.nextDouble();
                        System.out.println("What is the Corresponding bank account number?");
                        accountNum =input.nextInt();
                        tDbank.withdraw(accountNum,withdrawAm);
                        System.out.println("successful withdraw");
                        break;

                    case 5:
                        //Case 5 will find the corresponding account that has the highest balance, function from bank class.
                        System.out.println("\n***Find a BankAccount with the highest balance***");
                        found = tDbank.getMaximum();
                        System.out.println("\nAccount with highest balance is:\n" +"Bank account number: "+ found.getAccountNumber() + "\tBalance: " + found.getBalance());
                        break;

                    case 6:
                        //Case 6 is to find the bank account with the lowest balance in the Bank from the bank class.
                        System.out.println("\n***Find a BankAccount with the lowest balance***");
                        found = tDbank.getMinimum();
                        System.out.println("\nAccount with lowest balance is:\n" + "Bank account number: " + found.getAccountNumber() + "\tBalance: " + found.getBalance());
                        break;

                    default:
                        //Default class to find out if any illegal argument was passed through the switch.
                        throw new IllegalArgumentException();
                }
        }

        catch (InputMismatchException exception)
        {
            System.out.println("\nInvalid entry make sure  you enter the proper digit entry");
        }
        catch (BankAccountException exception)
        {
            System.out.println(exception.getMessage());
        }

        catch (IllegalArgumentException exception)
        {
            System.out.println("\nInvalid entry for the menu");
        }
        catch (BankException exception)
        {
            System.out.println(exception.getMessage());
        }
            System.out.println("\nwould you like to continue the program?");
            System.out.println("[1]\tYES\t[2]\tNO");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
        } while (option == 1);
        //Finally the stored values in the bank and the total value of the bank wil be displayed.
        System.out.println("stored values in your bank are: " + tDbank);
        System.out.println("The total value stored in this bank is: " + tDbank.getTotalBalance());
    }

    public static void menu ()
    {
        //Menu bar for the user to navigate through switch.
        System.out.println("**Welcome to TD bank**");
        System.out.println("PLease choose one of the following:");
        System.out.println("[1] Add a new bank account");
        System.out.println("[2] Get the balance of the BankAccount based on the account number");
        System.out.println("[3] Deposit money to an existing BankAccount");
        System.out.println("[4] withdraw money from an existing BankAccount");
        System.out.println("[5] Find a BankAccount with the highest balance");
        System.out.println("[6] Find a BankAccount with the lowest balance\n\n");
    }

    public static BankAccount findAccount (Bank td)
    {
        //Find account class to help the user to find the corresponding account from the bank account number.
        Scanner input = new Scanner(System.in);
        int accountNum;
        System.out.println("Please enter the account number:");
        accountNum = input.nextInt();
        return td.find(accountNum);
    }
}
