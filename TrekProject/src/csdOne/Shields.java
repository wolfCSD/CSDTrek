package csdOne;

public class Shields extends Subsystem 
{
	
	public int shieldLevel;
	public boolean isShieldUp;
	public int shieldEnergyLevel;
	public int shipEnergyLevel;
	
	
	public Shields()
	{
		shieldLevel = 10000;
	    isShieldUp = false;
	    shipEnergyLevel = 59999;
	}
	
	public int getShieldLevel()
	{
		if ( shieldLevel < 0 )
			return 0;
		
		return shieldLevel;
	}
	
	public void setShieldLevel(int sLevel)
	{
		shieldLevel = sLevel;
	}
	
	public void setShieldUp()
	{
		isShieldUp = true;
	}
	
	public void setShieldDown()
	{
		isShieldUp = false;
	}
	
	public boolean isShieldUp()
	{
		return isShieldUp;
	}
	

	public int getShipEnergyLevel()
	{		
		return shipEnergyLevel;
	}
	
	public void setShipEnergyLevel(int sLevel)
	{
		shipEnergyLevel = sLevel;
	}
	
	public void reduceShields(int damage)
	{
		if(shieldEnergyLevel < damage )
		{
			shieldEnergyLevel = 0;
		}
		else
		{
			shieldEnergyLevel -= damage;
		}
	}
	
	
	public int getShieldEnergyLevel()
	{		
		return shieldEnergyLevel;
	}
	
	public void setShieldEnergyLevel(int sLevel)
	{
		shieldEnergyLevel = sLevel;
	}
	
    // If ship energy level goes to 0, then game over as per Product Owner. Hence the first check
	public void shipToShieldTransfer(int amount) throws Exception
	{
		if ( shipEnergyLevel < 0 )
			throw new Exception();
		
		shipEnergyLevel -= amount;
		shieldEnergyLevel += amount;
	}
	
	
	public void shieldToShipTransfer(int amount)
	{
		shipEnergyLevel += amount;
		shieldEnergyLevel -= amount;
	}
	
	@Override
	public String toString()
	{
		return "Shields";
	}
}
