package Exception;

public class InexistentArcInException extends Exception {
	
	public InexistentArcInException() {
		super("This arc does not exist");
	}
	
	public InexistentArcInException(String s) {
		super(s);
	}

}
