package house.beans;

public class InventoryItemBean
{
	private String itemName = null;
	private String itemModel = null;
	private String itemSerialNo = null;
	private String itemLocation = null;
	private int itemValue = 0;
	private String itemDescription = null;
	private String itemAttached = null;
	
	public InventoryItemBean()
	{
		//bean
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getItemModel()
	{
		return itemModel;
	}

	public void setItemModel(String itemModel)
	{
		this.itemModel = itemModel;
	}

	public String getItemSerialNo()
	{
		return itemSerialNo;
	}

	public void setItemSerialNo(String itemSerialNo)
	{
		this.itemSerialNo = itemSerialNo;
	}

	public String getItemLocation()
	{
		return itemLocation;
	}

	public void setItemLocation(String itemLocation)
	{
		this.itemLocation = itemLocation;
	}

	public int getItemValue()
	{
		return itemValue;
	}

	public void setItemValue(int itemValue)
	{
		this.itemValue = itemValue;
	}

	public String getItemDescription()
	{
		return itemDescription;
	}

	public void setItemDescription(String itemDescription)
	{
		this.itemDescription = itemDescription;
	}

	public String getItemAttached()
	{
		return itemAttached;
	}

	public void setItemAttached(String itemAttached)
	{
		this.itemAttached = itemAttached;
	}

	@Override
	public String toString()
	{
		return "InventoryItemBean [itemName=" + itemName + ", itemModel=" + itemModel + ", itemSerialNo=" + itemSerialNo
				+ ", itemLocation=" + itemLocation + ", itemValue=" + itemValue + ", itemDescription=" + itemDescription
				+ ", itemAttached=" + itemAttached + "]";
	}
	
}
