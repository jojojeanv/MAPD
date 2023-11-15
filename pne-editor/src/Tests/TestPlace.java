package Tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import NetworkClasses.Place;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPlace {
	
	@Test
	@Order(1)
	public void testPlace() {
		
		Place p0 = new Place();
		assertEquals(0, p0.getTokens());
		
		Place p1 = new Place(1);
		assertEquals(1, p1.getTokens());

		Place p2 = new Place(-1);
		assertEquals(1, p2.getTokens());
	}

	@Test
	@Order(2)
	public void testGetToken() {
		
		Place p0 = new Place();
		assertEquals(0, p0.getTokens());
		
		Place p1 = new Place(2);
		assertEquals(2, p1.getTokens());
		
		Place p2 = new Place(-3);
		assertEquals(3, p2.getTokens());
	}
	
	@Test
	@Order(3)
	public void testRemoveTokens() {
		
		//Code : EJ1
		Place p0 = new Place(5);
		p0.removeTokens(1);
		assertEquals(4, p0.getTokens());
		
		//Code : EJ0
		Place p1 = new Place(5);
		p1.removeTokens(-3);	
		assertEquals(8, p1.getTokens());
		
		//Code : EJ2
		Place p2 = new Place(5);
		p2.removeTokens(10);
		assertEquals(0, p2.getTokens());
	}
	
	@Test
	@Order(4)
	public void testAddTokens() {
		
		//Code : AJ1 
		Place p0 = new Place(5);
		p0.addTokens(1);
		assertEquals(6, p0.getTokens());
		
		//Code : AJ0
		Place p1 = new Place(5);
		p1.addTokens(-3);	
		assertEquals(2, p1.getTokens());
		
		//Code : AJ0
		Place p2 = new Place(5);
		p2.addTokens(-10);
		assertEquals(0, p2.getTokens());
	}

}
