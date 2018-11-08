package house.dao;

import java.sql.*;
import java.util.Vector;
import org.apache.log4j.Logger;

import house.beans.InventoryItemBean;
import house.beans.LocationBean;

public class DAO
{
	final static Logger logger = Logger.getLogger(DAO.class);
	private Connection con  = null;
	private Statement sqlstat = null;
	private PreparedStatement ps = null;
	private String url = "jdbc:mysql://localhost:3306/birdsview";
	private String user = "root";
	private String psw = "root";
	private ResultSet rs = null;
	private String loggerPrefix = "DAO Class messages - ";
	private Vector<LocationBean> tempLocation = null;
		
		
		
		public DAO() throws Exception
		{
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, psw);	
			} 
			catch (ClassNotFoundException e)
			{
				logger.error(loggerPrefix + "No Driver found");
				return;
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			
			logger.info(loggerPrefix + "Connected to DB");
			
			sqlstat = con.createStatement();
//			rs = sqlstat.executeQuery("Select * from item_location");

		}	
		
		public Vector<LocationBean> getLocations()
		{
			tempLocation = new Vector<LocationBean>();
	        try
	        {
	        	rs = sqlstat.executeQuery("Select * from item_location");
	        
	        	while(rs.next())
	        	{
	        		LocationBean temp = new LocationBean();
					temp.setLocationID(rs.getInt("locationID"));
					temp.setLocationName(rs.getString("locationName"));
					
					tempLocation.add(temp);
					logger.info(loggerPrefix + temp);
	        	}
	        } 
	        catch (SQLException e)
	        {
	        	e.printStackTrace();
	        	return null;
	        }
	        return tempLocation;
		}
		
		public int getItemLocationID(String inItemLocationName)
		{
			try
			{
				rs = sqlstat.executeQuery("Select * from item_location");
				
				while(rs.next())
				{
					if (inItemLocationName.equals(rs.getString("locationName")))
					{
						return rs.getInt("locationID");
					}
					
				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		public boolean addInventoryItem(InventoryItemBean inItem)
		{
			try
			{
				ps = con.prepareStatement("INSERT INTO item_inventory VALUES (null, ?, ?, ?, ?, ?, ?, ?)");
				ps.setString(1, inItem.getItemName());
				ps.setString(2, inItem.getItemModel());
				ps.setString(3, inItem.getItemSerialNo());
				ps.setInt(4, this.getItemLocationID(inItem.getItemLocation()));// fix to convert location name to ID
				ps.setInt(5, inItem.getItemValue());
				ps.setString(6, inItem.getItemDescription());
				ps.setString(7, inItem.getItemAttached());
				
				ps.execute();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
				
		public void closeDB()
		{
			  try
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}		
		}
		

}
