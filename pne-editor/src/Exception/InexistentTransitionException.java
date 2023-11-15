package Exception;

public class InexistentTransitionException extends Exception{
	
	public InexistentTransitionException() {
		super("This Transition does not exist");
	}
	
	public InexistentTransitionException(String s) {
		super(s);
	}

}
