package NetworkClasses;

public class EmptyArc extends ArcOut{
	
	/*
	 * Description : creates an EmptyArc.
	 */
	public EmptyArc(Place origin, Transition destination, int poids) {
		super(origin, destination, poids);
		super.isEmpty = true;
	}

}
