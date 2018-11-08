package house.birdsview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import house.beans.LocationBean;
import house.dao.DAO;
import house.inventry.AddInventryItem;
import house.inventry.Inventry_Client;


public class Birdsview extends JFrame implements ActionListener
{
	final static Logger logger = Logger.getLogger(Birdsview.class);
	
	private static final long serialVersionUID = 1L;
	private JPanel basePanel;
	public JFrame tempFrame; // for dreyfus pop out  page
// Main "screens"
	private AddInventryItem newInventory;
	
//	private JTabbedPane tabbedPane = null; //Check if you want a tabbed pane
	
	
	// All the menu items
	private JMenuBar menuBar = null;
	private JMenu fileMenu = null, helpMenu = null, addMenuItem = null, viewMenu = null;
	private JMenuItem removeMenuItem = null, quitMenuItem = null, aboutMenuItem = null, addInventryItem = null, viewInventoryItem = null;
	private JMenuItem viewEmergencyListItem = null, viewPoliciesItem = null;
	//South Panel
	private JPanel panelSouth;
//	private JLabel sPanelLoggedOnAs;
//	private JLabel sPanelConnectionStatus;
	private JLabel itemCountLabel;
//	public JButton sPanelMessagesBut;
	private String loggerPrefix = "Birdsview Class messages - ";
	
	
//	private Inventry_Client inventryClient;
//	private PanelHobbies hobbyPanel;
	
	
	
	
	// DIRECT DAO ACCESS - MUST BE CHANGED LATER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public DAO dao;
//	public User authenticatedUser; // mo lester - bleh
	
	
	// Access varaiables 
	public Vector<LocationBean> data_locationList;   // use getNetUserList(); can be done onces and client has it

	// Style objects
	
	private Font primaryFont, secondaryFont;
	private int primaryFontSize = 16, secondaryFontSize = 20;

	// Networking stuff
/*	
    private NetworkClient networkClient = null;
	private String serverAddress = null;
	private int serverPort = 0;
	private Boolean networkSession = false;
*/	
	
