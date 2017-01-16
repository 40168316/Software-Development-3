// Public class enemyship which returns and gets the sets the enemy ship from the ship game which comes from the ship factory.
public abstract class EnemyShip {
	protected String type;
	
	public void randomgenerate() {
		System.out.println("The ship randomly entering is " +getType());
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
