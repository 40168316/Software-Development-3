// Import libaries
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// This is GUI class where the user interface is created and updated
public class GUI extends JFrame {
	// Creation and initialisation of variables
	private JPanel contentPane;
	private JLabel lbl1p1, lbl1p2, lbl1p3, lbl1p4, lbl2p1, lbl2p2, lbl2p3, lbl2p4, lbl3p1, lbl3p2, lbl3p3, lbl3p4 ,lbl4p1, lbl4p2, lbl4p3, lbl4p4;
	private JLabel lbl5p1, lbl5p2, lbl5p3, lbl5p4, lbl6p1, lbl6p2, lbl6p3, lbl6p4, lbl7p1, lbl7p2, lbl7p3, lbl7p4, lbl8p1, lbl8p2, lbl8p3, lbl8p4;
	private JLabel lbl9p1, lbl9p2, lbl9p3, lbl9p4, lbl10p1, lbl10p2, lbl10p3, lbl10p4, lbl11p1, lbl11p2, lbl11p3, lbl11p4, lbl12p1, lbl12p2, lbl12p3, lbl12p4;
	private JLabel lbl13p1, lbl13p2, lbl13p3, lbl13p4, lbl14p1, lbl14p2, lbl14p3, lbl14p4, lbl15p1, lbl15p2, lbl15p3, lbl15p4, lbl16p1, lbl16p2, lbl16p3, lbl16p4;
	CommandBattleStar theBattleStar = new CommandBattleStar();
	CommandBattleShooter theBattleShooter = new CommandBattleShooter();
	CommandBattleCrusier theBattleCrusier = new CommandBattleCrusier();
	private JButton btnExit, btnStart, btnMove, btnUndo;
	private JRadioButton offensivebutton = getoffensivemode();
	private JRadioButton defensivebutton = getdefensivemode();
	public static String image = "photo.png";
	public Image backgroundImage = Toolkit.getDefaultToolkit().getImage("backgr1.jpg");
	public static int mastershipposx,  mastershipposy, crusiershipposx, crusiershipposy, starshipposy, starshipposx, shootershipposx, shootershipposy;
	public static int movesmaster, movesstar, movesshooter, movescrusier;
	public static int chosenship;
	public static int startsize, endsize;
	private int undoclicks, undoclicksstar, undoclicksshooter, undoclickscrusier;
	public static boolean gameoverbool = false, removestar = false, removecrusier = false, removeshooter = false;
	// Creation of lists and array lists to store movements of ships
	ArrayList<Integer> possible = new ArrayList<>();
	CommandMastership theMasterShip = new CommandMastership();
	// Lists and arraylists used in the command pattern to move ships around the board
	List<Options> allships = new ArrayList<Options>();
	MoveAll moveallships = new MoveAll(allships);
	Invoker moveships = new Invoker(moveallships);
	// The mastershipobserver observing the mastership
	MastershipObserver mso = new MastershipObserver(theMasterShip);
	// The building of the GUI with all the items, labels and buttons being added
	public GUI() {
		possible.add(0);
		possible.add(1);
		possible.add(2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the size of the frame and make sure it cannot be resized
		setBounds(0, 0, 790, 790);
		setResizable(false);
		// Add in the background
		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(backgroundImage, 0, 0, this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Adding all the buttons and labels
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlbl1p1());
		contentPane.add(getlbl1p2());
		contentPane.add(getlbl1p3());
		contentPane.add(getlbl1p4());
		contentPane.add(getlbl2p1());
		contentPane.add(getlbl2p2());
		contentPane.add(getlbl2p3());
		contentPane.add(getlbl2p4());
		contentPane.add(getlbl3p1());
		contentPane.add(getlbl3p2());
		contentPane.add(getlbl3p3());
		contentPane.add(getlbl3p4());
		contentPane.add(getlbl4p1());
		contentPane.add(getlbl4p2());
		contentPane.add(getlbl4p3());
		contentPane.add(getlbl4p4());
		contentPane.add(getlbl5p1());
		contentPane.add(getlbl5p2());
		contentPane.add(getlbl5p3());
		contentPane.add(getlbl5p4());
		contentPane.add(getlbl6p1());
		contentPane.add(getlbl6p2());
		contentPane.add(getlbl6p3());
		contentPane.add(getlbl6p4());
		contentPane.add(getlbl7p1());
		contentPane.add(getlbl7p2());
		contentPane.add(getlbl7p3());
		contentPane.add(getlbl7p4());
		contentPane.add(getlbl8p1());
		contentPane.add(getlbl8p2());
		contentPane.add(getlbl8p3());
		contentPane.add(getlbl8p4());
		contentPane.add(getlbl9p1());
		contentPane.add(getlbl9p2());
		contentPane.add(getlbl9p3());
		contentPane.add(getlbl9p4());
		contentPane.add(getlbl10p1());
		contentPane.add(getlbl10p2());
		contentPane.add(getlbl10p3());
		contentPane.add(getlbl10p4());
		contentPane.add(getlbl11p1());
		contentPane.add(getlbl11p2());
		contentPane.add(getlbl11p3());
		contentPane.add(getlbl11p4());
		contentPane.add(getlbl12p1());
		contentPane.add(getlbl12p2());
		contentPane.add(getlbl12p3());
		contentPane.add(getlbl12p4());
		contentPane.add(getlbl13p1());
		contentPane.add(getlbl13p2());
		contentPane.add(getlbl13p3());
		contentPane.add(getlbl13p4());
		contentPane.add(getlbl14p1());
		contentPane.add(getlbl14p2());
		contentPane.add(getlbl14p3());
		contentPane.add(getlbl14p4());
		contentPane.add(getlbl15p1());
		contentPane.add(getlbl15p2());
		contentPane.add(getlbl15p3());
		contentPane.add(getlbl15p4());
		contentPane.add(getlbl16p1());
		contentPane.add(getlbl16p2());
		contentPane.add(getlbl16p3());
		contentPane.add(getlbl16p4());
		contentPane.add(getBtnExit());
		contentPane.add(getBtnStart());
		contentPane.add(getBtnMove());
		contentPane.add(getBtnUndo());
		contentPane.add((offensivebutton));
		contentPane.add((defensivebutton));
		ButtonGroup group = new ButtonGroup();
		group.add(offensivebutton);
		group.add(defensivebutton);
	}
	// Method for the offensive radio button
	private JRadioButton getoffensivemode(){
		JRadioButton offensivemode = new JRadioButton("Offensive");
		offensivemode.setMnemonic(KeyEvent.VK_B);
		offensivemode.setActionCommand("Offensive");
		offensivemode.setToolTipText("Seclect an operational mode!");
		offensivemode.setSelected(false);
		offensivemode.setBounds(600, 45, 100, 20);
		offensivemode.setFont(new Font("Arial", Font.BOLD, 15));
		offensivemode.setOpaque(false);
		offensivemode.setContentAreaFilled(false);
		offensivemode.setBorderPainted(false);
		return offensivemode;
	}
	// Method for the defensive radio button
	private JRadioButton getdefensivemode(){
		JRadioButton defensivemode = new JRadioButton("Defensive");
		defensivemode.setMnemonic(KeyEvent.VK_B);
		defensivemode.setActionCommand("Defensive");
		defensivemode.setToolTipText("Seclect an operational mode!");
		defensivemode.setSelected(true);
		defensivemode.setBounds(600, 65, 100, 20);
		defensivemode.setFont(new Font("Arial", Font.BOLD, 15));
		defensivemode.setOpaque(false);
		defensivemode.setContentAreaFilled(false);
		defensivemode.setBorderPainted(false);
		return defensivemode;
	}
	// Method for the move button
	private JButton getBtnMove(){
		// Set button properties
		if (btnMove == null) {
			btnMove = new JButton("Move");
			btnMove.setEnabled(false);
			btnMove.setToolTipText("The move button used to move ships.");
			// If button is pressed
			btnMove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("   ");
					// Set the mastership movement to true through the observer pattern
					theMasterShip.settheMovement(true);
					// Set the Undo button to true as there is now a move available to be undone
					btnUndo.setEnabled(true);
					// If the allships list doesnt contain the mastership, add mastership into the allships list
					if(!allships.contains(theMasterShip)){
						allships.add(theMasterShip);
					}
					// If one of the enemy ships is not in the game yet
					if(!allships.contains(theBattleCrusier) || !allships.contains(theBattleStar) || !allships.contains(theBattleShooter)){
						// Randomly enter a ship at a one in three chance
						Random rand = new Random();
						int n = rand.nextInt(3) + 1;
						if (n == 2){
							// Get randomly return ship from factory pattern
							chosenship = randomenemyshipgen.randomship();
							// Create BattleCrusier if it does not already exist
							if (chosenship == 0)
							{
								if(!allships.contains(theBattleCrusier)){
									allships.add(theBattleCrusier);
								}	
							}
							// Create BattleStar if it does not already exist
							if (chosenship == 1)
							{
								if(!allships.contains(theBattleStar)){
									allships.add(theBattleStar);
								}	
							}
							// Create Battleshooter if it does not already exist
							if (chosenship == 2)
							{
								if(!allships.contains(theBattleShooter)){
									allships.add(theBattleShooter);
								}	
							}
						}	
					}
					// Move all ships which are active with command pattern
					moveships.active();
					// Update Gui with the movements if ships are on the Gui
					movementmastership();
					if(allships.contains(theBattleCrusier)){
						movementbattlecrusier();
						movescrusier++;
					}
					if(allships.contains(theBattleStar)){
						movementbattlestar();
						movesstar++;
					}
					if(allships.contains(theBattleShooter)){
						movementbattleshooter();
						movesshooter++;
					}
					// If defensive button is selected then check for conflicts
					if(defensivebutton.isSelected()==true){
						operationalmode defmode = new defensivemode();
						defmode.destroyin();
					}
					// Else if offensive button is selected check for conflicts
					else if (offensivebutton.isSelected()==true){
						operationalmode opmode = new offensivemode();
						opmode.destroyin();
					}
					// Play movement sound
					File swoosh = new File("swoosh.wav");
					PlaySound(swoosh);
					// If gameover boolean is true then end the game
					if (allships.contains(theBattleStar) && removestar == true){
						removestar();
					}
					if (allships.contains(theBattleCrusier) && removecrusier == true){
						removecruiser();
					}
					if (allships.contains(theBattleShooter) && removeshooter == true){
						removeshooter();
					}
					if (gameoverbool == true)
					{
						System.out.println("Gamover!");
						
						gameover();
					}
					// Reset the remove ship booleans back to false
					removeshooter = false;
					removecrusier = false;
					removestar = false;
				}
			});
			// Set remaining properties
			btnMove.setBounds(220, 50, 120, 35);
			btnMove.setOpaque(false);
			btnMove.setContentAreaFilled(false);
			btnMove.setBorderPainted(false);
			btnMove.setFont(new Font("Arial", Font.BOLD, 30));
			btnMove.setForeground(Color.YELLOW);
		}
		return btnMove;
	}
	// Method which plays the sound when called
	static void PlaySound(File Sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			// Aditional thread which allows the full audio clip to be played without being cut
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}
		catch(Exception e)
		{
			
		}
	}
	// Method for the undo button
	private JButton getBtnUndo(){
		if (btnUndo == null) {
			// Set button properties
			btnUndo = new JButton("Undo");
			btnUndo.setEnabled(false);
			btnUndo.setToolTipText("The undo button used to undo previous moves.");
			// If undo button is pressed
			btnUndo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// If battlecrusier is on the board then
					if(allships.contains(theBattleCrusier)){
						// Increase the undo clicks counter for cruiser (basically how many moves back do you need to go)
						undoclickscrusier++;
						// If the amount of moves the cruiser has made is one less than the moves made then
						if (undoclickscrusier == movescrusier-1)
						{
							removecruiser();
						}
					}
					// If battlestar is on the board then
					if(allships.contains(theBattleStar)){
						// Increase the undo clicks counter for star (basically how many moves back do you need to go)
						undoclicksstar++;
						// If the amount of moves the star has made is one less than the moves made then
						if (undoclicksstar == movesstar-1)
						{
							removestar();
						}
					}
					// If battleshooter is on the board then
					if(allships.contains(theBattleShooter)){
						// Increase the undo clicks counter for shooter (basically how many moves back do you need to go)
						undoclicksshooter++;
						// If the amount of moves the shooter has made is one less than the moves made then
						if (undoclicksshooter == movesshooter-1)
						{
							removeshooter();
						}
					}					
					// Move the remaining ships with the command pattern
					moveships.activeundo();
					// Update the masterships Gui position
					movementmastership();
					// If the battleshooter is still in the game then update its position on the gui
					if(allships.contains(theBattleShooter)){
						movementbattleshooter();
					}
					// If the battlestar is still in the game then update its position on the gui
					if(allships.contains(theBattleStar)){
						movementbattlestar();
					}
					// If the battlecruiser is still in the game then update its position on the gui
					if(allships.contains(theBattleCrusier)){
						movementbattlecrusier();
					}
					// Increase undoclicks which is for the mastership
					undoclicks++;
					// If undoclicks is equal to the amount of moves the master ship has made minus one 
					if (undoclicks == movesmaster-1)
					{
						// Set the undo button to false as no more undos in the game possible and output an error message
						btnUndo.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Undo button has been disabled as no more undo moves are possible for the Mastership.", "Notification!", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			// Set button properties
			btnUndo.setBounds(340, 50, 120, 35);
			btnUndo.setOpaque(false);
			btnUndo.setContentAreaFilled(false);
			btnUndo.setBorderPainted(false);
			btnUndo.setFont(new Font("Arial", Font.BOLD, 30));
			btnUndo.setForeground(Color.YELLOW);
		}
		return btnUndo;
	}
	// Start Button
	private JButton getBtnStart() {
		// Set button propeties
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.setToolTipText("The start button used to start the game.");
			// If button is pressed
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Set the move button to true as there is now a ship to move
					btnMove.setEnabled(true);
					// Set start to false
					btnStart.setEnabled(false); 
					// Add in the materships
					allships.add(theMasterShip);
					// Make all ships move
					moveships.active();
					// Update Gui with the movements
					movementmastership();
				}
			});
			// Set button properties
			btnStart.setBounds(100, 50, 120, 35);
			btnStart.setOpaque(false);
			btnStart.setContentAreaFilled(false);
			btnStart.setBorderPainted(false);
			btnStart.setFont(new Font("Arial", Font.BOLD, 30));
			btnStart.setForeground(Color.YELLOW);
		}
		return btnStart;
	}
	// Mehtod for exit button
	private JButton getBtnExit() {
		// Set button properties
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setToolTipText("The exit button used to close and exit the game.");
			// If button is pressed then exit and close window
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			// Set remaining properties
			btnExit.setBounds(460, 50, 120, 35);
			btnExit.setOpaque(false);
			btnExit.setContentAreaFilled(false);
			btnExit.setBorderPainted(false);
			btnExit.setFont(new Font("Arial", Font.BOLD, 30));
			btnExit.setForeground(Color.YELLOW);
		}
		return btnExit;
	}	
	// Labels for each individual square. The board is setup in a 4 by 4 grid, then each square is broken down into 4. 
	// The top left sub square of each square holds the masterspace, top right holds the cruisers, bottom left the star and bottom right the shooters.
	// The variable image is changed to update the gui
	private JLabel getlbl1p1() {
		ImageIcon iconLogo = new ImageIcon(image);	
		if (lbl1p1 == null)
			lbl1p1 = new JLabel("");
			lbl1p1.setIcon(iconLogo);
			lbl1p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl1p1.setBounds(100, 100, 70, 70);
		return lbl1p1;
	}
	private JLabel getlbl1p2() {
		ImageIcon iconLogo = new ImageIcon(image);	
		if (lbl1p2 == null)
			lbl1p2 = new JLabel("");
			lbl1p2.setIcon(iconLogo);
			lbl1p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl1p2.setBounds(100, 170, 70, 70);
		return lbl1p2;
	}
	private JLabel getlbl1p3() {
		ImageIcon iconLogo = new ImageIcon(image);	
		if (lbl1p3 == null)
			lbl1p3 = new JLabel("");
			lbl1p3.setIcon(iconLogo);
			lbl1p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl1p3.setBounds(170, 100, 70, 70);
		return lbl1p3;
	}
	private JLabel getlbl1p4() {
		ImageIcon iconLogo = new ImageIcon(image);	
		if (lbl1p4 == null)
			lbl1p4 = new JLabel("");
			lbl1p4.setIcon(iconLogo);
			lbl1p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl1p4.setBounds(170, 170, 70, 70);
		return lbl1p4;
	}
	private JLabel getlbl2p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl2p1 == null)
			lbl2p1 = new JLabel("");
			lbl2p1.setIcon(iconLogo);
			lbl2p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl2p1.setBounds(250, 100, 70, 70);
		return lbl2p1;
	}
	private JLabel getlbl2p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl2p2 == null)
			lbl2p2 = new JLabel("");
			lbl2p2.setIcon(iconLogo);
			lbl2p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl2p2.setBounds(250, 170, 70, 70);
		return lbl2p2;
	}
	private JLabel getlbl2p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl2p3 == null)
			lbl2p3 = new JLabel("");
			lbl2p3.setIcon(iconLogo);
			lbl2p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl2p3.setBounds(320, 100, 70, 70);
		return lbl2p3;
	}
	private JLabel getlbl2p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl2p4 == null)
			lbl2p4 = new JLabel("");
			lbl2p4.setIcon(iconLogo);
			lbl2p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl2p4.setBounds(320, 170, 70, 70);
		return lbl2p4;
	}
	private JLabel getlbl3p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl3p1 == null)
			lbl3p1 = new JLabel("");
			lbl3p1.setIcon(iconLogo);
			lbl3p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl3p1.setBounds(400, 100, 70, 70);
		return lbl3p1;
	}
	private JLabel getlbl3p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl3p2 == null)
			lbl3p2 = new JLabel("");
			lbl3p2.setIcon(iconLogo);
			lbl3p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl3p2.setBounds(400, 170, 70, 70);
		return lbl3p2;
	}
	private JLabel getlbl3p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl3p3 == null)
			lbl3p3 = new JLabel("");
			lbl3p3.setIcon(iconLogo);
			lbl3p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl3p3.setBounds(470, 100, 70, 70);
		return lbl3p3;
	}
	private JLabel getlbl3p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl3p4 == null)
			lbl3p4 = new JLabel("");
			lbl3p4.setIcon(iconLogo);
			lbl3p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl3p4.setBounds(470, 170, 70, 70);
		return lbl3p4;
	}
	private JLabel getlbl4p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl4p1 == null)
			lbl4p1 = new JLabel("");
			lbl4p1.setIcon(iconLogo);
			lbl4p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl4p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl4p1.setBounds(550, 100, 70, 70);
		return lbl4p1;
	}
	private JLabel getlbl4p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl4p2 == null)
			lbl4p2 = new JLabel("");
			lbl4p2.setIcon(iconLogo);
			lbl4p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl4p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl4p2.setBounds(550, 170, 70, 70);
		return lbl4p2;
	}
	private JLabel getlbl4p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl4p3 == null)
			lbl4p3 = new JLabel("");
			lbl4p3.setIcon(iconLogo);
			lbl4p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl4p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl4p3.setBounds(620, 100, 70, 70);
		return lbl4p3;
	}
	private JLabel getlbl4p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl4p4 == null)
			lbl4p4 = new JLabel("");
			lbl4p4.setIcon(iconLogo);
			lbl4p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl4p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl4p4.setBounds(620, 170, 70, 70);
		return lbl4p4;
	}
	private JLabel getlbl5p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl5p1 == null)
			lbl5p1 = new JLabel("");
			lbl5p1.setIcon(iconLogo);
			lbl5p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl5p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl5p1.setBounds(100, 250, 70, 70);
		return lbl5p1;
	}
	private JLabel getlbl5p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl5p2 == null)
			lbl5p2 = new JLabel("");
			lbl5p2.setIcon(iconLogo);
			lbl5p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl5p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl5p2.setBounds(100, 320, 70, 70);
		return lbl5p2;
	}
	private JLabel getlbl5p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl5p3 == null)
			lbl5p3 = new JLabel("");
			lbl5p3.setIcon(iconLogo);
			lbl5p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl5p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl5p3.setBounds(170, 250, 70, 70);
		return lbl5p3;
	}
	private JLabel getlbl5p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl5p4 == null)
			lbl5p4 = new JLabel("");
			lbl5p4.setIcon(iconLogo);
			lbl5p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl5p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl5p4.setBounds(170, 320, 70, 70);
		return lbl5p4;
	}
	private JLabel getlbl6p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl6p1 == null)
			lbl6p1 = new JLabel("");
			lbl6p1.setIcon(iconLogo);
			lbl6p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl6p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl6p1.setBounds(250, 250, 70, 70);
		return lbl6p1;
	}
	private JLabel getlbl6p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl6p2 == null)
			lbl6p2 = new JLabel("");
			lbl6p2.setIcon(iconLogo);
			lbl6p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl6p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl6p2.setBounds(250, 320, 70, 70);
		return lbl6p2;
	}
	private JLabel getlbl6p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl6p3 == null)
			lbl6p3 = new JLabel("");
			lbl6p3.setIcon(iconLogo);
			lbl6p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl6p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl6p3.setBounds(320, 250, 70, 70);
		return lbl6p3;
	}
	private JLabel getlbl6p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl6p4 == null)
			lbl6p4 = new JLabel("");
			lbl6p4.setIcon(iconLogo);
			lbl6p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl6p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl6p4.setBounds(320, 320, 70, 70);
		return lbl6p4;
	}
	private JLabel getlbl7p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl7p1 == null)
			lbl7p1 = new JLabel("");
			lbl7p1.setIcon(iconLogo);
			lbl7p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl7p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl7p1.setBounds(400, 250, 70, 70);
		return lbl7p1;
	}
	private JLabel getlbl7p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl7p2 == null)
			lbl7p2 = new JLabel("");
			lbl7p2.setIcon(iconLogo);
			lbl7p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl7p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl7p2.setBounds(400, 320, 70, 70);
		return lbl7p2;
	}
	private JLabel getlbl7p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl7p3 == null)
			lbl7p3 = new JLabel("");
			lbl7p3.setIcon(iconLogo);
			lbl7p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl7p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl7p3.setBounds(470, 250, 70, 70);
		return lbl7p3;
	}
	private JLabel getlbl7p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl7p4 == null)
			lbl7p4 = new JLabel("");
			lbl7p4.setIcon(iconLogo);
			lbl7p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl7p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl7p4.setBounds(470, 320, 70, 70);
		return lbl7p4;
	}
	private JLabel getlbl8p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl8p1 == null)
			lbl8p1 = new JLabel("");
			lbl8p1.setIcon(iconLogo);
			lbl8p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl8p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl8p1.setBounds(550, 250, 70, 70);
		return lbl8p1;
	}
	private JLabel getlbl8p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl8p2 == null)
			lbl8p2 = new JLabel("");
			lbl8p2.setIcon(iconLogo);
			lbl8p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl8p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl8p2.setBounds(550, 320, 70, 70);
		return lbl8p2;
	}
	private JLabel getlbl8p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl8p3 == null)
			lbl8p3 = new JLabel("");
			lbl8p3.setIcon(iconLogo);
			lbl8p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl8p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl8p3.setBounds(620, 250, 70, 70);
		return lbl8p3;
	}
	private JLabel getlbl8p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl8p4 == null)
			lbl8p4 = new JLabel("");
			lbl8p4.setIcon(iconLogo);
			lbl8p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl8p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl8p4.setBounds(620, 320, 70, 70);
		return lbl8p4;
	}
	private JLabel getlbl9p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl9p1 == null)
			lbl9p1 = new JLabel("");
			lbl9p1.setIcon(iconLogo);
			lbl9p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl9p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl9p1.setBounds(100, 400, 70, 70);
		return lbl9p1;
	}
	private JLabel getlbl9p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl9p2 == null)
			lbl9p2 = new JLabel("");
			lbl9p2.setIcon(iconLogo);
			lbl9p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl9p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl9p2.setBounds(100, 470, 70, 70);
		return lbl9p2;
	}
	private JLabel getlbl9p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl9p3 == null)
			lbl9p3 = new JLabel("");
			lbl9p3.setIcon(iconLogo);
			lbl9p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl9p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl9p3.setBounds(170, 400, 70, 70);
		return lbl9p3;
	}
	private JLabel getlbl9p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl9p4 == null)
			lbl9p4 = new JLabel("");
			lbl9p4.setIcon(iconLogo);
			lbl9p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl9p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl9p4.setBounds(170, 470, 70, 70);
		return lbl9p4;
	}
	private JLabel getlbl10p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl10p1 == null)
			lbl10p1 = new JLabel("");
			lbl10p1.setIcon(iconLogo);
			lbl10p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl10p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl10p1.setBounds(250, 400, 70, 70);
		return lbl10p1;
	}
	private JLabel getlbl10p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl10p2 == null)
			lbl10p2 = new JLabel("");
			lbl10p2.setIcon(iconLogo);
			lbl10p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl10p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl10p2.setBounds(250, 470, 70, 70);
		return lbl10p2;
	}
	private JLabel getlbl10p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl10p3 == null)
			lbl10p3 = new JLabel("");
			lbl10p3.setIcon(iconLogo);
			lbl10p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl10p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl10p3.setBounds(320, 400, 70, 70);
		return lbl10p3;
	}
	private JLabel getlbl10p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl10p4 == null)
			lbl10p4 = new JLabel("");
			lbl10p4.setIcon(iconLogo);
			lbl10p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl10p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl10p4.setBounds(320, 470, 70, 70);
		return lbl10p4;
	}
	private JLabel getlbl11p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl11p1 == null)
			lbl11p1 = new JLabel("");
			lbl11p1.setIcon(iconLogo);
			lbl11p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl11p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl11p1.setBounds(400, 400, 70, 70);
		return lbl11p1;
	}
	private JLabel getlbl11p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl11p2 == null)
			lbl11p2 = new JLabel("");
			lbl11p2.setIcon(iconLogo);
			lbl11p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl11p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl11p2.setBounds(400, 470, 70, 70);
		return lbl11p2;
	}
	private JLabel getlbl11p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl11p3 == null)
			lbl11p3 = new JLabel("");
			lbl11p3.setIcon(iconLogo);
			lbl11p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl11p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl11p3.setBounds(470, 400, 70, 70);
		return lbl11p3;
	}
	private JLabel getlbl11p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl11p4 == null)
			lbl11p4 = new JLabel("");
			lbl11p4.setIcon(iconLogo);
			lbl11p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl11p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl11p4.setBounds(470, 470, 70, 70);
		return lbl11p4;
	}
	private JLabel getlbl12p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl12p1 == null)
			lbl12p1 = new JLabel("");
			lbl12p1.setIcon(iconLogo);
			lbl12p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl12p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl12p1.setBounds(550, 400, 70, 70);
		return lbl12p1;
	}
	private JLabel getlbl12p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl12p2 == null)
			lbl12p2 = new JLabel("");
			lbl12p2.setIcon(iconLogo);
			lbl12p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl12p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl12p2.setBounds(550, 470, 70, 70);
		return lbl12p2;
	}
	private JLabel getlbl12p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl12p3 == null)
			lbl12p3 = new JLabel("");
			lbl12p3.setIcon(iconLogo);
			lbl12p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl12p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl12p3.setBounds(620, 400, 70, 70);
		return lbl12p3;
	}
	private JLabel getlbl12p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl12p4 == null)
			lbl12p4 = new JLabel("");
			lbl12p4.setIcon(iconLogo);
			lbl12p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl12p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl12p4.setBounds(620, 470, 70, 70);
		return lbl12p4;
	}
	private JLabel getlbl13p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl13p1 == null)
			lbl13p1 = new JLabel("");
			lbl13p1.setIcon(iconLogo);
			lbl13p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl13p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl13p1.setBounds(100, 550, 70, 70);
		return lbl13p1;
	}
	private JLabel getlbl13p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl13p2 == null)
			lbl13p2 = new JLabel("");
			lbl13p2.setIcon(iconLogo);
			lbl13p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl13p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl13p2.setBounds(100, 620, 70, 70);
		return lbl13p2;
	}
	private JLabel getlbl13p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl13p3 == null)
			lbl13p3 = new JLabel("");
			lbl13p3.setIcon(iconLogo);
			lbl13p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl13p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl13p3.setBounds(170, 550, 70, 70);
		return lbl13p3;
	}
	private JLabel getlbl13p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl13p4 == null)
			lbl13p4 = new JLabel("");
			lbl13p4.setIcon(iconLogo);
			lbl13p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl13p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl13p4.setBounds(170, 620, 70, 70);
		return lbl13p4;
	}
	private JLabel getlbl14p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl14p1 == null)
			lbl14p1 = new JLabel("");
			lbl14p1.setIcon(iconLogo);
			lbl14p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl14p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl14p1.setBounds(250, 550, 70, 70);
		return lbl14p1;
	}
	private JLabel getlbl14p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl14p2 == null)
			lbl14p2 = new JLabel("");
			lbl14p2.setIcon(iconLogo);
			lbl14p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl14p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl14p2.setBounds(250, 620, 70, 70);
		return lbl14p2;
	}
	private JLabel getlbl14p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl14p3 == null)
			lbl14p3 = new JLabel("");
			lbl14p3.setIcon(iconLogo);
			lbl14p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl14p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl14p3.setBounds(320, 550, 70, 70);
		return lbl14p3;
	}
	private JLabel getlbl14p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl14p4 == null)
			lbl14p4 = new JLabel("");
			lbl14p4.setIcon(iconLogo);
			lbl14p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl14p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl14p4.setBounds(320, 620, 70, 70);
		return lbl14p4;
	}
	private JLabel getlbl15p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl15p1 == null)
			lbl15p1 = new JLabel("");
			lbl15p1.setIcon(iconLogo);
			lbl15p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl15p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl15p1.setBounds(400, 550, 70, 70);
		return lbl15p1;
	}
	private JLabel getlbl15p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl15p2 == null)
			lbl15p2 = new JLabel("");
			lbl15p2.setIcon(iconLogo);
			lbl15p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl15p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl15p2.setBounds(400, 620, 70, 70);
		return lbl15p2;
	}
	private JLabel getlbl15p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl15p3 == null)
			lbl15p3 = new JLabel("");
			lbl15p3.setIcon(iconLogo);
			lbl15p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl15p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl15p3.setBounds(470, 550, 70, 70);
		return lbl15p3;
	}
	private JLabel getlbl15p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl15p4 == null)
			lbl15p4 = new JLabel("");
			lbl15p4.setIcon(iconLogo);
			lbl15p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl15p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl15p4.setBounds(470, 620, 70, 70);
		return lbl15p4;
	}
	private JLabel getlbl16p1() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl16p1 == null)
			lbl16p1 = new JLabel("");
			lbl16p1.setIcon(iconLogo);
			lbl16p1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl16p1.setFont(new Font("Arial", Font.BOLD, 14));
			lbl16p1.setBounds(550, 550, 70, 70);
		return lbl16p1;
	}
	private JLabel getlbl16p2() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl16p2 == null)
			lbl16p2 = new JLabel("");
			lbl16p2.setIcon(iconLogo);
			lbl16p2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl16p2.setFont(new Font("Arial", Font.BOLD, 14));
			lbl16p2.setBounds(550, 620, 70, 70);
		return lbl16p2;
	}
	private JLabel getlbl16p3() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl16p3 == null)
			lbl16p3 = new JLabel("");
			lbl16p3.setIcon(iconLogo);
			lbl16p3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl16p3.setFont(new Font("Arial", Font.BOLD, 14));
			lbl16p3.setBounds(620, 550, 70, 70);
		return lbl16p3;
	}
	private JLabel getlbl16p4() {
		ImageIcon iconLogo = new ImageIcon(image);
		if (lbl16p4 == null)
			lbl16p4 = new JLabel("");
			lbl16p4.setIcon(iconLogo);
			lbl16p4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl16p4.setFont(new Font("Arial", Font.BOLD, 14));
			lbl16p4.setBounds(620, 620, 70, 70);
		return lbl16p4;
	}
	// Method which updates the GUI of the masterships position
	public void movementmastership(){
		if (mastershipposx == 0 && mastershipposy == 0)
		{
			Destroyin2.masterx = 0;
			Destroyin2.mastery = 0;
			Destroyin3ormore.masterx = 0;
			Destroyin3ormore.mastery = 0;
			image = "mstr.png";
			contentPane.add(getlbl1p1());
			image = "photo.png";
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 0 && mastershipposy == 1)
		{
			Destroyin2.masterx = 0;
			Destroyin2.mastery = 1;
			Destroyin3ormore.masterx = 0;
			Destroyin3ormore.mastery = 1;
			image = "mstr.png";
			contentPane.add(getlbl2p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 0 && mastershipposy == 2)
		{
			Destroyin2.masterx = 0;
			Destroyin2.mastery = 2;
			Destroyin3ormore.masterx = 0;
			Destroyin3ormore.mastery = 2;
			image = "mstr.png";
			contentPane.add(getlbl3p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 0 && mastershipposy == 3)
		{
			Destroyin2.masterx = 0;
			Destroyin2.mastery = 3;
			Destroyin3ormore.masterx = 0;
			Destroyin3ormore.mastery = 3;
			image = "mstr.png";
			contentPane.add(getlbl4p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 1 && mastershipposy == 0)
		{
			Destroyin2.masterx = 1;
			Destroyin2.mastery = 0;
			Destroyin3ormore.masterx = 1;
			Destroyin3ormore.mastery = 0;
			image = "mstr.png";
			contentPane.add(getlbl5p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if(mastershipposx == 1 && mastershipposy == 1)
		{
			Destroyin2.masterx = 1;
			Destroyin2.mastery = 1;
			Destroyin3ormore.masterx = 1;
			Destroyin3ormore.mastery = 1;
			image = "mstr.png";
			contentPane.add(getlbl6p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 1 && mastershipposy == 2)
		{
			Destroyin2.masterx = 1;
			Destroyin2.mastery = 2;
			Destroyin3ormore.masterx = 1;
			Destroyin3ormore.mastery = 2;
			image = "mstr.png";
			contentPane.add(getlbl7p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 1 && mastershipposy == 3)
		{
			Destroyin2.masterx = 1;
			Destroyin2.mastery = 3;
			Destroyin3ormore.masterx = 1;
			Destroyin3ormore.mastery = 3;
			image = "mstr.png";
			contentPane.add(getlbl8p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if(mastershipposx == 2 && mastershipposy == 0)
		{
			Destroyin2.masterx = 2;
			Destroyin2.mastery = 0;
			Destroyin3ormore.masterx = 2;
			Destroyin3ormore.mastery = 0;
			image = "mstr.png";
			contentPane.add(getlbl9p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 2 && mastershipposy == 1)
		{
			Destroyin2.masterx = 2;
			Destroyin2.mastery = 1;
			Destroyin3ormore.masterx = 2;
			Destroyin3ormore.mastery = 1;
			image = "mstr.png";
			contentPane.add(getlbl10p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 2 && mastershipposy == 2)
		{
			Destroyin2.masterx = 2;
			Destroyin2.mastery = 2;
			Destroyin3ormore.masterx = 2;
			Destroyin3ormore.mastery = 2;
			image = "mstr.png";
			contentPane.add(getlbl11p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if(mastershipposx == 2 && mastershipposy == 3)
		{
			Destroyin2.masterx = 2;
			Destroyin2.mastery = 3;
			Destroyin3ormore.masterx = 2;
			Destroyin3ormore.mastery = 3;
			image = "mstr.png";
			contentPane.add(getlbl12p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 3 && mastershipposy == 0)
		{
			Destroyin2.masterx = 3;
			Destroyin2.mastery = 0;
			Destroyin3ormore.masterx = 3;
			Destroyin3ormore.mastery = 0;
			image = "mstr.png";
			contentPane.add(getlbl13p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 3 && mastershipposy == 1)
		{
			Destroyin2.masterx = 3;
			Destroyin2.mastery = 1;
			Destroyin3ormore.masterx = 3;
			Destroyin3ormore.mastery = 1;
			image = "mstr.png";
			contentPane.add(getlbl14p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl15p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 3 && mastershipposy == 2)
		{
			Destroyin2.masterx = 3;
			Destroyin2.mastery = 2;
			Destroyin3ormore.masterx = 3;
			Destroyin3ormore.mastery = 2;
			image = "mstr.png";
			contentPane.add(getlbl15p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl16p1());
		}
		else if (mastershipposx == 3 && mastershipposy == 3)
		{
			Destroyin2.masterx = 3;
			Destroyin2.mastery = 3;
			Destroyin3ormore.masterx = 3;
			Destroyin3ormore.mastery = 3;
			image = "mstr.png";
			contentPane.add(getlbl16p1());
			image = "photo.png";
			contentPane.add(getlbl1p1());
			contentPane.add(getlbl2p1());
			contentPane.add(getlbl3p1());
			contentPane.add(getlbl4p1());
			contentPane.add(getlbl5p1());
			contentPane.add(getlbl6p1());
			contentPane.add(getlbl7p1());
			contentPane.add(getlbl8p1());
			contentPane.add(getlbl9p1());
			contentPane.add(getlbl10p1());
			contentPane.add(getlbl11p1());
			contentPane.add(getlbl12p1());
			contentPane.add(getlbl13p1());
			contentPane.add(getlbl14p1());
			contentPane.add(getlbl15p1());
		}
	}
	// Method which updates the GUI of the battlestars position
	public void movementbattlestar(){
		if (starshipposx == 0 && starshipposy == 0)
		{
			Destroyin2.starx = 0;
			Destroyin2.stary = 0;
			Destroyin3ormore.starx = 0;
			Destroyin3ormore.stary = 0;
			image = "bst.png";
			contentPane.add(getlbl1p2());
			image = "photo.png";
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 0 && starshipposy == 1)
		{
			Destroyin2.starx = 0;
			Destroyin2.stary = 1;
			Destroyin3ormore.starx = 0;
			Destroyin3ormore.stary = 1;
			image = "bst.png";
			contentPane.add(getlbl2p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 0 && starshipposy == 2)
		{
			Destroyin2.starx = 0;
			Destroyin2.stary = 2;
			Destroyin3ormore.starx = 0;
			Destroyin3ormore.stary = 2;
			image = "bst.png";
			contentPane.add(getlbl3p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 0 && starshipposy == 3)
		{
			Destroyin2.starx = 0;
			Destroyin2.stary = 3;
			Destroyin3ormore.starx = 0;
			Destroyin3ormore.stary = 3;
			image = "bst.png";
			contentPane.add(getlbl4p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 1 && starshipposy == 0)
		{
			Destroyin2.starx = 1;
			Destroyin2.stary = 0;
			Destroyin3ormore.starx = 1;
			Destroyin3ormore.stary = 0;
			image = "bst.png";
			contentPane.add(getlbl5p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if(starshipposx == 1 && starshipposy == 1)
		{
			Destroyin2.starx = 1;
			Destroyin2.stary = 1;
			Destroyin3ormore.starx = 1;
			Destroyin3ormore.stary = 1;
			image = "bst.png";
			contentPane.add(getlbl6p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 1 && starshipposy == 2)
		{
			Destroyin2.starx = 1;
			Destroyin2.stary = 2;
			Destroyin3ormore.starx = 1;
			Destroyin3ormore.stary = 2;
			image = "bst.png";
			contentPane.add(getlbl7p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 1 && starshipposy == 3)
		{
			Destroyin2.starx = 1;
			Destroyin2.stary = 3;
			Destroyin3ormore.starx = 1;
			Destroyin3ormore.stary = 3;
			image = "bst.png";
			contentPane.add(getlbl8p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if(starshipposx == 2 && starshipposy == 0)
		{
			Destroyin2.starx = 2;
			Destroyin2.stary = 0;
			Destroyin3ormore.starx = 2;
			Destroyin3ormore.stary = 0;
			image = "bst.png";
			contentPane.add(getlbl9p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 2 && starshipposy == 1)
		{
			Destroyin2.starx = 2;
			Destroyin2.stary = 1;
			Destroyin3ormore.starx = 2;
			Destroyin3ormore.stary = 1;
			image = "bst.png";
			contentPane.add(getlbl10p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 2 && starshipposy == 2)
		{
			Destroyin2.starx = 2;
			Destroyin2.stary = 2;
			Destroyin3ormore.starx = 2;
			Destroyin3ormore.stary = 2;
			image = "bst.png";
			contentPane.add(getlbl11p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if(starshipposx == 2 && starshipposy == 3)
		{
			Destroyin2.starx = 2;
			Destroyin2.stary = 3;
			Destroyin3ormore.starx = 2;
			Destroyin3ormore.stary = 3;
			image = "bst.png";
			contentPane.add(getlbl12p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 3 && starshipposy == 0)
		{
			Destroyin2.starx = 3;
			Destroyin2.stary = 0;
			Destroyin3ormore.starx = 3;
			Destroyin3ormore.stary = 0;
			image = "bst.png";
			contentPane.add(getlbl13p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 3 && starshipposy == 1)
		{
			Destroyin2.starx = 3;
			Destroyin2.stary = 1;
			Destroyin3ormore.starx = 3;
			Destroyin3ormore.stary = 1;
			image = "bst.png";
			contentPane.add(getlbl14p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl15p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 3 && starshipposy == 2)
		{
			Destroyin2.starx = 3;
			Destroyin2.stary = 2;
			Destroyin3ormore.starx = 3;
			Destroyin3ormore.stary = 2;
			image = "bst.png";
			contentPane.add(getlbl15p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl16p2());
		}
		else if (starshipposx == 3 && starshipposy == 3)
		{
			Destroyin2.starx = 3;
			Destroyin2.stary = 3;
			Destroyin3ormore.starx = 3;
			Destroyin3ormore.stary = 3;
			image = "bst.png";
			contentPane.add(getlbl16p2());
			image = "photo.png";
			contentPane.add(getlbl1p2());
			contentPane.add(getlbl2p2());
			contentPane.add(getlbl3p2());
			contentPane.add(getlbl4p2());
			contentPane.add(getlbl5p2());
			contentPane.add(getlbl6p2());
			contentPane.add(getlbl7p2());
			contentPane.add(getlbl8p2());
			contentPane.add(getlbl9p2());
			contentPane.add(getlbl10p2());
			contentPane.add(getlbl11p2());
			contentPane.add(getlbl12p2());
			contentPane.add(getlbl13p2());
			contentPane.add(getlbl14p2());
			contentPane.add(getlbl15p2());
		}
	}
	// Method which updates the GUI of the battlecruiser position
	public void movementbattlecrusier(){
		if (crusiershipposx == 0 && crusiershipposy == 0)
		{
			Destroyin2.crusierx = 0;
			Destroyin2.crusiery = 0;
			Destroyin3ormore.crusierx = 0;
			Destroyin3ormore.crusiery = 0;
			image = "bc.png";
			contentPane.add(getlbl1p3());
			image = "photo.png";
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 0 && crusiershipposy == 1)
		{
			Destroyin2.crusierx = 0;
			Destroyin2.crusiery = 1;
			Destroyin3ormore.crusierx = 0;
			Destroyin3ormore.crusiery = 1;
			image = "bc.png";
			contentPane.add(getlbl2p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 0 && crusiershipposy == 2)
		{
			Destroyin2.crusierx = 0;
			Destroyin2.crusiery = 2;
			Destroyin3ormore.crusierx = 0;
			Destroyin3ormore.crusiery = 2;
			image = "bc.png";
			contentPane.add(getlbl3p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 0 && crusiershipposy == 3)
		{
			Destroyin2.crusierx = 0;
			Destroyin2.crusiery = 3;
			Destroyin3ormore.crusierx = 0;
			Destroyin3ormore.crusiery = 3;
			image = "bc.png";
			contentPane.add(getlbl4p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 1 && crusiershipposy == 0)
		{
			Destroyin2.crusierx = 1;
			Destroyin2.crusiery = 0;
			Destroyin3ormore.crusierx = 1;
			Destroyin3ormore.crusiery = 0;
			image = "bc.png";
			contentPane.add(getlbl5p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if(crusiershipposx == 1 && crusiershipposy == 1)
		{
			Destroyin2.crusierx = 1;
			Destroyin2.crusiery = 1;
			Destroyin3ormore.crusierx = 1;
			Destroyin3ormore.crusiery = 1;
			image = "bc.png";
			contentPane.add(getlbl6p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 1 && crusiershipposy == 2)
		{
			Destroyin2.crusierx = 1;
			Destroyin2.crusiery = 2;
			Destroyin3ormore.crusierx = 1;
			Destroyin3ormore.crusiery = 2;
			image = "bc.png";
			contentPane.add(getlbl7p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 1 && crusiershipposy == 3)
		{
			Destroyin2.crusierx = 1;
			Destroyin2.crusiery = 3;
			Destroyin3ormore.crusierx = 1;
			Destroyin3ormore.crusiery = 3;
			image = "bc.png";
			contentPane.add(getlbl8p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if(crusiershipposx == 2 && crusiershipposy == 0)
		{
			Destroyin2.crusierx = 2;
			Destroyin2.crusiery = 0;
			Destroyin3ormore.crusierx = 2;
			Destroyin3ormore.crusiery = 0;
			image = "bc.png";
			contentPane.add(getlbl9p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 2 && crusiershipposy == 1)
		{
			Destroyin2.crusierx = 2;
			Destroyin2.crusiery = 1;
			Destroyin3ormore.crusierx = 2;
			Destroyin3ormore.crusiery = 1;
			image = "bc.png";
			contentPane.add(getlbl10p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 2 && crusiershipposy == 2)
		{
			Destroyin2.crusierx = 2;
			Destroyin2.crusiery = 2;
			Destroyin3ormore.crusierx = 2;
			Destroyin3ormore.crusiery = 2;
			image = "bc.png";
			contentPane.add(getlbl11p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if(crusiershipposx == 2 && crusiershipposy == 3)
		{
			Destroyin2.crusierx = 2;
			Destroyin2.crusiery = 3;
			Destroyin3ormore.crusierx = 2;
			Destroyin3ormore.crusiery = 3;
			image = "bc.png";
			contentPane.add(getlbl12p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 3 && crusiershipposy == 0)
		{
			Destroyin2.crusierx = 3;
			Destroyin2.crusiery = 0;
			Destroyin3ormore.crusierx = 3;
			Destroyin3ormore.crusiery = 0;
			image = "bc.png";
			contentPane.add(getlbl13p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 3 && crusiershipposy == 1)
		{
			Destroyin2.crusierx = 3;
			Destroyin2.crusiery = 1;
			Destroyin3ormore.crusierx = 3;
			Destroyin3ormore.crusiery = 1;
			image = "bc.png";
			contentPane.add(getlbl14p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl15p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 3 && crusiershipposy == 2)
		{
			Destroyin2.crusierx = 3;
			Destroyin2.crusiery = 2;
			Destroyin3ormore.crusierx = 3;
			Destroyin3ormore.crusiery = 2;
			image = "bc.png";
			contentPane.add(getlbl15p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl16p3());
		}
		else if (crusiershipposx == 3 && crusiershipposy == 3)
		{
			Destroyin2.crusierx = 3;
			Destroyin2.crusiery = 3;
			Destroyin3ormore.crusierx = 3;
			Destroyin3ormore.crusiery = 3;
			image = "bc.png";
			contentPane.add(getlbl16p3());
			image = "photo.png";
			contentPane.add(getlbl1p3());
			contentPane.add(getlbl2p3());
			contentPane.add(getlbl3p3());
			contentPane.add(getlbl4p3());
			contentPane.add(getlbl5p3());
			contentPane.add(getlbl6p3());
			contentPane.add(getlbl7p3());
			contentPane.add(getlbl8p3());
			contentPane.add(getlbl9p3());
			contentPane.add(getlbl10p3());
			contentPane.add(getlbl11p3());
			contentPane.add(getlbl12p3());
			contentPane.add(getlbl13p3());
			contentPane.add(getlbl14p3());
			contentPane.add(getlbl15p3());
		}
	}
	// Method which updates the GUI of the battleshooter position
	public void movementbattleshooter(){
		if (shootershipposx == 0 && shootershipposy == 0)
		{
			Destroyin2.shooterx = 0;
			Destroyin2.shootery = 0;
			Destroyin3ormore.shooterx = 0;
			Destroyin3ormore.shootery = 0;
			image = "bsh.png";
			contentPane.add(getlbl1p4());
			image = "photo.png";
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 0 && shootershipposy == 1)
		{
			Destroyin2.shooterx = 0;
			Destroyin2.shootery = 1;
			Destroyin3ormore.shooterx = 0;
			Destroyin3ormore.shootery = 1;
			image = "bsh.png";
			contentPane.add(getlbl2p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 0 && shootershipposy == 2)
		{
			Destroyin2.shooterx = 0;
			Destroyin2.shootery = 2;
			Destroyin3ormore.shooterx = 0;
			Destroyin3ormore.shootery = 2;
			image = "bsh.png";
			contentPane.add(getlbl3p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 0 && shootershipposy == 3)
		{
			Destroyin2.shooterx = 0;
			Destroyin2.shootery = 3;
			Destroyin3ormore.shooterx = 0;
			Destroyin3ormore.shootery = 3;
			image = "bsh.png";
			contentPane.add(getlbl4p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 1 && shootershipposy == 0)
		{
			Destroyin2.shooterx = 1;
			Destroyin2.shootery = 0;
			Destroyin3ormore.shooterx = 1;
			Destroyin3ormore.shootery = 0;
			image = "bsh.png";
			contentPane.add(getlbl5p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if(shootershipposx == 1 && shootershipposy == 1)
		{
			Destroyin2.shooterx = 1;
			Destroyin2.shootery = 1;
			Destroyin3ormore.shooterx = 1;
			Destroyin3ormore.shootery = 1;
			image = "bsh.png";
			contentPane.add(getlbl6p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 1 && shootershipposy == 2)
		{
			Destroyin2.shooterx = 1;
			Destroyin2.shootery = 2;
			Destroyin3ormore.shooterx = 1;
			Destroyin3ormore.shootery = 2;
			image = "bsh.png";
			contentPane.add(getlbl7p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 1 && shootershipposy == 3)
		{
			Destroyin2.shooterx = 1;
			Destroyin2.shootery = 3;
			Destroyin3ormore.shooterx = 1;
			Destroyin3ormore.shootery = 3;
			image = "bsh.png";
			contentPane.add(getlbl8p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if(shootershipposx == 2 && shootershipposy == 0)
		{
			Destroyin2.shooterx = 2;
			Destroyin2.shootery = 0;
			Destroyin3ormore.shooterx = 2;
			Destroyin3ormore.shootery = 0;
			image = "bsh.png";
			contentPane.add(getlbl9p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 2 && shootershipposy == 1)
		{
			Destroyin2.shooterx = 2;
			Destroyin2.shootery = 1;
			Destroyin3ormore.shooterx = 2;
			Destroyin3ormore.shootery = 1;
			image = "bsh.png";
			contentPane.add(getlbl10p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 2 && shootershipposy == 2)
		{
			Destroyin2.shooterx = 2;
			Destroyin2.shootery = 2;
			Destroyin3ormore.shooterx = 2;
			Destroyin3ormore.shootery = 2;
			image = "bsh.png";
			contentPane.add(getlbl11p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if(shootershipposx == 2 && shootershipposy == 3)
		{
			Destroyin2.shooterx = 2;
			Destroyin2.shootery = 3;
			Destroyin3ormore.shooterx = 2;
			Destroyin3ormore.shootery = 3;
			image = "bsh.png";
			contentPane.add(getlbl12p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 3 && shootershipposy == 0)
		{
			Destroyin2.shooterx = 3;
			Destroyin2.shootery = 0;
			Destroyin3ormore.shooterx = 3;
			Destroyin3ormore.shootery = 0;
			image = "bsh.png";
			contentPane.add(getlbl13p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 3 && shootershipposy == 1)
		{
			Destroyin2.shooterx = 3;
			Destroyin2.shootery = 1;
			Destroyin3ormore.shooterx = 3;
			Destroyin3ormore.shootery = 1;
			image = "bsh.png";
			contentPane.add(getlbl14p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl15p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 3 && shootershipposy == 2)
		{
			Destroyin2.shooterx = 3;
			Destroyin2.shootery = 2;
			Destroyin3ormore.shooterx = 3;
			Destroyin3ormore.shootery = 2;
			image = "bsh.png";
			contentPane.add(getlbl15p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl16p4());
		}
		else if (shootershipposx == 3 && shootershipposy == 3)
		{
			Destroyin2.shooterx = 3;
			Destroyin2.shootery = 3;
			Destroyin3ormore.shooterx = 3;
			Destroyin3ormore.shootery = 3;
			image = "bsh.png";
			contentPane.add(getlbl16p4());
			image = "photo.png";
			contentPane.add(getlbl1p4());
			contentPane.add(getlbl2p4());
			contentPane.add(getlbl3p4());
			contentPane.add(getlbl4p4());
			contentPane.add(getlbl5p4());
			contentPane.add(getlbl6p4());
			contentPane.add(getlbl7p4());
			contentPane.add(getlbl8p4());
			contentPane.add(getlbl9p4());
			contentPane.add(getlbl10p4());
			contentPane.add(getlbl11p4());
			contentPane.add(getlbl12p4());
			contentPane.add(getlbl13p4());
			contentPane.add(getlbl14p4());
			contentPane.add(getlbl15p4());
		}
	}
	// Method which updates the GUI and clears all tiles the cruiser could be in
	public void blankcrusier(){
		image = "photo.png";
		contentPane.add(getlbl1p3());
		contentPane.add(getlbl2p3());
		contentPane.add(getlbl3p3());
		contentPane.add(getlbl4p3());
		contentPane.add(getlbl5p3());
		contentPane.add(getlbl6p3());
		contentPane.add(getlbl7p3());
		contentPane.add(getlbl8p3());
		contentPane.add(getlbl9p3());
		contentPane.add(getlbl10p3());
		contentPane.add(getlbl11p3());
		contentPane.add(getlbl12p3());
		contentPane.add(getlbl13p3());
		contentPane.add(getlbl14p3());
		contentPane.add(getlbl15p3());
		contentPane.add(getlbl16p3());
	}
	// Method which updates the GUI and clears all tiles the shooter could be in
	public void blankshooter(){
		image = "photo.png";
		contentPane.add(getlbl1p4());
		contentPane.add(getlbl2p4());
		contentPane.add(getlbl3p4());
		contentPane.add(getlbl4p4());
		contentPane.add(getlbl5p4());
		contentPane.add(getlbl6p4());
		contentPane.add(getlbl7p4());
		contentPane.add(getlbl8p4());
		contentPane.add(getlbl9p4());
		contentPane.add(getlbl10p4());
		contentPane.add(getlbl11p4());
		contentPane.add(getlbl12p4());
		contentPane.add(getlbl13p4());
		contentPane.add(getlbl14p4());
		contentPane.add(getlbl15p4());
		contentPane.add(getlbl16p4());
	}
	// Method which updates the GUI and clears all tiles the star could be in
	public void blankstar(){
		image = "photo.png";
		contentPane.add(getlbl1p2());
		contentPane.add(getlbl2p2());
		contentPane.add(getlbl3p2());
		contentPane.add(getlbl4p2());
		contentPane.add(getlbl5p2());
		contentPane.add(getlbl6p2());
		contentPane.add(getlbl7p2());
		contentPane.add(getlbl8p2());
		contentPane.add(getlbl9p2());
		contentPane.add(getlbl10p2());
		contentPane.add(getlbl11p2());
		contentPane.add(getlbl12p2());
		contentPane.add(getlbl13p2());
		contentPane.add(getlbl14p2());
		contentPane.add(getlbl15p2());
		contentPane.add(getlbl16p2());
	}
	// Method called game over which resets the game
	public void gameover(){
		System.out.println("Gameover!");
		image = "photo.png";
		contentPane.add(getlbl1p1());
		contentPane.add(getlbl2p1());
		contentPane.add(getlbl3p1());
		contentPane.add(getlbl4p1());
		contentPane.add(getlbl5p1());
		contentPane.add(getlbl6p1());
		contentPane.add(getlbl7p1());
		contentPane.add(getlbl8p1());
		contentPane.add(getlbl9p1());
		contentPane.add(getlbl10p1());
		contentPane.add(getlbl11p1());
		contentPane.add(getlbl12p1());
		contentPane.add(getlbl13p1());
		contentPane.add(getlbl14p1());
		contentPane.add(getlbl15p1());
		contentPane.add(getlbl16p1());
		removestar();
		removecruiser();
		removeshooter();
		btnStart.setEnabled(true);
		btnMove.setEnabled(false);
		btnUndo.setEnabled(false);
		CommandMastership.x = -1;
		CommandMastership.y = -1;
		allships.clear();
	}
	public void removecruiser(){
		// Play sounds of alarm
		File alarm = new File("Spaceship_Alarm.wav");
		PlaySound(alarm);
		// Remove the ship as no more possible moves can be done
		allships.remove(allships.indexOf(theBattleCrusier));
		// Update the Gui to remove ship
		blankcrusier();
		// Reset the cruisers variables
		undoclickscrusier=0;
		movescrusier=0;
		CommandBattleCrusier.x = -1;
		CommandBattleCrusier.x = -1;
		Destroyin2.crusierx = -1;
		Destroyin2.crusiery = -1;
		Destroyin3ormore.crusierx = -1;
		Destroyin3ormore.crusiery = -1;
		CommandBattleCrusier.loops = 0;
		// Output message 
		JOptionPane.showMessageDialog(null, "The BattleCrusier has left the game, though may random come back!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
	}
	public void removeshooter(){
		// Play sounds of alarm
		File alarm = new File("Spaceship_Alarm.wav");
		PlaySound(alarm);
		// Remove the ship as no more possible moves can be done
		allships.remove(allships.indexOf(theBattleShooter));
		// Update the Gui to remove ship
		blankshooter();
		// Reset the shooters variables
		undoclicksshooter = 0;
		movesshooter = 0;
		CommandBattleShooter.x = -1;
		CommandBattleShooter.x = -1;
		Destroyin2.shooterx = -1;
		Destroyin2.shootery = -1;
		Destroyin3ormore.shooterx = -1;
		Destroyin3ormore.shootery = -1;
		CommandBattleShooter.loops = 0;
		// Output message 
		JOptionPane.showMessageDialog(null, "The BattleShooter has left the game, though may random come back!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
	}
	public void removestar(){
		// Play sounds of alarm
		File alarm = new File("Spaceship_Alarm.wav");
		PlaySound(alarm);
		// Remove the ship as no more possible moves can be done
		allships.remove(allships.indexOf(theBattleStar));
		// Update the Gui to remove ship
		blankstar();
		// Reset the stars variables
		undoclicksstar =0;
		movesstar=0;
		CommandBattleStar.x = -1;
		CommandBattleStar.x = -1;
		Destroyin2.starx = -1;
		Destroyin2.stary = -1;
		Destroyin3ormore.starx = -1;
		Destroyin3ormore.stary = -1;
		CommandBattleStar.loops = 0;
		// Output message 
		JOptionPane.showMessageDialog(null, "The BattleStar has left the game, though may random come back!", "Notification!", JOptionPane.INFORMATION_MESSAGE);
	}
}

