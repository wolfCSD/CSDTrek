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
	public void testShieldEnergyNotNegative() 
	{
		//Given
		s1.setShieldUp();
		s1.setShieldEnergyLevel(20);
		//When
	    s1.reduceShields(30);
	    //Then
	    assertEquals(0, s1.getShieldEnergyLevel());
	}
	
	
	@Test
	public void testShieldEnergyIncrementsfromZeroNotNegative() 
	{
		//Given
		s1.setShieldUp();
		s1.setShieldEnergyLevel(20);
		//When
	    s1.reduceShields(30);
	    s1.addShields(15);
	    //Then
	    assertEquals(15, s1.getShieldEnergyLevel());
	}
	
	@Test
	public void testShieldIsDownByDefault() 
	{
		//Given
		
		//When
	    
	    //Then
	    assertFalse(s1.isShieldUp());
	}
	
	@Test
	public void testShieldUp() 
	{
		//Given
		s1.setShieldDown();
		//When
	    s1.setShieldUp();
	    //Then
	    assertTrue(s1.isShieldUp());
	}
	
	@Test
	public void testShieldDown() 
	{
		//Given
	    s1.setShieldUp();
	    //When
		s1.setShieldDown();
		//Then
	    assertFalse(s1.isShieldUp());
	}
	
	@Test
	public void testMinShieldEnergy() 
	{
//Given
		s1.setShieldEnergyLevel(20);
//When	    
		s1.reduceShields(30);
//Then	   
	    assertEquals(0, s1.getShieldEnergyLevel());
	}
	
	@Test
	public void testMaxShieldEnergy() 
	{
		//Given
		
		s1.setShieldEnergyLevel(9000);
		
		//When
		s1.addShields(1500);
		
		//Then
	    assertEquals(10000, s1.getShieldEnergyLevel());	
	}

	
	
}
