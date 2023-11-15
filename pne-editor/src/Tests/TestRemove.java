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
public class TestRemove {
	
	@Order(1)
	@Test
	public void TestRemovePlace() 
			throws InexistentPlaceException, 
			InexistentArcOutException, 
			InexistentArcInException, 
			InexistentTransitionException  {
		
		PetriNetwork pn = new PetriNetwork();
		Place p0 = new Place();
		
		//Code : RP
		pn.addPlace(p0);
		pn.removePlace(p0);
		assertEquals(false, pn.getPlace().contains(p0));
 	}
	
	@Order(2)
	@Test
	public void TestRemoveTransition() 
			throws InexistentPlaceException, 
			InexistentArcOutException, 
			InexistentArcInException, 
			InexistentTransitionException {
		
		PetriNetwork pn = new PetriNetwork();
		Transition t0 = new Transition();
		
		//Code : RT
		pn.addTransition(t0);
		pn.removeTransition(t0);
		assertEquals(false, pn.getTransition().contains(t0));
 	}
	
	@Order(3)
	@Test
	public void TestRemoveArc() 
			throws InexistentPlaceException, 
			InexistentArcOutException, 
			InexistentArcInException, 
			InexistentTransitionException {
		
		PetriNetwork pn = new PetriNetwork();
		Transition t0 = new Transition();
		Place p0 = new Place();
		ArcIn a0 = new ArcIn(t0, p0, 0);
		ArcOut a1 = new ArcOut(p0, t0, 0);
		
		pn.addTransition(t0);
		pn.addPlace(p0);
		
		//Code : RA1
		pn.addArcIn(a0);
		pn.removeArcIn(a0);
		assertEquals(false, pn.getArcIn().contains(a0));
		assertEquals(false, p0.getArcIn().contains(a0));
		assertEquals(false, t0.getArcIn().contains(a0));
		
		//Code : RA2
		pn.addArcOut(a1);
		pn.removeArcOut(a1);
		assertEquals(false, pn.getArcOut().contains(a1));
		assertEquals(false, p0.getArcOut().contains(a1));
		assertEquals(false, t0.getArcOut().contains(a1));
 	}
	
	@Order(4)
	@Test
	public void TestRemovePlaceLinked() 
			throws InexistentPlaceException, 
			InexistentArcOutException, 
			InexistentArcInException, 
			InexistentTransitionException {
		
		PetriNetwork pn = new PetriNetwork();
		Transition t0 = new Transition();
		Transition t1 = new Transition();
		Place p0 = new Place();
		ArcIn a0 = new ArcIn(t0, p0, 0);
		ArcOut a1 = new ArcOut(p0, t0, 0);
		ArcIn a2 = new ArcIn(t1, p0, 0);
		ArcOut a3 = new ArcOut(p0, t1, 0);
		
		pn.addTransition(t0);
		pn.addTransition(t1);
		pn.addPlace(p0);
		pn.addArcIn(a0);
		pn.addArcOut(a1);
		
		//Code : RPL1
		pn.removePlace(p0);
		assertEquals(false, pn.getPlace().contains(p0));
		assertEquals(false, pn.getArcIn().contains(a0));
		assertEquals(false, t0.getArcIn().contains(a0));
		assertEquals(false, pn.getArcOut().contains(a1));
		assertEquals(false, t0.getArcOut().contains(a1));
		
		//Code : RPL2
		pn.addPlace(p0);
		pn.addArcIn(a0);
		pn.addArcOut(a1);
		pn.addArcIn(a2);
		pn.addArcOut(a3);
		pn.removePlace(p0);
		assertEquals(false, pn.getPlace().contains(p0));
		assertEquals(false, pn.getArcIn().contains(a0));
		assertEquals(false, t0.getArcIn().contains(a0));
		assertEquals(false, pn.getArcOut().contains(a1));
		assertEquals(false, t0.getArcOut().contains(a1));
		assertEquals(false, pn.getArcIn().contains(a2));
		assertEquals(false, t1.getArcIn().contains(a2));
		assertEquals(false, pn.getArcOut().contains(a3));
		assertEquals(false, t1.getArcOut().contains(a3));
 	}
	
	@Order(5)
	@Test
	public void TestRemoveTransitionLinked() 
			throws InexistentPlaceException, 
			InexistentArcOutException, 
			InexistentArcInException, 
			InexistentTransitionException {
		
		PetriNetwork pn = new PetriNetwork();
		Transition t0 = new Transition();
		Place p0 = new Place();
		Place p1 = new Place();
		ArcIn a0 = new ArcIn(t0, p0, 0);
		ArcOut a1 = new ArcOut(p0, t0, 0);
		ArcIn a2 = new ArcIn(t0, p1, 0);
		ArcOut a3 = new ArcOut(p1, t0, 0);
		
		pn.addTransition(t0);
		pn.addPlace(p0);
		pn.addPlace(p1);
		pn.addArcIn(a0);
		pn.addArcOut(a1);
		
		//Code : RTL1
		pn.removeTransition(t0);
		assertEquals(false, pn.getTransition().contains(t0));
		assertEquals(false, pn.getArcIn().contains(a0));
		assertEquals(false, t0.getArcIn().contains(a0));
		assertEquals(false, pn.getArcOut().contains(a1));
		assertEquals(false, t0.getArcOut().contains(a1));
		
		//Code : RPL2
		pn.addTransition(t0);
		pn.addArcIn(a0);
		pn.addArcOut(a1);
		pn.addArcIn(a2);
		pn.addArcOut(a3);
		pn.removeTransition(t0);
		assertEquals(false, pn.getTransition().contains(t0));
		assertEquals(false, pn.getArcIn().contains(a0));
		assertEquals(false, p0.getArcIn().contains(a0));
		assertEquals(false, pn.getArcOut().contains(a1));
		assertEquals(false, p0.getArcOut().contains(a1));
		assertEquals(false, pn.getArcIn().contains(a2));
		assertEquals(false, p1.getArcIn().contains(a2));
		assertEquals(false, pn.getArcOut().contains(a3));
		assertEquals(false, p1.getArcOut().contains(a3));
 	}
	
}
