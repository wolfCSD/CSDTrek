package csdOne;

public class Shields extends Subsystem 
{
	public boolean isShieldUp;
	public int shieldEnergyLevel;	
	
	public Shields()
	{
		shieldEnergyLevel = 10000;
	    isShieldUp = false;
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
	
	@Override
	public String toString()
	{
		return "Shields";
	}
	
	public int takeHitAndReturnRemainingDamage(int damage) 
	{
		int remainingDamage = damage;
		if(isShieldUp())
		{
			int curShield = getShieldEnergyLevel();
			remainingDamage -= curShield;
			
			reduceShields(damage);
			
		}
		return remainingDamage;
	}


	public void addShields(int addShieldAmount) {
		
		if(shieldEnergyLevel + addShieldAmount < MAX_ENERGY_LEVEL)
		{
			shieldEnergyLevel += addShieldAmount;
		}
		else
		{
			shieldEnergyLevel = MAX_ENERGY_LEVEL;
		}
		
	}
	protected static final int MAX_ENERGY_LEVEL = 10000;
}

