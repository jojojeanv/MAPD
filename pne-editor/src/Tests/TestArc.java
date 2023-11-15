package Tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Exception.InexistentArcInException;
import Exception.InexistentArcOutException;
import Exception.InexistentPlaceException;
import Exception.InexistentTransitionException;

import static org.junit.jupiter.api.Assertions.assertEquals;


import NetworkClasses.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestArc {

	
	Place p0 = new Place();
	Place p1 = new Place();
	Place p2 = new Place();
	Transition t0 = new Transition();
	Transition t1 = new Transition();
	Transition t2 = new Transition();
	
	@Test
	@Order(1)
	public void testArcIn() 
			throws InexistentPlaceException, 
			InexistentArcInException {
		
		PetriNetwork pn = new PetriNetwork();
		
		//Code : CAI0
		ArcIn a0 = new ArcIn(t0, p0, 1);
		pn.addPlace(p0);
		pn.addTransition(t0);
		pn.addArcIn(a0);
		assertEquals(1, a0.getWeight());
		assertEquals(a0, p0.getArcIn().get(0));
		assertEquals(a0, t0.getArcIn().get(0));
		
		//Code : CAI1
		ArcIn a2 = new ArcIn(t2, p2, -1);
		pn.addPlace(p2);
		pn.addTransition(t2);
		pn.addArcIn(a2);
		assertEquals(1, a2.getWeight());
		assertEquals(a2, p2.getArcIn().get(0));
		assertEquals(a2, t2.getArcIn().get(0));
	}
	
	@Test
	@Order(2)
	public void testArcOut() 
			throws InexistentPlaceException, 
			InexistentArcOutException {
		
		PetriNetwork pn = new PetriNetwork();
		
		//Code : CAO0
		ArcOut a0 = new ArcOut(p0, t0, 1);
		pn.addPlace(p0);
		pn.addTransition(t0);
		pn.addArcOut(a0);
		assertEquals(a0, p0.getArcOut().get(0));
		assertEquals(a0, t0.getArcOut().get(0));

		//Code : CAO1
		ArcOut a2 = new ArcOut(p2, t2, -1);
		pn.addPlace(p2);
		pn.addTransition(t2);
		pn.addArcOut(a2);
		assertEquals(1, a2.getWeight());
		assertEquals(a2, p2.getArcOut().get(0));
		assertEquals(a2, t2.getArcOut().get(0));
	}
	
	@Test
	@Order(3)
	public void testArcInDouble() 
			throws InexistentPlaceException, 
			InexistentArcInException {
		
		PetriNetwork pn = new PetriNetwork();
		
		//Code : AAID0
		ArcIn a0 = new ArcIn(t0, p0, 1);
		ArcIn a1 = new ArcIn(t0, p0, 1);
		pn.addPlace(p0);
		pn.addTransition(t0);
		pn.addArcIn(a0);
		pn.addArcIn(a1);
		assertEquals(1, p0.getArcIn().size());
		assertEquals(true, p0.getArcIn().contains(a0));
		assertEquals(1, t0.getArcIn().size());
		assertEquals(true, t0.getArcIn().contains(a0));
		assertEquals(2, a0.getWeight());
		
		//Code : AAID1
		Place p1 = new Place();
		Transition t1 = new Transition();
		ArcIn a2 = new ArcIn(t1, p1, 1);
		ArcIn a3 = new ArcIn(t1, p1, -1);
		pn.addPlace(p1);
		pn.addTransition(t1);
		pn.addArcIn(a2);
		pn.addArcIn(a3);
		assertEquals(1, p1.getArcIn().size());
		assertEquals(true, p1.getArcIn().contains(a2));
		assertEquals(1, t1.getArcIn().size());
		assertEquals(true, t1.getArcIn().contains(a2));
		assertEquals(2, a2.getWeight());
		
		//Code : AAID2
		Place p2 = new Place();
		Place p3 = new Place();
		Transition t2 = new Transition();
		Transition t3 = new Transition();
		ArcIn a4 = new ArcIn(t2, p2, 1);
		ArcIn a5 = new ArcIn(t2, p3, 1);
		ArcIn a6 = new ArcIn(t3, p2, 1);
		ArcIn a7 = new ArcIn(t2, p2, 2);
		pn.addPlace(p2);
		pn.addPlace(p3);
		pn.addTransition(t3);
		pn.addTransition(t2);
		pn.addArcIn(a4);
		pn.addArcIn(a7);
		pn.addArcIn(a6);
		pn.addArcIn(a5);
		assertEquals(2, p2.getArcIn().size());
		assertEquals(true, p2.getArcIn().contains(a4));
		assertEquals(true, p2.getArcIn().contains(a6));
		assertEquals(2, t2.getArcIn().size());
		assertEquals(true, t2.getArcIn().contains(a4));
		assertEquals(true, t2.getArcIn().contains(a5));
		assertEquals(3, a4.getWeight());
	}
	
	@Test
	@Order(3)
	public void testArcOutDouble() 
			throws InexistentPlaceException {
		
		PetriNetwork pn = new PetriNetwork();
		
		//Code : AAOD0
		Place p0 = new Place();
		Transition t0 = new Transition();
		ArcOut a0 = new ArcOut(p0, t0, 1);
		ArcOut a1 = new ArcOut(p0, t0, 1);
		pn.addPlace(p0);
		pn.addTransition(t0);
		pn.addArcOut(a0);
		pn.addArcOut(a1);
		assertEquals(1, p0.getArcOut().size());
		assertEquals(true, p0.getArcOut().contains(a0));
		assertEquals(1, t0.getArcOut().size());
		assertEquals(true, t0.getArcOut().contains(a0));
		assertEquals(2, a0.getWeight());
		
		//Code : AAOD1
		Place p1 = new Place();
		Transition t1 = new Transition();
		ArcOut a2 = new ArcOut(p1, t1, 1);
		ArcOut a3 = new ArcOut(p1, t1, -1);
		pn.addPlace(p1);
		pn.addTransition(t1);
		pn.addArcOut(a2);
		pn.addArcOut(a3);
		assertEquals(1, p1.getArcOut().size());
		assertEquals(true, p1.getArcOut().contains(a2));
		assertEquals(1, t1.getArcOut().size());
		assertEquals(true, t1.getArcOut().contains(a2));
		assertEquals(2, a2.getWeight());
		
		//Code : AADO2
		Place p2 = new Place();
		Place p3 = new Place();
		Transition t2 = new Transition();
		Transition t3 = new Transition();
		ArcOut a4 = new ArcOut(p2, t2, 1);
		ArcOut a5 = new ArcOut(p2, t3, 1);
		ArcOut a6 = new ArcOut(p3, t2, 1);
		ArcOut a7 = new ArcOut(p2, t2, 2);
		pn.addPlace(p3);
		pn.addPlace(p2);
		pn.addTransition(t3);
		pn.addTransition(t2);
		pn.addArcOut(a4);
		pn.addArcOut(a5);
		pn.addArcOut(a6);
		pn.addArcOut(a7);
		assertEquals(2, p2.getArcOut().size());
		assertEquals(true, p2.getArcOut().contains(a4));
		assertEquals(true, p2.getArcOut().contains(a5));
		assertEquals(2, t2.getArcOut().size());
		assertEquals(true, t2.getArcOut().contains(a4));
		assertEquals(true, t2.getArcOut().contains(a6));
		assertEquals(3, a4.getWeight());
	}
}