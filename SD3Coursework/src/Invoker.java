// Public class the Invoker which invokes the execute or undo
// The execute method for the Command interface calls the method assigned to it in the class that implements it
public class Invoker {
	Command theCommand;
	
	public Invoker(Command newCommand)
	{
		theCommand = newCommand;
	}
	
	// Make the move
	public void active(){
		theCommand.execute();
	}
	// Undo the move
	public void activeundo(){
		theCommand.undo();
	}
}
