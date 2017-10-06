package csdOne;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestDamageHandler {

	DamageHandler dh;
	Ship ship;
	
	@Before
	public void initialize()
	{
		dh = new DamageHandler();
		
		FakeRandom random = new FakeRandom();
		ship = new Ship(random);
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
	
	@SuppressWarnings("serial")
	private class FakeRandom extends Random
	{
		@Override
		public int nextInt(int bounds)
		{
			return 0;
		}
	}
	
	

}
