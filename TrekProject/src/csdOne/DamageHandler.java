package csdOne;

public class DamageHandler {

	public void takeHit(Ship ship, int damage) {
		Shields shield = ship.getShields();
		
		int remainingDamage = damage;
		
		if(shield.isShieldUp())
		{
			int curShield = shield.getShieldEnergyLevel();
			remainingDamage -= curShield;
			
			shield.reduceShields(damage);
			
		}
		
		if(remainingDamage > 0)
		{
			ship.damageRandomSubsystem();
		}
	
	}

}
