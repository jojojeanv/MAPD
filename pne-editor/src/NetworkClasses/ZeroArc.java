package NetworkClasses;

public class ZeroArc extends ArcOut {
	
	/*
	 * Description : creates a zeroArc.
	 */
	public ZeroArc(Place origin, Transition destination, int poids) {
		super(origin, destination, poids);
		super.isZero = true;
	}

}
