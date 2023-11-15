package Tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Exception.InexistentArcInException;
import Exception.InexistentArcOutException;
import Exception.InexistentPlaceException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import NetworkClasses.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPull {
	
	@Test
	@Order(1)
	public void testpullSimple() throws InexistentPlaceException, 
	InexistentArcOutException, 
	InexistentArcInException {
		
		PetriNetwork pn0 = new PetriNetwork();
		Place p0 = new Place(5);
		Place p1 = new Place();
		Transition t0 = new Transition();
		ArcOut a0 = new ArcOut(p0, t0, 3);
		ArcIn a1 = new ArcIn(t0, p1, 3);
		ArcIn a2 = new ArcIn(t0, p0, 1);
		
		pn0.addPlace(p0);
		pn0.addPlace(p1);
		pn0.addTransition(t0);
		pn0.addArcOut(a0);
		
		//Code : RD2
		t0.pull();
		assertEquals(2, p0.getTokens());
		
		//Code : RD3
		t0.pull();
		assertEquals(2, p0.getTokens());
		
		pn0.removeArcOut(a0);		
		pn0.addArcIn(a1);
		
		//Code : RD4
		t0.pull();
		assertEquals(3, p1.getTokens());
		
		pn0.addArcOut(a0);
		p1.removeTokens(3);
		p0.addTokens(3);
		
		//Code : RD5
		t0.pull();
		assertEquals(2, p0.getTokens());
		assertEquals(3, p1.getTokens());
		
		//Code : RD6
		t0.pull();
		assertEquals(2, p0.getTokens());
		assertEquals(3, p1.getTokens());
		
		pn0.removeArcIn(a1);
		pn0.addArcIn(a2);
		p0.addTokens(2);
		
		//Code : RD7
		t0.pull();
		assertEquals(2, p0.getTokens());
		
		//Code : RD8
		t0.pull();
		assertEquals(2, p0.getTokens());
	}
	
	@Test
	@Order(2)
	public void testpullMultiple() throws InexistentArcOutException, InexistentPlaceException {
		PetriNetwork pn = new PetriNetwork();
		Place p0 = new Place(5);
		Place p1 = new Place(3);
		Place p2 = new Place();
		Place p3 = new Place();
		Transition t0 = new Transition();
		ArcOut a0 = new ArcOut(p0, t0, 2);
		ArcOut a1 = new ArcOut(p1, t0, 2);
		ArcIn a2 = new ArcIn(t0, p2, 1);
		ArcIn a3 = new ArcIn(t0, p3, 1);
		
		pn.addPlace(p0);
		pn.addPlace(p1);
		pn.addPlace(p2);
		pn.addPlace(p3);
		pn.addTransition(t0);
		pn.addArcOut(a1);
		pn.addArcOut(a0);
		
		//Code : RD9
		t0.pull();
		assertEquals(3, p0.getTokens());
		assertEquals(1, p1.getTokens());
		
		//Code : RD10
		t0.pull();
		assertEquals(3, p0.getTokens());
		assertEquals(1, p1.getTokens());
		
		p0.removeTokens(2);
		
		//Code : RD11
		t0.pull();
		assertEquals(1, p0.getTokens());
		assertEquals(1, p1.getTokens());
		
		pn.removeArcOut(a0);
		pn.removeArcOut(a1);
		pn.addArcIn(a2);
		pn.addArcIn(a3);
		
		//Code : RD12
		t0.pull();
		assertEquals(1, p2.getTokens());
		assertEquals(1, p3.getTokens());
		
		pn.addArcOut(a0);
		pn.addArcOut(a1);
		p0.addTokens(4);
		p1.addTokens(2);
		
		//Code : RD13
		t0.pull();
		assertEquals(3, p0.getTokens());
		assertEquals(1, p1.getTokens());
		assertEquals(2, p2.getTokens());
		assertEquals(2, p3.getTokens());
		
		//Code : RD14
		t0.pull();
		assertEquals(3, p0.getTokens());
		assertEquals(1, p1.getTokens());
		assertEquals(2, p2.getTokens());
		assertEquals(2, p3.getTokens());
		
		p0.removeTokens(2);
		
		//Code : RD15
		t0.pull();
		assertEquals(1, p0.getTokens());
		assertEquals(1, p1.getTokens());
		assertEquals(2, p2.getTokens());
		assertEquals(2, p3.getTokens());
	}
	
	@Test
	@Order(3)
	public void testPullZeroArc() 
			throws InexistentPlaceException {
		PetriNetwork pn = new PetriNetwork();
				
		Place p1 = new Place(1);
		Place p2 = new Place(1);
		Transition t1 = new Transition();
		ArcOut a1 = new ArcOut(p1, t1, 1);
		ZeroArc a2 = new ZeroArc(p2, t1, 0);
		
		pn.addPlace(p2);
		pn.addPlace(p1);
		pn.addTransition(t1);
		pn.addArcOut(a2);
		pn.addArcOut(a1);
		
		//Code : TZ1
		t1.pull();
		assertEquals(1, p1.getTokens());
		assertEquals(1, p2.getTokens());
		
		//Code : TZ2
		p2.removeTokens(1);
		t1.pull();
		assertEquals(0, p2.getTokens());
		assertEquals(0, p1.getTokens());
	}
	
	@Test
	@Order(4)
	public void testPullEmptyArc() 
			throws InexistentPlaceException {
		PetriNetwork pn = new PetriNetwork();
				
		Place p1 = new Place(3);
		Place p2 = new Place(5);
		Transition t1 = new Transition();
		ArcOut a1 = new ArcOut(p1, t1, 1);
		EmptyArc a2 = new EmptyArc(p2, t1, 0);
		
		pn.addPlace(p2);
		pn.addPlace(p1);
		pn.addTransition(t1);
		pn.addArcOut(a2);
		pn.addArcOut(a1);
		
		//Code : TE1
		t1.pull();
		assertEquals(2, p1.getTokens());
		assertEquals(0, p2.getTokens());
		
		//Code : TE2
		p2.addTokens(1);
		t1.pull();
		assertEquals(0, p2.getTokens());
		assertEquals(1, p1.getTokens());
		
		//Code : TE3
		t1.pull();
		assertEquals(0, p2.getTokens());
		assertEquals(1, p1.getTokens());
	}
}
