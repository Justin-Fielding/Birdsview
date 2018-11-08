package house.inventry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import house.birdsview.Birdsview;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Inventry_Client extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem addMenuItem;
	private JMenuItem removeMenuItem;
	private JMenuItem quitMenuItem;
	private JMenu fileMenu;
	private JMenu helpMenu;
	private JMenuItem aboutMenuItem;
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JPanel panelCentre;
	private JLabel lblNewLabel;
	private JTextField itemNameJTF;
	private JTextField itemSerialNumberJTF;
	private JLabel itemNameLabel;
	private JLabel itemDescriptionLabel;
	private JLabel itemSerialNumberLabel;
	private JLabel itemLocationLabel;
	private JTextField itemLocationJTF;
	private JTextField itemValueJTF;
	private JLabel itemValueLabel;
	private JButton submitButton;
	private JButton cancelButton;
	private JLabel inventoryLabel;
	private JLabel itemCountLabel;
	private JTextArea itemDescriptionTextArea;
	private JScrollPane scrollPane;
	private Birdsview basePanel;
	private JButton attachImageButton;
	private JLabel attachmentFileName;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//		EventQueue.invokeLater(new Runnable()
//		{
//			public void run()
//			{
//				try
//				{
//					Inventry_Client frame = new Inventry_Client(basePanel);
//					frame.setVisible(true);
//				} catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Inventry_Client(Birdsview frame)
	{
		basePanel = frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		addMenuItem = new JMenuItem("Add Item");
		fileMenu.add(addMenuItem);
		addMenuItem.addActionListener(this);
		
		removeMenuItem = new JMenuItem("Remove Item");
		fileMenu.add(removeMenuItem);
		removeMenuItem.addActionListener(this);
		
		quitMenuItem = new JMenuItem("Quit");
		fileMenu.add(quitMenuItem);
		quitMenuItem.addActionListener(this);
		
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);
		aboutMenuItem.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		inventoryLabel = new JLabel("28 Birdsview Eco Estate Inventory");
		inventoryLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		panelNorth.add(inventoryLabel);
		
		panelSouth = new JPanel();
		panelSouth.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null));
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		itemCountLabel = new JLabel("Number of Items: ");
		itemCountLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		panelSouth.add(itemCountLabel);
		
		panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(null);
		
		lblNewLabel = new JLabel("New Item");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(350, 74, 100, 20);
		panelCentre.add(lblNewLabel);
		
		itemNameJTF = new JTextField();
		itemNameJTF.setBounds(415, 115, 150, 20);
		panelCentre.add(itemNameJTF);
		itemNameJTF.setColumns(10);
		
		itemSerialNumberJTF = new JTextField();
		itemSerialNumberJTF.setBounds(415, 149, 150, 20);
		panelCentre.add(itemSerialNumberJTF);
		itemSerialNumberJTF.setColumns(10);
		
		itemNameLabel = new JLabel("Item Name");
		itemNameLabel.setBounds(250, 118, 100, 14);
		panelCentre.add(itemNameLabel);
		
		itemDescriptionLabel = new JLabel("Item Description");
		itemDescriptionLabel.setBounds(250, 242, 100, 14);
		panelCentre.add(itemDescriptionLabel);
		
		itemSerialNumberLabel = new JLabel("Item Serial Number");
		itemSerialNumberLabel.setBounds(250, 149, 100, 14);
		panelCentre.add(itemSerialNumberLabel);
		
		itemLocationLabel = new JLabel("Item Location");
		itemLocationLabel.setBounds(250, 180, 100, 14);
		panelCentre.add(itemLocationLabel);
		
		itemLocationJTF = new JTextField();
		itemLocationJTF.setText("");
		itemLocationJTF.setBounds(415, 180, 150, 20);
		panelCentre.add(itemLocationJTF);
		itemLocationJTF.setColumns(10);
		
		itemValueJTF = new JTextField();
		itemValueJTF.setBounds(415, 211, 150, 20);
		panelCentre.add(itemValueJTF);
		itemValueJTF.setColumns(10);
		
		itemValueLabel = new JLabel("Item Value");
		itemValueLabel.setBounds(250, 211, 100, 14);
		panelCentre.add(itemValueLabel);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(250, 400, 90, 25);
		panelCentre.add(submitButton);
		submitButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(415, 400, 90, 25);
		panelCentre.add(cancelButton);
		cancelButton.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(414, 242, 150, 100);
		panelCentre.add(scrollPane);
		
		itemDescriptionTextArea = new JTextArea();
		scrollPane.setViewportView(itemDescriptionTextArea);
		itemDescriptionTextArea.setLineWrap(true);
		itemDescriptionTextArea.setWrapStyleWord(true);
		
		attachImageButton = new JButton("Attachment");
		attachImageButton.setBounds(250, 360, 89, 23);
		panelCentre.add(attachImageButton);
		attachImageButton.addActionListener(this);
		
		attachmentFileName = new JLabel("Default");
		attachmentFileName.setBounds(415, 360, 150, 23);
		panelCentre.add(attachmentFileName);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
/*		if (source == quitMenuItem)
		{
			System.out.println("Quit Menu Item");
			int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?");
			System.out.println(choice);
			if (choice == 0)
			{
				System.out.println("You chose option " + choice);
				System.exit(0);
			}
			if ((choice == 1) || (choice == 2) || (choice == -1))
			{
				System.out.println("You chose option " + choice);
				return;
			}
		}*/
		
		if (source == submitButton)
		{
			System.out.println("Pressing the Submit button");
			System.out.println("Name: " + itemNameJTF.getText() + "\nSerial No: " + itemSerialNumberJTF.getText() + "\nItem Location: " + itemLocationJTF.getText() 
			+ "\nItem Value: " + itemValueJTF.getText() + "\nItem Description: "	+ itemDescriptionTextArea.getText());
			
		}
		
		if (source == cancelButton)
		{
			System.out.println("Pressing the cancel button");
			itemNameJTF.setText("");
			itemSerialNumberJTF.setText("");
			itemLocationJTF.setText("");
			itemValueJTF.setText("");
			itemDescriptionTextArea.setText("");
		}
		
		if (source == attachImageButton)
		{
			
			
		}
		
	}
}
