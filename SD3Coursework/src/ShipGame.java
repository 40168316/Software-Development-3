// Public class enemy ship game which is used to set and get the enemyship from the ship factory
public class ShipGame {
	ShipFactory theFactory;
	
	public ShipGame() {
		setTheFactory(new ShipFactory());
	}
		
	public void playGame(String type) {
		EnemyShip enemyship;
			
		enemyship = this.theFactory.createEnemyShip(type);
		enemyship.randomgenerate();
	}
	
	public void setTheFactory(ShipFactory theFactory) {
		this.theFactory = theFactory;
	}
}
