package NetworkClasses;

public class ArcOut extends Arc {
	
	private Place origin;
	private Transition destination;
	protected boolean isEmpty; 
	protected boolean isZero;
	
	/*
	 * Description : Creates an ArcOut and defines its origin, its destination and its weight
	 */
	public ArcOut(Place origin, Transition destination, int poids) {
		this.origin = origin;
		this.destination = destination;
		this.setWeight(poids);
		this.isEmpty = false;
		this.isZero = false;
	}
	
	/*
	 * Description : returns false if the Arc is an ArcOut true otherwise.
	 */
	public boolean isIn() {
		return false;
	}
	
	/*
	 * Description : returns this arc's origin.
	 */
	public Place getOrigin() {
		return this.origin;
		}
	
	/*
	 * Description : returns this arc's destination.
	 */
	public Transition getDestination() {
		return this.destination;
	}
	
	/*
	 * Description : returns true if this arc is an EmptyArc, false otherwise.
	 */
	public boolean getIsEmpty() {
		return this.isEmpty;
	}
	
	/*
	 * Description : returns true if this arc is an ZeroArc, false otherwise.
	 */
	public boolean getIsZero() {
		return this.isZero;
	}
 }
