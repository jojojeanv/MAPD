package Exception;

public class InexistentPlaceException extends Exception {
	
	public InexistentPlaceException() {
		super("This Place is not in the PetriNetWork");
	}
	
	public InexistentPlaceException(String s) {
		super(s);
	}
}
