package NetworkClasses;


import java.util.ArrayList;

import Exception.*;



public class PetriNetwork {
	
	private ArrayList <ArcIn> arcInList;
	private ArrayList <ArcOut> arcOutList;
	private ArrayList <Transition> transitionList;
	private ArrayList <Place> placeList;
	
	
	/*
	 * Description : Create an empty PetriNetwork.
	 */
	public PetriNetwork() {
		this.arcInList = new ArrayList<ArcIn>();
		this.arcOutList = new ArrayList<ArcOut>();
		this.transitionList = new ArrayList<Transition>();
		this.placeList = new ArrayList<Place>();
	}
	
	/*
	 * Description : return the list of places.
	 */
	public ArrayList<Place> getPlace() {
		return this.placeList;
	}
	
	/*
	 * Description : return the list of transitions.
	 */
	public ArrayList<Transition> getTransition() {
		return this.transitionList;
	}
	
	/*
	 * Description : return the list of ArcIn.
	 */
	public ArrayList<ArcIn> getArcIn() {
		return this.arcInList;
	}
	
	/*
	 * Description : return the list of ArcOut.
	 */
	public ArrayList<ArcOut> getArcOut() {
		return this.arcOutList;
	}
	
	/*
	 * Description : add an ArcIn to the PetriNetwork and link it to its Origin and Destination.
	 * Exception : -Throws exception if the Origin or the Destination isn't already in the PetriNetwork.
	 * 
	 * More Info : If an ArcIn already exist between the destination and origin, the weight of this arc
	 * is added to the existing arc.
	 */
	public void addArcIn(ArcIn arc) 
			throws InexistentPlaceException {
		
		if (!this.placeList.contains(arc.getDestination()) || 
				!this.transitionList.contains(arc.getOrigin())) {
			throw new InexistentPlaceException("The transition of origin isn't in the PetriNetwork");
		}
		
		boolean levier = true;
		
		for (ArcIn var : arc.getOrigin().getArcIn()) {
			if (arc.getDestination().getArcIn().contains(var)) {
				var.setWeight(var.getWeight() + Math.abs(arc.getWeight()));
				levier = false;
			}
		}
		
		if (levier) {
			Place p = arc.getDestination();
			Transition t = arc.getOrigin();
			
			p.addArcIn(arc);
			t.addArcIn(arc);
			this.arcInList.add(arc);
		}
	}
	
	/*
	 * Description : add an ArcOut to the PetriNetwork and link it to its Origin and Destination.
	 * Exception : -Throws exception if the Origin or the Destination isn't already in the PetriNetwork.
	 * 
	 * More Info : If an ArcOut already exist between the destination and origin, the weight of this arc
	 * is added to the existing arc.
	 */
	public void addArcOut(ArcOut arc) 
			throws InexistentPlaceException {
		
		if (!this.placeList.contains(arc.getOrigin()) || 
				!this.transitionList.contains(arc.getDestination())) {
			throw new InexistentPlaceException("The place of origin isn't in the PetriNetwork");
		}
		
		boolean levier = true;
		
		for (ArcOut var : arc.getOrigin().getArcOut()) {
			if (arc.getDestination().getArcOut().contains(var)) {
				var.setWeight(var.getWeight() + Math.abs(arc.getWeight()));
				levier = false;
			}
		}
		
		if (levier) {
			Transition t = arc.getDestination();
			Place p = arc.getOrigin();
			
			t.addArcOut(arc);
			p.addArcOut(arc);
			this.arcOutList.add(arc);
			}
	}
	
	/*
	 * Description : add a Transition to the list of transition.
	 */
	public void addTransition(Transition transition) {
		this.transitionList.add(transition);		
	}
	
	/*
	 * Description : add a Place to the list of place.
	 */
	public void addPlace(Place place) {
		this.placeList.add(place);
	}
	
	/*
	 * Description : Remove an ArcIn from the PetriNetwork and disconnect it from its Origin and Destination.
	 * Exception : - Throws Exception if the ArcIn isn't in the PetriNetwork
	 */
	public void removeArcIn(ArcIn arc) 
			throws InexistentArcInException {
		
		if (!this.arcInList.contains(arc)) {
			throw new InexistentArcInException();
		}
			
		Transition t = arc.getOrigin();
		t.removeArcIn(arc);
		
		Place p = arc.getDestination();
		p.removeArcIn(arc);
		
		int n0 = this.arcInList.indexOf(arc);
		this.arcInList.remove(n0);
	}
	
