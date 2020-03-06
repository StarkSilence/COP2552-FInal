package model.animal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import model.food.Food;
import model.terrain.Forest;
import model.terrain.Terrain;

public class Animal implements Serializable
{
	private static final long serialVersionUID = 5156054084967536869L;
	
	private String _name;
	private String _species;
	private LocalDate _birthDate;
	private Boolean _isMale;
	private Boolean _onLoan;
	private Terrain _terrain;
	private ArrayList<Food> _food;
	
	public String getName() { return _name; }
	public void setName(String name) { _name = name; }
	
	public String getSpecies() { return _species; }
	public void setSpecies(String species) { _species = species; }
	
	public LocalDate getBirthDate() { return _birthDate; }
	public void setBirthDate(LocalDate birthDate) { _birthDate = birthDate; }
	
	public Boolean getIsMale() { return _isMale; }
	public void setIsMale(Boolean isMale) { _isMale = isMale; }
	
	public Boolean getOnLoan() { return _onLoan; }
	public void setOnLoan(Boolean onLoan) { _onLoan = onLoan; }
	
	public ArrayList<Food> getFood() { return _food; }
	public void setFood(ArrayList<Food> food) { _food = food; }

	public Terrain getTerrain() { return _terrain; }
	public void setTerrain(Terrain _terrain) { this._terrain = _terrain; }
	
	public Animal()
	{
		this("", "", LocalDate.now(), false, false, new ArrayList<Food>());
	}
	
	public Animal(String name, String species, LocalDate birthDate, Boolean isMale, Boolean onLoan, ArrayList<Food> food)
	{
		this(name, species, birthDate, isMale, onLoan, new Forest(), food);
	}
	
	public Animal(String name, String species, LocalDate birthDate, Boolean isMale, Boolean onLoan, Terrain terrain, ArrayList<Food> food)
	{
		_name = name;
		_species = species;
		_isMale = isMale;
		_birthDate = birthDate;
		_onLoan = onLoan;
		_food = food;
		_terrain = terrain;
	}
}
