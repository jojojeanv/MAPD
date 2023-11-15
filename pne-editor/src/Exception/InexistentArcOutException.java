package Exception;

public class InexistentArcOutException extends Exception{

	public InexistentArcOutException() {
		super("This arc does not exist");
	}
	
	public InexistentArcOutException(String s) {
		super(s);
	}

}
