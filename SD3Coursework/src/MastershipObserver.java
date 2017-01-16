
public class MastershipObserver implements Observer{
	private boolean theMovement =false;
	
	private static int observerIDTracker = 0;
	
	private int observerID;
	
	private Observable movementchange;
	
	public MastershipObserver(Observable movementchange){
		this.movementchange = movementchange;
		this.observerID = ++observerIDTracker;
		System.out.println("New Observer created! " + this.observerID);
		movementchange.registerObserver(this);
	}
	public void update(boolean theMovement) {
		this.theMovement = theMovement;
		
		printTheMovement();
	}
	public void printTheMovement(){
		System.out.println("Observer " + observerID + " has detected movement from the Mastership and therefore there is a one in three chance of an enemyship being moved.");
	}
}
