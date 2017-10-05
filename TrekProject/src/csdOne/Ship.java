package csdOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
	
	private Shields shields;
	
	public Ship()
	{
		subsystems = new ArrayList<Subsystem>();
		
		shields = new Shields();
		subsystems.add(shields);
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
		
		if(subsystems.size() == 1 )
		{
			systemToDamage = 0;
		}
		else
		{
			systemToDamage = new Random().nextInt(subsystems.size());
		}
		
		Subsystem system = subsystems.get(systemToDamage);
		system.setDamaged(true);
		
	}
	
	private List<Subsystem> subsystems;

}