	/*
	 * Description : Remove an ArcOut from the PetriNetwork and disconnect it from its Origin and Destination.
	 * Exception : - Throws Exception if the ArcOut isn't in the PetriNetwork
	 */
	public void removeArcOut(ArcOut arc) 
			throws InexistentArcOutException {
		
		if (!this.arcOutList.contains(arc)) {
			throw new InexistentArcOutException();
		}
		Transition t = arc.getDestination();
		t.removeArcOut(arc);
		
		Place p = arc.getOrigin();
		p.removeArcOut(arc);
		
		int n = this.arcOutList.indexOf(arc);
		this.arcOutList.remove(n);
	}
		
	/*
	 * Description : Remove a Place from the PetriNetwork and all the arcs connected to it.
	 *  Exception : - Throws Exception if the place we are trying to remove isn't in the PetriNetwork.
	 */
	public void removePlace(Place place) 
			throws InexistentPlaceException, 
			InexistentArcOutException, 
			InexistentArcInException {
		
		if (!this.placeList.contains(place)) {
			throw new InexistentPlaceException();
		}
		
		ArrayList <ArcIn> toRemoveI = new ArrayList<ArcIn>();
		for (ArcIn arc : place.getArcIn()) {
			toRemoveI.add(arc);
			arc.getOrigin().removeArcIn(arc);
		}
		for (ArcIn arc : toRemoveI) {
			this.removeArcIn(arc);
		}
		
		ArrayList <ArcOut> toRemoveO = new ArrayList<ArcOut>();
		for (ArcOut arc : place.getArcOut()) {
			toRemoveO.add(arc);
			arc.getDestination().removeArcOut(arc);
		}
		for (ArcOut arc : toRemoveO) {
			this.removeArcOut(arc);
		}
		
		int n = this.placeList.indexOf(place);
		this.placeList.remove(n);
	}
	
	/*
	 * Description : Remove a Transition from the PetriNetwork and all the arcs connected to it.
	 * Exception : - Throws Exception if the transition we are trying to remove isn't in the PetriNetwork.
	 */
	public void removeTransition(Transition transition) 
			throws InexistentTransitionException, 
			InexistentArcInException,
			InexistentArcOutException {
		
		if (!this.transitionList.contains(transition)) {
			throw new InexistentTransitionException();
		}
		
		ArrayList <ArcIn> toRemoveI = new ArrayList<ArcIn>();
		for (ArcIn arc : transition.getArcIn()) {
			toRemoveI.add(arc);
			arc.getDestination().removeArcIn(arc);
		}
		for (ArcIn arc : toRemoveI) {
			this.removeArcIn(arc);
		}
		
		ArrayList <ArcOut> toRemoveO = new ArrayList<ArcOut>();
		for (ArcOut arc : transition.getArcOut()) {
			toRemoveO.add(arc);
			arc.getOrigin().removeArcOut(arc);
		}
		for (ArcOut arc : toRemoveO) {
			this.removeArcOut(arc);
		}
		
		int n = this.transitionList.indexOf(transition);
		this.transitionList.remove(n);
	}

	/*
	 * Description : Display the current state of the PetriNetwork
	 */
	public void show() {
		
		System.out.println("Reseau de Petri :");
		System.out.println("Nb de Places : " + this.placeList.size());
		System.out.println("Nb de Transitions : " + this.transitionList.size());
		System.out.println("Nb d'arcs : " + (this.arcInList.size() + this.arcOutList.size()));
		System.out.println("\n");
		
		System.out.println("Liste des places :");
		int index1 = 1;
		for (Place place : this.placeList) {
			System.out.println(index1 +
					" : place avec " +
					place.getTokens() + "jetons," +
					+ place.getArcIn().size() +
					" arcs simples entrants et " +
					place.getArcOut().size() +
					" arcs simples sortants.");
			++index1;
		}
		System.out.println("\n");
		
		System.out.println("Liste des transitions :");
		int index2 = 1;
		for (Transition transition : this.transitionList) {
			System.out.println(index2 +
					" : transition avec " +
					transition.getArcOut().size() +
					" arcs simples entrants et " +
					transition.getArcIn().size() +
					" arcs simples sortants.");
			++index2;
		}
		System.out.println("\n");
		
		System.out.println("Liste des arcs :");
		int index3 = 1;
		for (ArcIn arc : this.arcInList) {
			System.out.println(index3 + " : arc simple avec un poids de : " + arc.getWeight());
			System.out.println("l'arc va d'une transition vers une place avec " +
						arc.getDestination().getTokens() + " jetons");
			++index3;
		}
		for (ArcOut arc : this.arcOutList) {
			System.out.println(index3 + " : arc simple avec un poids de : " + arc.getWeight());
			System.out.println("l'arc va d'une place avec " +
					arc.getOrigin().getTokens() + " jetons vers une transition");
			++index3;
		}
	}
}
