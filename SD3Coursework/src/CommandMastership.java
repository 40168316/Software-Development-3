import java.util.ArrayList;
import java.util.Random;

//Public class for the Mastership which implements options which is part of the command pattern. This can move the ship or undo the ships moves.
//The class also extends enemyship which is part of the factory pattern and is used to set the type of ships randomly selected with the pattern.
public class CommandMastership implements Options, Observable {
	// Set the variables
	public static int x = -1;
	public static int y = -1;
	private int randomtile;
	private ArrayList<Integer> movetile = new ArrayList<Integer>();
	private int num = -1;
	private int moves = 0;
	private int loops = 0;
	// Method which moves the ship
	public void move() {
		// Arraylist which stores the possible moves to tiles the ship can make
		ArrayList<Integer> list = new ArrayList<Integer>();
		// Arraylist which stores the possible starting moves the ship can make (ie not 0,0)
		ArrayList<Integer> startlist = new ArrayList<Integer>();
		startlist.add(1);
		startlist.add(2);
		startlist.add(3);
		startlist.add(4);
		startlist.add(5);
		startlist.add(6);
		startlist.add(7);
		startlist.add(8);
		startlist.add(9);
		startlist.add(10);
		startlist.add(11);
		startlist.add(12);
		startlist.add(13);
		startlist.add(14);
		startlist.add(15);
		Random rand = new Random();			
		list.clear();
		try {
			// If the masterships is already on the board, use the x and y, add the surrounding tiles to a list, so they can be randomly chosen from later in the method
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
			// If the ship is not on the board then randomly choose a number from the start list
			if(loops == 0)
			{
				randomtile = rand.nextInt(startlist.size());
				randomtile =startlist.get(randomtile);
			}
			// If the ship is on the board then randomly choose a number from the full list
			else
			{
				randomtile = rand.nextInt(list.size());
				randomtile =list.get(randomtile);
			}	
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
			
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		// Once the move has been complete, update the GUI with the new positions
		System.out.println("Mastership move successful - " + x + " " + y);
		GUI.mastershipposx = x;
		GUI.mastershipposy = y;
		GUI.movesmaster = moves;
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
		GUI.mastershipposx = x;
		GUI.mastershipposy = y;
		System.out.println("MasterShip - Undo Move " + x +" " + y);
	}
	private ArrayList <Observer> observers;
	private boolean theMovement;
	
	public CommandMastership(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer newObserver) {
		observers.add(newObserver);
		
	}
	public void removeObserver(Observer deleteObserver) {
		int observerIndex = observers.indexOf(deleteObserver);
		// Print out message (Have to increment index to match)
		System.out.println("Observer " + (observerIndex+1) + " deleted");
		// Removes observer from the ArrayList
		observers.remove(observerIndex);
	}
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.update(theMovement);          
		}
	}	
	public void settheMovement(boolean theMovement){
		this.theMovement = theMovement;
		notifyObservers();
	}
}
