package customExceptions;

public class IllegalSizeException extends Exception {

	
	private int size;
	private String customMessage;
	
	private static final long serialVersionUID = 1L;

	public IllegalSizeException(int size) {
		super("The size: "+size+" is ilegal uncompatible");
		this.size= size;
		customMessage = decideMessageISE();
	}
	
	public String getCustomMessage() {
		return customMessage;
	}
	/**
	 * this method verify when a number is even, and verify when a number is greater than 100 and verify when a number is negative.
	 * @return an exception message
	 */
	public String decideMessageISE() {
		if(size < 1) {
			customMessage = "Enter a positive integer";
		}else if(size > 100) {
			customMessage = "Enter a number less than 100";
		}else if(size%2 ==0) {
			customMessage = "Enter a valid odd number";
		}else {
			customMessage ="Please enter the required values";
		}
		return customMessage;
	}
	
	@Override
	public String getMessage() {
		return getCustomMessage();
	}
	
}