	public Birdsview()
	{
		PropertyConfigurator.configure("log4j.properties");
		
		primaryFont = new Font ("THAHOMA",Font.PLAIN, primaryFontSize); // Normal Use
		secondaryFont = new Font ("THAHOMA",Font.BOLD|Font.ITALIC, secondaryFontSize); // Headings ??

		// Server connection 
/*		this.setServerAddress("localhost");
		this.setServerPort(1337);
		this.connectToServer();
*/		
		// We need to connect to the server but maybe only on login?
//		 connectToServer();
		
		// DIRECT DAO ACCESS - MUST BE CHANGED LATER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		try
		{
			dao = new DAO();
			this.getData();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Now lets do the graphics
		this.setTitle("Birdsview");
		this.setFont(primaryFont);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// size set at first for logon P
		this.setBounds(100,100,800,600);
//		this.setBounds(100,100,1600,1000);
		MyWindowListner mwl = new MyWindowListner();
		this.addWindowListener(mwl);
		
		basePanel = new JPanel();
	//	basePanel.setBackground(new Color(255,200,200));
		basePanel.setBorder(new EmptyBorder(15,15,15,15));
		basePanel.setLayout(new GridLayout(1,1));
	
		panelSouth = new JPanel();
		
		this.setupMenuBar();
		
		
		
		// The logon panel goes into the base panel
//		newInventory = new AddInventryItem(this);
//		this.add(newInventory);
//		client = new Inventry_Client(this);
//		basePanel.add(client);

		// At first we have a JFrame with a base panel with the logon panel in the middle
		this.add(basePanel, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
   
	
	// Getters and setters for data - must be changed later
	// get data or refresh data?
	public void getData()
	{
//		this.getNetUserList();
		data_locationList = dao.getLocations();
//
//		this.getNetSkillList();
//		data_skillList = dao.getSkillList();
//		
//		this.getNetHobbyList();
//		data_hobbyList = dao.getHobbyList();
//		
//		this.getNetLevels();
//	 data_levels = dao.getLevel();
//		
//		if (authenticatedUser!= null)
//		{
//			data_userSkills = this.getNetUserSkills(authenticatedUser);
//			data_userSkills = dao.getUserSkills(authenticatedUser);
//			
//			data_userHobby= this.getNetUserHobby(authenticatedUser);
//			data_userHobby = dao.getUserHobby(authenticatedUser);
//			
//			data_userRatings = this.getNetUserRating(authenticatedUser);
//			data_userRatings = dao.getRatings(authenticatedUser);
//			
//			data_notifications = this.getNetUserNotifications(authenticatedUser);
//			data_notifications = dao.getNotification(authenticatedUser);
//		}
		
		
	}
	

	
	
	// All the graphics below
	
/*	public JTabbedPane getTabbedPane()
	{
		return this.tabbedPane;
	}*/
	
	public JPanel getBasePanel()
	{
		return this.basePanel;
		
	}
	
/*	public void changeToTabbedPane()
	{
		this.setSize(1400,800);
		// bleh
		
	//	this.setBounds(0, 0,1600,1000);
	//	this.setBounds(100,100,1200,1000);
		
		basePanel.removeAll();
		basePanel.validate();
		basePanel.repaint();
		
		basePanel.add(this.tabbedPane);
		
		
		basePanel.validate();
		basePanel.repaint();
		
		// gets the Menu Bar to show
		this.validate();
		this.repaint();
	}*/
	
/*	public void setupTabs()
	{
		logger.info("Tabbed panels initializing");
		// This creates everything we need for the tabs
		
		inventryClient = new Inventry_Client(this);
				
				
		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(primaryFont);
		tabbedPane.add("Inventry", inventryClient); // this is my basic details which are edditable by default
	
	}*/
	
	public void setupMenuBar()
	{
		//indentation here shows the menu flow
		menuBar= new JMenuBar();
			
			fileMenu = new JMenu("File");
			fileMenu.setFont(primaryFont);
			fileMenu.setMnemonic('F');
				addMenuItem = new JMenu("Add");
				addMenuItem.setFont(primaryFont);
					addInventryItem = new JMenuItem("Inventory Item");
					addInventryItem.setFont(primaryFont);
					addInventryItem.addActionListener(this);
				
				removeMenuItem = new JMenuItem("Remove");
				removeMenuItem.setFont(primaryFont);
				removeMenuItem.addActionListener(this);
				
				quitMenuItem = new JMenuItem("Quit");
				quitMenuItem.setFont(primaryFont);
				quitMenuItem.addActionListener(this);				
			
			viewMenu = new JMenu("View");
			viewMenu.setFont(primaryFont);
			viewMenu.setMnemonic('V');
				viewInventoryItem = new JMenuItem("Inventory");
				viewInventoryItem.setFont(primaryFont);
				viewInventoryItem.addActionListener(this);
				
				viewEmergencyListItem = new JMenuItem("Emergency List");
				viewEmergencyListItem.setFont(primaryFont);
				viewEmergencyListItem.addActionListener(this);
				
				viewPoliciesItem = new JMenuItem("Policies");
				viewPoliciesItem.setFont(primaryFont);
				viewPoliciesItem.addActionListener(this);
				
			helpMenu = new JMenu("Help");
			helpMenu.setFont(primaryFont);
			helpMenu.setMnemonic('H');
				aboutMenuItem = new JMenuItem("About");
				aboutMenuItem.setFont(primaryFont);
				aboutMenuItem.addActionListener(this);
				
		
		
		// adding everything to the right place
		
		fileMenu.add(addMenuItem);
		addMenuItem.add(addInventryItem);
		fileMenu.addSeparator();
		fileMenu.add(removeMenuItem);
		fileMenu.add(quitMenuItem);
		
		viewMenu.add(viewInventoryItem);
		viewMenu.add(viewEmergencyListItem);
		viewMenu.add(viewPoliciesItem);
		
		helpMenu.add(aboutMenuItem);
		
		// Add all the menus to the menu bar
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);

	}
	
	public void removeMenuBar()
	{
		menuBar.removeAll();
		this.remove(menuBar);
		this.validate();
		this.repaint();
	}
	
	public void setupSouthPanel()
	{
		logger.info(loggerPrefix + "Setting up South Panel");
		try
		{
			panelSouth.removeAll();
	//		logger.debug("tring to remove all from south panel");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
	//		logger.debug("nothing to remove from south panel");
		//	e.printStackTrace();
		}
		itemCountLabel = new JLabel();
		itemCountLabel.setText("Number of Items: test!!!");
/*		sPanelConnectionStatus = new JLabel("Connected to " + this.getNetworkClient().getServerAddress() + ":" +this.getNetworkClient().getServerPort() );
		sPanelConnectionStatus.setFont(primaryFont);
		
		sPanelLoggedOnAs = new JLabel( "Logged on as '" + this.authenticatedUser.getUserName() + "' " );
		sPanelLoggedOnAs.setFont(primaryFont);
				
		sPanelMessagesBut = new JButton("Messages : " + this.getNetUserNotifications(this.authenticatedUser).size());
		sPanelMessagesBut.setFont(primaryFont);
		sPanelMessagesBut.setToolTipText("Click here to goto ratings page");
		sPanelMessagesBut.addActionListener(this);
*/
		
		panelSouth.setLayout(new GridLayout(1,3));
		
//		panelSouth.add("");
//		panelSouth.add("");
		panelSouth.add(itemCountLabel);
		
		panelSouth.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelSouth.setFont(primaryFont);

		this.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.validate();
		panelSouth.repaint();

	
	}
	
	public void hideSouthPanel()
	{
		this.remove(panelSouth);
		this.validate();
		this.repaint();
	}
	
	public void changeBasePanel(JPanel newJPanel)
	{
		basePanel.removeAll();
		this.validate();
		basePanel.add(newJPanel);
		this.validate();
		this.repaint();
	}

	public static void main(String[] args)
	{
		Birdsview birdsview = new Birdsview();
		birdsview.setVisible(true);

	}
	
	class MyWindowListner extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			
			// If we are logged in then exitMenu on the JMenu would exist and we can try graceful exist while DAO closes
			// If not logged in then we can halt right away.
			
			try
			{
				quitMenuItem.doClick();
			}
			catch (NullPointerException e)
			{
				logger.info(loggerPrefix + "Exiting...");
				System.exit(0);
			}
		}
	}


	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if (source == aboutMenuItem)
		{
			logger.info(loggerPrefix + "About Menu Item");
			JOptionPane.showMessageDialog(this, "Birdsview Eco Estate Inventory System\n"
					+ "Developer: Justin Fielding\n"
					+ "Version:   1.0.0\n"
					+ "Created for 28 Birdsview Eco Estate\n");
		}
		
