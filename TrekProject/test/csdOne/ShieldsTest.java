package csdOne;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShieldsTest 
{
	Shields s1;

	@Before
	public void ShieldsTest()
	{
	     s1 = new Shields();
	}
	
	@Test
	public void testUpDown() 
	{
		if ( s1.isShieldUp() && !s1.isShieldUp() )
			System.out.println("Developer error in setting shield Up or Down");
		else
			System.out.println("Proper values were set for shield Level Up or Down");	
	}

	@Test
	public void testShieldLevel() 
	{
//		assertBetween(s1.getShieldEnergyLevel(), 0, 10000);
		
		if ( s1.getShieldLevel() < 0 || s1.getShieldLevel() >10000 )
			System.out.println("Developer error in setting shield Level");
		else
			System.out.println("shield Level was set properly");
	}
	
	
	
	@Test
	public void testShipToShield() 
	{
		int iBefore = s1.getShipEnergyLevel();
		int iTransferAmount = 500;
		
		try
		{
		    s1.shipToShieldTransfer(iTransferAmount);
		}
		catch(Exception e)
		{
		    System.out.println(e.toString());
		}
		
		int iAfter = s1.getShipEnergyLevel();
		
		assertEquals(iBefore-iTransferAmount, iAfter);
	}
	
	
	@Test
	public void testShieldToShip() 
	{
		int iBefore = s1.getShieldEnergyLevel();
		int iTransferAmount = 999;
		
		try
		{
		    s1.shieldToShipTransfer(iTransferAmount);
		}
		catch(Exception e)
		{
		    System.out.println(e.toString());
		}
		
		int iAfter = s1.getShieldEnergyLevel();
		
		assertEquals(iBefore-iTransferAmount, iAfter);
	}
	
	
}
