package csdOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
	
	private Shields shields;
	private int shipEnergyLevel;
	
	public Ship(Random generator)
	{
		randomGenerator = generator;
		
		shipEnergyLevel = 80000;
		subsystems = new ArrayList<Subsystem>();
		shields = new Shields();
		subsystems.add(shields);
	}
	
	public Ship()
	{
		this(new Random());
	}
	
	public void shipToShieldTransfer(int amount)
	{		
		shipEnergyLevel -= amount;
		shields.addShields(amount);
	}
	
	
	public void shieldToShipTransfer(int amount)
	{
		shipEnergyLevel += amount;
		shields.reduceShields(amount);
	}
	
	public Shields getShields()
	{
		return shields;
	}

	public int getNumDamagedSystems() 
	{
		int numDamaged = 0;
		
		for(Subsystem system : subsystems)
		{
			if(system.isDamaged())
			{
				numDamaged ++;
			}
		}
		return numDamaged;
	}

	public void damageRandomSubsystem() {
		int systemToDamage;
		
		int numberOfSubsystems = subsystems.size();
		systemToDamage = chooseSubsystemIndex(numberOfSubsystems);
				
		Subsystem system = subsystems.get(systemToDamage);
		system.setDamaged(true);
	}

	private int chooseSubsystemIndex(int numberOfSubsystems) {
		return randomGenerator.nextInt(numberOfSubsystems);
	}
	
	private List<Subsystem> subsystems;
	private Random randomGenerator;

	public void setShipEnergyForTest(int newEnergy) {
		
		this.shipEnergyLevel = newEnergy;
	}

	public int getShipEnergy() {
		return this.shipEnergyLevel;
	}

	public void transferEnergyToShield(int transferToShieldAmount) {
		shipEnergyLevel -= transferToShieldAmount;
		shields.addShields(transferToShieldAmount);
	}

	public void transferEnergyFromShieldToShip(int transferShieldToShipAmount) {
		shipEnergyLevel += transferShieldToShipAmount;
		shields.reduceShields(transferShieldToShipAmount);
		
	}
	
	

}
