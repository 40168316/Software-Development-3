// This interface is used in the Command pattern. These commands can be issued to the different ships.
public interface Command {
	public void execute();
	public void undo();
}
