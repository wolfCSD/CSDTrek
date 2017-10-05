package csdOne;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDamageHandler {

	DamageHandler dh;
	Ship ship;
	
	@Before
	public void initialize()
	{
		dh = new DamageHandler();
		ship = new Ship();
	}
	
	@Test
	public void testDamageShieldIfRaisedAndSufficient() {
		ship.getShields().setShieldUp();
		ship.getShields().setShieldEnergyLevel(25);
		
		dh.takeHit(ship, 10);
		
		assertEquals(15, ship.getShields().getShieldEnergyLevel());
		
	}
	
	@Test
	public void testComponentNotDamagedIfShieldSufficient()
	{
		ship.getShields().setShieldUp();
		ship.getShields().setShieldEnergyLevel(25);
		int curDamaged = ship.getNumDamagedSystems();
		
		dh.takeHit(ship, 10);
		
		assertEquals(curDamaged, ship.getNumDamagedSystems());
	}
	
	@Test
	public void testShieldNotDamagedIfNotRaised() {
		
		ship.getShields().setShieldDown();
		ship.getShields().setShieldEnergyLevel(100);
		
		dh.takeHit(ship, 20);
		
		assertEquals(100, ship.getShields().getShieldEnergyLevel());
	}
	
	@Test
	public void testShieldDepeletedIfRaisedAndInsufficient()
	{
		ship.getShields().setShieldUp();
		ship.getShields().setShieldEnergyLevel(20);
		
		dh.takeHit(ship, 30);
		
		assertEquals(0, ship.getShields().getShieldEnergyLevel());
	}
	
	@Test
	public void testComponentDamageIfShieldNotRaised()
	{
		ship.getShields().setShieldDown();
		int numCurrentDamaged = ship.getNumDamagedSystems();
		
		dh.takeHit(ship, 10);
		
		assertEquals(numCurrentDamaged + 1, ship.getNumDamagedSystems());
	}
	
	@Test
	public void testComponentDamagedIfShieldDepeleted()
	{
		ship.getShields().setShieldUp();
		ship.getShields().setShieldEnergyLevel(10);
		int numCurrentDamaged = ship.getNumDamagedSystems();
		
		dh.takeHit(ship, 20);
		
		assertEquals(numCurrentDamaged + 1, ship.getNumDamagedSystems());
	}
	
	

}
