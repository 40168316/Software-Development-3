import java.util.ArrayList;
import java.util.Random;

// Public class which randomly chooses a ship to be created
public class randomenemyshipgen {
	// Set variables
	static ArrayList<Integer> list = new ArrayList<Integer>(3);
	static int loops = 0;
	static int index = 0;
	static int[] choice;
	static boolean star = false;
	static boolean shooter = false;
	static boolean crusier = false;
	public static int randomship(){
		// Initial Setup
		if (loops == 0)
		{
			choice = new int[3];
			choice[0] = 0;
			choice[1] = 1;
			choice[2] = 2;
		}
		// Create shipgame for the factory pattern
		ShipGame shipGame = new ShipGame();
		// Set the variable randomchosenship, whcih will store the outcome of the randomly generated ship from the factory pattern to null
		String randomchosenship = null;
		// Create a new random generator
		Random rand = new Random();
		// Get a random number from the choice list
	    index = rand.nextInt(choice.length);
	    // As the choice list can vary in length, the index, found above randomly is then used to get the random choice 
	    index = choice[index];
	    // If index equals zero
		if (index == 0)
		{
			// Make randomchosen ship battlecruiser
			randomchosenship = "battlecrusier";
			crusier = true;
			// Altering the choice list as a battlecrusier is now in play
			if (shooter == true && star == false)
			{
				choice = new int[1];
				choice[0] = 1;
			}
			else if (shooter == false && star == true)
			{
				choice = new int[1];
				choice[0] = 2;
			}
			else
			{
				choice = new int[2];
				choice[0] = 1;
				choice[1] = 2;
			}	
		}
		else if (index == 1)
		{
			// Make randomchosen ship battlestar
			randomchosenship = "battlestar";
			star = true;
			// Altering the choice list as a battlestar is now in play
			if (shooter == true && crusier == false)
			{
				choice = new int[1];
				choice[0] = 0;
			}
			else if (shooter == false && crusier == true)
			{
				choice = new int[1];
				choice[0] = 2;
			}
			else
			{
				choice = new int[2];
				choice[0] = 0;
				choice[1] = 2;
			}
		}
		else if (index == 2)
		{
			// Make randomchosen ship battleshooter
			randomchosenship = "battleShooter";	
			shooter = true;
			// Altering the choice list as a battleshooter is now in play
			if (star == true && crusier == false)
			{
				choice = new int[1];
				choice[0] = 0;
			}
			else if (star == false && crusier == true)
			{
				choice = new int[1];
				choice[0] = 1;
			}
			else
			{
				choice = new int[2];
				choice[0] = 0;
				choice[1] = 1;
			}
		}
		// Pass the randomly chosen ship to the ship game so it can actually create the ship
		shipGame.playGame(randomchosenship);
		loops++;
		return index;
	}
}

