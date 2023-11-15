package NetworkClasses;

import Exception.InexistentPlaceException;

public class Main {
	
	public static void main(String args[]) throws InexistentPlaceException {
		PetriNetwork pn = new PetriNetwork();
		
		Transition t1 = new Transition();
		Transition t2 = new Transition();
		Transition t3 = new Transition();
		Transition t4 = new Transition();
		
		Place p1 = new Place();
		Place p2 = new Place(1);
		Place p3 = new Place();
		Place p4 = new Place(1);
		Place p5 = new Place(1);
		
		ArcOut a1 = new ArcOut(p1, t1, 1);
		ArcIn a2 = new ArcIn(t1, p2, 1);	
		ArcOut a3 = new ArcOut(p2, t2, 1);
		ArcIn a4 = new ArcIn(t2, p1, 1);		
		ArcOut a5 = new ArcOut(p5, t3, 1);
		ArcIn a6 = new ArcIn(t3, p4, 1);		
		ArcOut a7 = new ArcOut(p4, t4, 1);
		ArcIn a8 = new ArcIn(t4, p5, 1);		
		ArcOut a9 = new ArcOut(p3, t1, 1);
		ArcOut a10 = new ArcOut(p3, t3, 1);
		ArcIn a11 = new ArcIn(t2, p3, 1);
		ArcIn a12 = new ArcIn(t4, p3, 1);
		
		pn.addTransition(t1);
		pn.addTransition(t2);
		pn.addTransition(t3);
		pn.addTransition(t4);
		
		pn.addPlace(p1);
		pn.addPlace(p2);
		pn.addPlace(p3);
		pn.addPlace(p4);
		pn.addPlace(p5);
		
		pn.addArcOut(a1);
		pn.addArcIn(a2);
		pn.addArcOut(a3);
		pn.addArcIn(a4);
		pn.addArcOut(a5);
		pn.addArcIn(a6);
		pn.addArcOut(a7);
		pn.addArcIn(a8);
		pn.addArcOut(a9);
		pn.addArcOut(a10);
		pn.addArcIn(a11);
		pn.addArcIn(a12);
		
		pn.show();
		t4.pull();
		System.out.println("*\n*\n*");
		pn.show();
		t3.pull();
		System.out.println("*\n*\n*");
		pn.show();
		}
	}
