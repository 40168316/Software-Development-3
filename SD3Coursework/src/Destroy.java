// Public Interface which is implement by subclasses to allow for the different destroy types without effecting the operational mode 
public interface Destroy {
	String Destroy();
}
// Class which implements the destroy interface. This class is used if the mode is in defensive and can be destroyed if 2 enemy ships share the same tile as it
class Destroyin2 implements Destroy{
	public static int masterx;
	public static int mastery;
	public static int shooterx =-1;
	public static int shootery=-1;
	public static int starx=-1;
	public static int stary=-1;
	public static int crusierx=-1;
	public static int crusiery=-1;
	public String Destroy() {
		System.out.println("masterx " + masterx);
		System.out.println("mastery " + mastery);
		System.out.println("shooterx " + shooterx);
		System.out.println("shootery " + shootery);
		System.out.println("crusierx " + crusierx);
		System.out.println("crusiery " + crusiery);
		System.out.println("shostarxoterx " + starx);
		System.out.println("stary " + stary);
		// For loop which loops round all 16 tiles
		for (int i = 0; i < 16 ; i++)
		{
			for (int j = 0; j < 16 ; j++){
				// If two enemy ships share the same tile as the master ship then end the game!
				if (masterx == i &&  mastery == j && shooterx == i && shootery == j && starx == i && stary == j || 
						masterx == i &&  mastery == j && crusierx == i && crusiery ==j && shooterx == i && shootery == j ||
						masterx == i &&  mastery == j && crusierx == i && crusiery ==j && starx == i && stary == j){
					System.out.println("Ending game!");
					GUI.gameoverbool = true;
				}
				if (masterx == i &&  mastery == j && shooterx == i && shootery == j){
					System.out.println("Removing Battleshooter!");
					GUI.removeshooter= true;
				}
				if (masterx == i &&  mastery == j && crusierx == i && crusiery ==j){
					System.out.println("Removing Battlecruiser!");
					GUI.removecrusier = true;
				}
				if (masterx == i &&  mastery == j && starx == i && stary == j){
					System.out.println("Removing Battlestar!");
					GUI.removestar = true;
				}
			}
		}
		return "Defensive Mode!";
	}
}
//Class which implements the destroy interface. This class is used if the mode is in offensive and can be destroyed if 3 enemy ships share the same tile as it
class Destroyin3ormore implements Destroy{
	public static int masterx;
	public static int mastery;
	public static int shooterx;
	public static int shootery;
	public static int starx;
	public static int stary;
	public static int crusierx;
	public static int crusiery;
	public String Destroy() {
		// For loop which loops round all 16 tiles
		for (int i = 0; i < 16 ; i++)
		{
			for (int j = 0; j < 16 ; j++){
				// If two enemy ships share the same tile as the master ship then end the game!
				if (masterx == i &&  mastery == j && shooterx == i && shootery == j && starx == i && stary == j || 
						masterx == i &&  mastery == j && crusierx == i && crusiery ==j && shooterx == i && shootery == j ||
						masterx == i &&  mastery == j && crusierx == i && crusiery ==j && starx == i && stary == j){
					System.out.println("Ending game!");
					GUI.gameoverbool = true;
				}
				if (masterx == i &&  mastery == j && shooterx == i && shootery == j){
					System.out.println("Removing Battleshooter!");
					GUI.removeshooter= true;
				}
				if (masterx == i &&  mastery == j && crusierx == i && crusiery ==j){
					System.out.println("Removing Battlecruiser!");
					GUI.removecrusier = true;
				}
				if (masterx == i &&  mastery == j && starx == i && stary == j){
					System.out.println("Removing Battlestar!");
					GUI.removestar = true;
				}
			}
		}
		return "Offensive Mode!";
	}
}
