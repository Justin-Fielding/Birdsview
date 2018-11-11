package house.birdsview;

import javax.swing.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.awt.GridLayout;

public class MainPage extends JPanel
{
	final static Logger logger = Logger.getLogger(MainPage.class);
	private Birdsview basePanel = null;
	private JPanel panelCenter = null;
	private JLabel backgroundImage = null;
	private String loggerPrefix = "MainPage Class Message - ";
	/**
	 * Create the panel.
	 */
	public MainPage(Birdsview frame)
	{
		PropertyConfigurator.configure("log4j.properties");
		this.basePanel = frame;
		setLayout(new GridLayout(0, 1, 0, 0));
		
		logger.info(loggerPrefix + "Loading Main Page image");
		panelCenter = new JPanel();
		
		backgroundImage = new JLabel(new ImageIcon("resources/MainPage.JPG"));
		
		panelCenter.add(backgroundImage);
		this.add(panelCenter);
		this.setSize(600, 800);
	}

}
