import java.util.List;
// Class which moves all the ships one either forward or undo
public class MoveAll implements Command{
	List<Options> theOptions;
	
	// Get the options
	public MoveAll(List<Options> newOptions){
		theOptions = newOptions;
	}
	
	// Make a move
	public void execute() {
		for(Options option: theOptions){
			option.move();
		}
	}
	// Undo a move
	public void undo() {
		for(Options option: theOptions){
			option.previousmove();
		}
		
	}
}
