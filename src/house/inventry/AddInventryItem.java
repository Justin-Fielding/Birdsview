package house.inventry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import house.beans.InventoryItemBean;
import house.birdsview.Birdsview;
import house.birdsview.MainPage;


public class AddInventryItem extends JPanel implements ActionListener
{
	final static Logger logger = Logger.getLogger(AddInventryItem.class);
	private JButton submitButton = null, cancelButton = null;
	private JPanel panelNorth = null, panelSouth = null, panelCentre = null;
	private JLabel headingLabel = null, itemNameLabel = null, itemDescriptionLabel = null, itemSerialNumberLabel = null, itemLocationLabel = null, itemValueLabel = null;
	private JLabel inventoryLabel = null, itemCountLabel = null;
	private JTextField itemNameJTF = null, itemSerialNumberJTF = null, itemLocationJTF = null, itemValueJTF = null;
	private JTextArea itemDescriptionTextArea = null;
	private JScrollPane scrollPane = null;
	private Birdsview basePanel = null;
	private JButton attachmentButton;
	private JLabel attachmentLabel;
	private JFileChooser fileChooser = null;
	private JComboBox itemLocation = null;
	private JLabel itemModelLabel;
	private JTextField itemModelJTF;
	private String loggerPrefix = "AddInventoryItem Class Message - ";
		
	public AddInventryItem(Birdsview frame)
	{
		PropertyConfigurator.configure("log4j.properties");
		this.basePanel = frame;
		this.setupScreen();
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
	}
	
	public void setupScreen()
	{
		panelNorth = new JPanel();
			inventoryLabel = new JLabel("28 Birdsview Eco Estate Inventory");
			inventoryLabel.setFont(new Font("Calibri", Font.BOLD, 16));
			panelNorth.add(inventoryLabel);
		
//		panelSouth = new JPanel();
//		panelSouth.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null));
//		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//			itemCountLabel = new JLabel("Number of Items: ");
//			itemCountLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
//			panelSouth.add(itemCountLabel);
		
		panelCentre = new JPanel();
		panelCentre.setLayout(null);
		
			headingLabel = new JLabel("NEW ITEM FOR INVENTORY");
			headingLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
			headingLabel.setBounds(300, 45, 200, 20);
			panelCentre.add(headingLabel);
		
			itemModelLabel = new JLabel("Item Model");
			itemModelLabel.setBounds(250, 118, 100, 14);
			panelCentre.add(itemModelLabel);
			
			itemModelJTF = new JTextField();
			itemModelJTF.setBounds(414, 118, 150, 20);
			panelCentre.add(itemModelJTF);
			itemModelJTF.setColumns(10);
			
			itemNameJTF = new JTextField();
			itemNameJTF.setBounds(415, 87, 150, 20);
			panelCentre.add(itemNameJTF);
			itemNameJTF.setColumns(10);
			
			itemSerialNumberJTF = new JTextField();
			itemSerialNumberJTF.setBounds(415, 149, 150, 20);
			panelCentre.add(itemSerialNumberJTF);
			itemSerialNumberJTF.setColumns(10);
			
			itemNameLabel = new JLabel("Item Name");
			itemNameLabel.setBounds(250, 87, 100, 14);
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
			
			itemLocation = new JComboBox(basePanel.data_locationList);
			itemLocation.setBounds(415, 180, 150, 20);
			panelCentre.add(itemLocation);
			
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
		setLayout(new BorderLayout(0, 0));
		
		
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelCentre, BorderLayout.CENTER);
		
		attachmentButton = new JButton("Attachment");
		attachmentButton.setBounds(250, 355, 90, 25);
		panelCentre.add(attachmentButton);
		attachmentButton.addActionListener(this);
		
		attachmentLabel = new JLabel("Default");
		attachmentLabel.setBounds(415, 355, 150, 25);
		panelCentre.add(attachmentLabel);
		
//		this.add(panelSouth, BorderLayout.SOUTH);
		basePanel.setupSouthPanel();
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
			logger.info("Pressing the Submit button");
			logger.info("Name: " + itemNameJTF.getText() + "\nModel No: " + itemModelJTF.getText() + "\nSerial No: " + itemSerialNumberJTF.getText()
			+ "\nItem Location: " + itemLocation.getSelectedItem() + "\nItem Value: " + itemValueJTF.getText() + "\nItem Description: "	+ 
					itemDescriptionTextArea.getText() + "\nItemAttached: " + attachmentLabel.getText());
			
			InventoryItemBean tempItem = new InventoryItemBean();
			tempItem.setItemName(itemNameJTF.getText());
			tempItem.setItemModel(itemModelJTF.getText());
			tempItem.setItemSerialNo(itemSerialNumberJTF.getText());
			tempItem.setItemLocation(itemLocation.getSelectedItem().toString());
			tempItem.setItemValue(Integer.parseInt(itemValueJTF.getText()));
			tempItem.setItemDescription(itemDescriptionTextArea.getText());
			tempItem.setItemAttached(attachmentLabel.getText());
			
			basePanel.dao.addInventoryItem(tempItem);
			logger.info(loggerPrefix + tempItem);
		}
		
		if (source == cancelButton)
		{
			logger.info("Pressing the cancel button");
			itemNameJTF.setText("");
			itemModelJTF.setText("");
			itemSerialNumberJTF.setText("");
			itemLocation.setSelectedIndex(0);
			itemValueJTF.setText("");
			itemDescriptionTextArea.setText("");
			attachmentLabel.setText("");
			MainPage mainPage = new MainPage(basePanel);
			basePanel.changeBasePanel(mainPage);
		}
		
		if (source == attachmentButton)
		{
			fileChooser = new JFileChooser("C:\\Users\\a124788\\Pictures");
			fileChooser.showOpenDialog(this);
			File fileName = fileChooser.getSelectedFile();
			String file = fileName.getName();
			try
			{
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
								
				br.close();
				fr.close();
				
				attachmentLabel.setText(file);
			} catch (FileNotFoundException e1)
			{
				JOptionPane.showMessageDialog(this, "File not Found. Did not open");
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NullPointerException e1)
			{
				
			}
		}
		
	}
}
