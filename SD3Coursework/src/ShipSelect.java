// This class returns the new type of ship selected with the Command pattern
public class ShipSelect {
	public static Options getOptions(){
		return new CommandMastership();
	}
}
