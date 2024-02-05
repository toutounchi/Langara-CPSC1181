/**
 * CollegeException exception class extends the RuntimeException and prints personalized
 * Message and throw the exception.
 */
public class CollegeExceptions extends RuntimeException
{
	/**
	 * default constructor follows the default constructor from the parent class.
	 */
	public CollegeExceptions(){ }
	/**
	 * modified constructor will take in
	 * @param message as string and store it in the parent class.
	 */
	public CollegeExceptions (String message){
		super(message);
	}
}