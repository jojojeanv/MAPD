package NetworkClasses;

public class ArcIn extends Arc {
	
	private Place destination;
	private Transition origin;
	
	/*
	 * Description : Creates an ArcIn and defines its origin, its destination and its weight
	 */
	public ArcIn(Transition origin, Place destination, int weight) {

		this.origin = origin;
		this.destination = destination;
		super.weight = Math.abs(weight);
	}
	
	/*
	 * Description : return this arc's destination.
	 */
	public Place getDestination() {
		return this.destination;
	}
	
	/*
	 * Description : return this arc's origin.
	 */
	public Transition getOrigin() {
		return this.origin;
	}
	
	/*
	 * Description : returns true if the Arc is an ArcIn false otherwise.
	 */
	public boolean isIn() {
		return true;
	}
}