		if (source == quitMenuItem)
		{
			logger.info(loggerPrefix + "Quit menu item selected...");
			System.exit(0);
		}
		
		if (source == addInventryItem)
		{
			logger.info(loggerPrefix + "Add Inventry Menu Item selected");
			newInventory = new AddInventryItem(this);
			this.changeBasePanel(newInventory);
			
		}
		
		if (source == removeMenuItem)
		{
			logger.info(loggerPrefix + "Remove Menu Item selected");
		}
		
		if (source == viewInventoryItem)
		{
			logger.info(loggerPrefix + "View Inventory Menu Item selected");
		}
		
		if (source == viewEmergencyListItem)
		{
			logger.info(loggerPrefix + "View Emergency List Menu Item selected");
		}
		
		if (source == viewPoliciesItem)
		{
			logger.info(loggerPrefix + "View Policies Menu Item selected");
		}

/*		if (source == aboutMenuItem)
		{
			// show the drefus model diagrams or something
			logger.info("About menu item clicked");
			
			//JPanel dreyfusPanel = new PanelDreyfus(this);
			
			tempFrame = new JFrame();
			tempFrame.getContentPane().add(dreyfusPanel);
			tempFrame.setSize(800,600);
			tempFrame.setVisible(true);
			tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
		}*/
		

/*		if (source == viewMenu_goBold)
		{
		
		//	setupTabs()
			this.setPrimryFont( new Font ("THAHOMA",Font.BOLD, primaryFontSize) ); // Normal Use
			this.setupTabs();
			this.setupMenuBar();
			this.setupSouthPanel();
	//		sPanel.setVisible(true);
			this.changeToTabbedPane();
			this.validate();
			this.repaint();
			
	//		logger.info("Font checker bold " + this.sPanelConnectionStatus.getFont() );
		//	secondaryFont = new Font ("THAHOMA",Font.BOLD|Font.ITALIC, 20); // Headings ??
		}
*/
	}

	// Getters and setters for server ports

/*	public void setAuthenticatedUser(User user)
	{
		this.authenticatedUser = user;
	}
	
	public User getAuthenticatedUser()
	{
		return this.authenticatedUser;
	}
	*/
	public Font getPrimaryFont()
	{
		return this.primaryFont;
	}
	
	public void setPrimryFont(Font fontIn)
	{
		this.primaryFont=fontIn;
	}
	
	public Font getSecondaryFont()
	{
		return this.secondaryFont;
	}
	
	public void setSecondaryFont(Font fontIn)
	{
		this.secondaryFont=fontIn;
	}
		
}
