package csdOne;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestShip {

	Ship ship;
	
	@Before
	public void initialze()
	{
		ship = new Ship();
	}
	
	@Test
	public void testShipToShieldTransferDecreasesShipEnergyAndIncreaseShieldEnergy() {
		//Given
		ship.setShipEnergyForTest(100);
		ship.getShields().setShieldEnergyLevel(50);
		
		//When
		ship.transferEnergyToShield(20);
		
		//Then
		assertEquals(80, ship.getShipEnergy());
		assertEquals(70, ship.getShields().getShieldEnergyLevel());
	}
	
	@Test
	public void testShieldToShipTransferIncreasesShipEnergyAndDecreasesShieldEnergy() {
		//Given
		ship.setShipEnergyForTest(100);
		ship.getShields().setShieldEnergyLevel(50);
		
		//When
		ship.transferEnergyFromShieldToShip(20);
		
		//Then
		assertEquals(120, ship.getShipEnergy());
		assertEquals(30, ship.getShields().getShieldEnergyLevel());
		
	}
	
	
//	@Test
//	public void testShipToShield() 
//	{
//		
//		//Given
//		s1.setShieldEnergyLevel(200);
//		s1.setShipEnergyLevel(50);
//		
//		//When
//		s1.shipToShieldTransfer(10);
//		
//		//then
//		assertEquals(210, s1.getShieldEnergyLevel());
//		assertEquals(40, s1.getShipEnergyLevel());
//	}
//	
//	
//	@Test
//	public void testShieldToShip() 
//	{
//		//Given
//		s1.setShipEnergyLevel(100);
//		s1.setShieldEnergyLevel(50);
//		//When
//		s1.shieldToShipTransfer(40);
//		//Then
//		assertEquals(140, s1.getShipEnergyLevel());
//		assertEquals(10, s1.getShieldEnergyLevel());
//	}

}
