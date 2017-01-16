import java.util.ArrayList;
import java.util.Random;

//Public class for the BattleStar which implements options which is part of the command pattern. This can move the ship or undo the ships moves.
//The class also extends enemyship which is part of the factory pattern and is used to set the type of ships randomly selected with the pattern.
public class CommandBattleStar extends EnemyShip implements Options{
	// Set the variables
	public static int x = -1;
	public static int y = -1;
	private int randomtile;
	private ArrayList<Integer> movetile = new ArrayList<Integer>();
	private int num = -1;
	private int moves = 0;
	public static int loops = 0;
	// Method which moves the ship
	public void move() {
		// Arraylist which stores the possible moves to tiles the ship can make
		ArrayList<Integer> list = new ArrayList<Integer>();
		// If the ship has not move yet set its starting position
		if (loops == 0)
		{
			x = 0;
			y = 0;
			moves++;
			// Add the move into the moves list
			movetile.add(randomtile);
		}
		// Else if the ship is already on the board
		else
		{
			// Create a randomiser
			Random rand = new Random();
			list.clear();
			// Using the x and y, add the surrounding tiles to a list, so they can be randomly chosen from later in the method
			if(x == 0 && y ==0)
			{
				list.add(1);
				list.add(4);
				list.add(5);
			}
			else if(x == 1 && y ==0)
			{
				list.add(0);
				list.add(2);
				list.add(4);
				list.add(5);
				list.add(6);
			}
			else if(x == 2 && y ==0)
			{
				list.add(1);
				list.add(5);
				list.add(6);
				list.add(7);
				list.add(3);
			}
			else if(x == 3 && y ==0)
			{
				list.add(2);
				list.add(6);
				list.add(7);
			}
			else if(x == 0 && y ==1)
			{
				list.add(0);
				list.add(1);
				list.add(5);
				list.add(8);
				list.add(9);
			}
			else if(x == 1 && y ==1)
			{
				list.add(0);
				list.add(1);
				list.add(2);
				list.add(6);
				list.add(10);
				list.add(9);
				list.add(8);
				list.add(4);
			}
			else if(x == 2 && y ==1)
			{
				list.add(1);
				list.add(2);
				list.add(3);
				list.add(7);
				list.add(11);
				list.add(10);
				list.add(9);
				list.add(5);
			}
			else if(x == 3 && y ==1)
			{
				list.add(2);
				list.add(3);
				list.add(6);
				list.add(10);
				list.add(11);
			}
			else if(x == 0 && y ==2)
			{
				list.add(4);
				list.add(5);
				list.add(9);
				list.add(12);
				list.add(13);
			}
			else if(x == 1 && y ==2)
			{
				list.add(4);
				list.add(5);
				list.add(6);
				list.add(10);
				list.add(14);
				list.add(13);
				list.add(12);
				list.add(8);
			}
			else if(x == 2 && y ==2)
			{
				list.add(5);
				list.add(6);
				list.add(7);
				list.add(11);
				list.add(15);
				list.add(14);
				list.add(13);
				list.add(9);
			}
			else if(x == 3 && y ==2)
			{
				list.add(6);
				list.add(7);
				list.add(10);
				list.add(14);
				list.add(15);
			}
			else if(x == 0 && y ==3)
			{
				list.add(8);
				list.add(9);
				list.add(13);
			}
			else if(x == 1 && y ==3)
			{
				list.add(8);
				list.add(9);
				list.add(10);
				list.add(12);
				list.add(14);
			}
			else if(x == 2 && y ==3)
			{
				list.add(9);
				list.add(10);
				list.add(11);
				list.add(13);
				list.add(15);
			}
			else if(x == 3 && y ==3)
			{
				list.add(10);
				list.add(11);
				list.add(14);
			}
			// Create another randomiser to select the tile the ship will move too
			randomtile = rand.nextInt(list.size());
			randomtile =list.get(randomtile);
			// Add that to the moves list
			movetile.add(randomtile);
			moves++;
			// Identify the tile randomly selected and set x and y accordingly
			if (randomtile == 0){
				x = 0;
				y = 0;
			}
			if (randomtile == 1){
				x = 1;
				y = 0;
			}
			if (randomtile == 2){
				x = 2;
				y = 0;
			}
			if (randomtile == 3){
				x = 3;
				y = 0;
			}
			if (randomtile == 4){
				x = 0;
				y = 1;
			}
			if (randomtile == 5){
				x = 1;
				y = 1;
			}
			if (randomtile == 6){
				x = 2;
				y = 1;
			}
			if (randomtile == 7){
				x = 3;
				y = 1;
			}
			if (randomtile == 8){
				x = 0;
				y = 2;
			}
			if (randomtile == 9){
				x = 1;
				y = 2;
			}
			if (randomtile == 10){
				x = 2;
				y = 2;
			}
			if (randomtile == 11){
				x = 3;
				y = 2;
			}
			if (randomtile == 12){
				x = 0;
				y = 3;
			}
			if (randomtile == 13){
				x = 1;
				y = 3;
			}
			if (randomtile == 14){
				x = 2;
				y = 3;
			}
			if (randomtile == 15){
				x = 3;
				y = 3;
			}
			// As the move is generated, add a thread, to give the realistic idea of the computer making a simulation
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Once the move has been complete, update the GUI with the new positions
		System.out.println("BattleStar move successful - " + x + " " + y);
		GUI.starshipposx = x;
		GUI.starshipposy = y;
		GUI.movesstar = moves;
		loops++;
	}

	// Method which allows for the ship to return to the previous tile
	public void previousmove() {
		// Num-- is a varibable which goes back one space in the movetile array list, where all the tiles are stored
		num--;
		randomtile = movetile.get(movetile.size()+num);
		// Identify the tile and set x and y accordingly
		if (randomtile == 0){
			x = 0;
			y = 0;
		}
		if (randomtile == 1){
			x = 1;
			y = 0;
		}
		if (randomtile == 2){
			x = 2;
			y = 0;
		}
		if (randomtile == 3){
			x = 3;
			y = 0;
		}
		if (randomtile == 4){
			x = 0;
			y = 1;
		}
		if (randomtile == 5){
			x = 1;
			y = 1;
		}
		if (randomtile == 6){
			x = 2;
			y = 1;
		}
		if (randomtile == 7){
			x = 3;
			y = 1;
		}
		if (randomtile == 8){
			x = 0;
			y = 2;
		}
		if (randomtile == 9){
			x = 1;
			y = 2;
		}
		if (randomtile == 10){
			x = 2;
			y = 2;
		}
		if (randomtile == 11){
			x = 3;
			y = 2;
		}
		if (randomtile == 12){
			x = 0;
			y = 3;
		}
		if (randomtile == 13){
			x = 1;
			y = 3;
		}
		if (randomtile == 14){
			x = 2;
			y = 3;
		}
		if (randomtile == 15){
			x = 3;
			y = 3;
		}
		// Update the GUI
		GUI.starshipposx = x;
		GUI.starshipposy = y;
		System.out.println("BattleStar - Undo Move " + x +" " + y);
	}
	
	// Method which allows for the factory pattern to set the type of ship
	public CommandBattleStar(){
		setType( "BattleStar.");
	}
}
