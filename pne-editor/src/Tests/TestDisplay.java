package Tests;

import Exception.InexistentPlaceException;
import NetworkClasses.*;

public class TestDisplay {
	
	public static void main(String args[]) 
			throws InexistentPlaceException {
		
		/*
		 * For this set of test, we have decided to do
		 * the example given in 7.2. WARNING, the number associated to
		 * places and transitions isn't the same as in the paper, they 
		 * represent the order in which we've added them.
		 */
		
		System.out.println("*\nCR1\n*");
		
		//Code : CR1
		PetriNetwork pn = new PetriNetwork();
		pn.show();
		System.out.println("*\nCP1\n*");
		
		//Code : CP1
		Place p1 = new Place();
		pn.addPlace(p1);
		pn.show();
		System.out.println("*\nCP2\n*");
		
		//Code : CP2
		Place p2 = new Place(1);
		pn.addPlace(p2);
		pn.show();
		System.out.println("*\nCT1\n*");
		
		//Code : CT1
		Transition t1 = new Transition();
		pn.addTransition(t1);
		pn.show();
		System.out.println("*\nCPT1\n*");
		
		//Code : CPT1
		ArcOut a1 = new ArcOut(p1, t1, 1);
		pn.addArcOut(a1);
		pn.show();
		System.out.println("*\nCTP1\n*");
		
		//Code : CTP1
		ArcIn a2 = new ArcIn(t1, p2, 1);
		pn.addArcIn(a2);
		pn.show();
		System.out.println("*\nCT2\n*");
		
		//Code : CT2
		Transition t2 = new Transition();
		pn.addTransition(t2);
		pn.show();
		System.out.println("*\nCPT2\n*");
		
		//Code : CPT2
		ArcOut a3 = new ArcOut(p2, t2, 1);
		pn.addArcOut(a3);
		pn.show();
		System.out.println("*\nCTP2\n*");
		
		//Code : CTP2
		ArcIn a4 = new ArcIn(t2, p1, 1);
		pn.addArcIn(a4);
		pn.show();
		System.out.println("*\nCP4\n*");
		
		//Code : CP4
		Place p4 = new Place();
		pn.addPlace(p4);
		pn.show();
		System.out.println("*\nCP5\n*");
		
		//Code : CP5
		Place p5 = new Place(1);
		pn.addPlace(p5);
		pn.show();
		System.out.println("*\nCT3\n*");
		
		//Code : CT3
		Transition t3 = new Transition();
		pn.addTransition(t3);
		pn.show();
		System.out.println("*\nCPT3\n*");
		
		//Code : CPT3
		ArcOut a5 = new ArcOut(p5, t3, 1);
		pn.addArcOut(a5);
		pn.show();
		System.out.println("*\nCTP3\n*");
		
		//Code : CTP3
		ArcIn a6 = new ArcIn(t3, p4, 1);
		pn.addArcIn(a6);
		pn.show();
		System.out.println("*\nCT4\n*");
		
		//Code : CT4
		Transition t4 = new Transition();
		pn.addTransition(t4);
		pn.show();
		System.out.println("*\nCPT4\n*");
		
		//Code : CPT4
		ArcOut a7 = new ArcOut(p4, t4, 1);
		pn.addArcOut(a7);
		pn.show();
		System.out.println("*\nCTP4\n*");
		
		//Code : CTP4
		ArcIn a8 = new ArcIn(t4, p5, 1);
		pn.addArcIn(a8);
		pn.show();
		System.out.println("*\nCP6\n*");
		
		//Code : CP6
		Place p3 = new Place();
		pn.addPlace(p3);
		pn.show();
		System.out.println("*\nCPT5\n*");
		
		//Code : CPT5
		ArcOut a9 = new ArcOut(p3, t1, 1);
		pn.addArcOut(a9);
		pn.show();
		System.out.println("*\nCPT6\n*");
		
		//Code : CPT6
		ArcOut a10 = new ArcOut(p3, t3, 1);
		pn.addArcOut(a10);
		pn.show();
		System.out.println("*\nCTP5\n*");
		
		//Code : CTP5
		ArcIn a11 = new ArcIn(t2, p3, 1);
		pn.addArcIn(a11);
		pn.show();
		System.out.println("*\nCTP6\n*");
		
		//Code : CTP6
		ArcIn a12 = new ArcIn(t4, p3, 1);
		pn.addArcIn(a12);
		pn.show();
		}

}
