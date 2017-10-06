package csdOne;

public class DamageHandler {

	public void takeHit(Ship ship, int damage) {
		Shields shield = ship.getShields();
		
		int remainingDamage = shield.takeHitAndReturnRemainingDamage(damage);
		
		if(remainingDamage > 0)
		{
			ship.damageRandomSubsystem();
		}
	
	}



}
