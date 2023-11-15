package NetworkClasses;

public interface ServiceInterface {
	
	void addArcIn(ArcIn arc);
	
	void addArcOut(ArcOut arc);
	
	void addPlace(Place place);
	
	void addTransition(Transition transition);
	
	void removeArcIn(ArcIn arc);
	
	void removeArcOut(ArcOut arc);
	
	void removePlace(Place place);
	
	void removeTransition(Transition transition);
}
