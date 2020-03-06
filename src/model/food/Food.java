package model.food;

import java.io.Serializable;

public class Food implements Serializable
{
	private static final long serialVersionUID = 3965378153421150246L;
	
	private String _name;
	private String _description;
	private String _vendor;
	private String _unit;
	private float _quantity;
	
	public String getName() { return _name; }
	public void setName(String name) { _name = name; }
	
	public String getDescription() { return _description; }
	public void setDescription(String description) { _description = description; }
	
	public String getVendor() { return _vendor; }
	public void setVendor(String vendor) { _vendor = vendor; }
	
	public String getUnit() { return _unit; }
	public void setUnit(String unit) { _unit = unit; }
	
	public float getQuantity() { return _quantity; }
	public void setQuantity(float quantity) { _quantity = quantity; }
	
	public Food()
	{
		this("", "", "", "", 0);
	}
	
	public Food(String name, String description, String vendor, String unit, float quantity)
	{
		_name = name;
		_description = description;
		_vendor = vendor;
		_unit = unit;
		_quantity = quantity;
	}
}
