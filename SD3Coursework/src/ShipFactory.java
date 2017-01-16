// Public class ship factory which creates the ship chosen from the random enemy ship gen class
public class ShipFactory {
	public EnemyShip createEnemyShip(String type) {
		EnemyShip enemyship = null;
		
		if(type.equalsIgnoreCase("battlecrusier")) {
			enemyship = new CommandBattleCrusier();
		}
		if(type.equalsIgnoreCase("battlestar")) {
			enemyship = new CommandBattleStar();
		}
		if(type.equalsIgnoreCase("battleShooter")) {
			enemyship = new CommandBattleShooter();
		}
		
		return enemyship;
	}
}
