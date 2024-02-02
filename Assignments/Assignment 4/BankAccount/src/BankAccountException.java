/**
 * Bank Account exception class extends the RuntimeException and prints personalized
 * Message and throw the exception.
 */
public class BankAccountException extends RuntimeException
{
	/**
	 * default constructor follows the default constructor from the parent class.
	 */
	public BankAccountException(){}

	/**
	 * modified constructor will take in
	 * @param message as string and store it in the parent class.
	 */
	public BankAccountException(String message){
		super(message);
	}
}