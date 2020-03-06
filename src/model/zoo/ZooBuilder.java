package model.zoo;
import java.util.ArrayList;

import model.animal.Animal;
import model.food.Food;

public class ZooBuilder
{
	private String _name;
	private String _zooManager;
	private String _address;
	private ArrayList<Food> _food;
	private ArrayList<Animal> _animals;

	public ZooBuilder name(String name)
	{
		_name = name;
		return this;
	}
	
	public ZooBuilder zooManager(String zooManager)
	{
		_zooManager = zooManager;
		return this;
	}

	public ZooBuilder address(String address)
	{
		_address = address;
		return this;
	}

	public ZooBuilder food(ArrayList<Food> food)
	{
		_food = food;
		return this;
	}

	public ZooBuilder animals(ArrayList<Animal> animals)
	{
		_animals = animals;
		return this;
	}
	
	public Zoo build()
	{
		if (_name == null)
		{
			_name = "";
		}
		
		if (_zooManager == null)
		{
			_zooManager = "";
		}
		
		if (_address == null)
		{
			_address = "";
		}
		
		if (_food == null)
		{
			_food = new ArrayList<Food>();
		}
		
		if (_animals == null)
		{
			_animals = new ArrayList<Animal>();
		}
		
		return new Zoo(_name, _zooManager, _address, _food, _animals);
	}
}
