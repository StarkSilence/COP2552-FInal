
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
import model.animal.Animal;
import model.animal.AnimalRepository;
import model.food.Food;
import model.food.FoodRepository;
import model.terrain.Desert;
import view.MainWindow;

/*
 * Chase Wesley
 * 11/25/2019
 * Java v10.0.2
 * COP2552.001/0M1
 * Final Project
 */

@SuppressWarnings("unused")
public class MainWindowTester
{
	public static void main(String[] args)
	{
		AnimalRepository repo = new AnimalRepository();
		
//		ArrayList<Animal> animals = createDefaultAnimals();
//		animals.forEach(a -> repo.save(a));
		
		Application.launch(MainWindow.class, args);
	}
	
	private static ArrayList<Animal> createDefaultAnimals()
	{
		ArrayList<Food> ocelotFood = new ArrayList<Food>();
		ocelotFood.add(new Food("Meat", "Meat", "example vendor", "Pound", .5f));

		ArrayList<Food> frogFood = new ArrayList<Food>();
		frogFood.add(new Food("Crickets", "Crickets", "example vendor", "Individual", 2));
		
		ArrayList<Food> alligatorFood = new ArrayList<Food>();
		alligatorFood.add(new Food("Meat", "Meat", "example vendor", "Pound", 6));
		
		ArrayList<Food> emuFood = new ArrayList<Food>();
		emuFood.add(new Food("Insects", "Crickets, beetles, grasshoppers", "example vendor", "Pound", 1.5f));
		emuFood.add(new Food("Grass", "Grass", "example vendor", "Pound", .5f));
		
		ArrayList<Food> tarantulaFood = new ArrayList<Food>();
		tarantulaFood.add(new Food("Crickets", "Crickets", "example vendor", "Ounce", 2));
		
		ArrayList<Animal> zooAnimals = new ArrayList<Animal>();
		zooAnimals.add(new Animal("Ocelot", "Leopardus pardalis", LocalDate.parse("2012-05-17"), true, false, ocelotFood));
		zooAnimals.add(new Animal("Green and black poison arrow frog", "Dendrobates auratus", LocalDate.parse("2016-08-02"), true, true, frogFood));
		zooAnimals.add(new Animal("American alligator", "Alligator mississippiensis", LocalDate.parse("2010-03-23"), false, false, alligatorFood));
		zooAnimals.add(new Animal("Emu", "Dromaius novaehollandiae", LocalDate.parse("2012-07-05"), true, true, emuFood));
		zooAnimals.add(new Animal("Chilean rose tarantula", "Grammostola rosea", LocalDate.parse("2016-09-19"), false, false, tarantulaFood));
		
		return zooAnimals;
	}
	
	private static ArrayList<Food> createDefaultFood()
	{
		ArrayList<Food> food = new ArrayList<Food>();
		food.add(new Food("Meat", "Meat", "example vendor", "Pound", .5f));
		food.add(new Food("Crickets", "Crickets", "example vendor", "Individual", 2));
		food.add(new Food("Meat", "Meat", "example vendor", "Pound", 6));
		food.add(new Food("Insects", "Crickets, beetles, grasshoppers", "example vendor", "Pound", 1.5f));
		food.add(new Food("Grass", "Grass", "example vendor", "Pound", .5f));
		food.add(new Food("Crickets", "Crickets", "example vendor", "Ounce", 2));
		
		return food;
	}
}
