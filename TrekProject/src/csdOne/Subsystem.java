package csdOne;

public abstract class Subsystem {
	private boolean damaged = false;

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}
	

}
