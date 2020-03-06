package model.zoo;

import java.io.Serializable;
import java.util.ArrayList;

import model.animal.Animal;
import model.food.Food;

public class Zoo implements Serializable
{
	private static final long serialVersionUID = -8168097031977321580L;
	
	private String _name;
	private String _zooManager;
	private String _address;
	private ArrayList<Food> _food;
	private ArrayList<Animal> _animals;
	
	public String getName() { return _name; }
	public void setName(String name) { _name = name; }
	
	public String getZooManager() { return _zooManager; }
	public void setZooManager(String zooManager) { _zooManager = zooManager; }
	
	public String getAddress() { return _address; }
	public void setAddress(String address) { _address = address; }
	
	public ArrayList<Food> getFood() { return _food; }
	public void setFood(ArrayList<Food> food) { _food = food; }
	
	public ArrayList<Animal> getAnimals() { return _animals; }
	public void setAnimals(ArrayList<Animal> animals) { _animals = animals; }
	
	public Zoo(String name, String zooManager, String address, ArrayList<Food> food, ArrayList<Animal> animals)
	{
		_name = name;
		_zooManager = zooManager;
		_address = address;
		_food = food;
		_animals = animals;
	}
}
