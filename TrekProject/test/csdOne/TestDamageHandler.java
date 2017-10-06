package csdOne;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestDamageHandler {

	DamageHandler dh;
	Ship ship;
	Random random;
	
	@Before
	public void initialize()
	{
		dh = new DamageHandler();
		
		random = mock(Random.class);
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
	public void testFirstSubsystemGetsHit()
	{
		when(random.nextInt(anyInt())).thenReturn(0);
		dh.takeHit(ship, 5);
		
		assertSame(ship.getShields(), ship.damageReport()[0]);
	}
	
	@Test
	public void testLastSubsystemGetsHit()
	{
		when(random.nextInt(anyInt())).thenReturn(1);
		
		dh.takeHit(ship, 5);
		
		assertSame(ship.getWarpEngines(), ship.damageReport()[0]);
	}
	
	@Test
	public void testDamageReport()
	{
		ship.getWarpEngines().setDamaged(true);
		ship.getShields().setDamaged(true);
		
		Subsystem[] damagedSystems = ship.damageReport();
		
		assertEquals(2, damagedSystems.length);
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
