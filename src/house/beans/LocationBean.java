package house.beans;

public class LocationBean
{
	private int locationID = 0;
	private String locationName = null;
	
	public LocationBean()
	{
		//bean
	}
	
	public int getLocationID()
	{
		return this.locationID;
	}
	
	public void setLocationID(int inLocationID)
	{
		this.locationID = inLocationID;
	}

	public String getLocationName()
	{
		return this.locationName;
	}

	public void setLocationName(String inLocationName)
	{
		this.locationName = inLocationName;
	}

	@Override
//	public String toString()
//	{
//		return "LocationBean [locationID=" + locationID + ", locationName=" + locationName + "]";
//	}
	
	public String toString()
	{
		return locationName;
	}
}
