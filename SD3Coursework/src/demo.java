import java.awt.EventQueue;

// This class is where the program is run from. This class creates and runs the GUI.
public class demo {
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				GUI frame = new GUI();
				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
