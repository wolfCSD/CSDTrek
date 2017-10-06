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

}
