package view.animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import helper.FXMLSimplifier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.animal.Animal;
import model.food.Food;
import model.terrain.Terrain;
import model.terrain.TerrainFactory;
import page.ReturnablePageFunction;
import view.food.FoodListCell;
import view.food.FoodPage;

public class AnimalPage extends ReturnablePageFunction<Animal>
{
	@FXML
	TextField nameTextField;
	@FXML
	TextField speciesTextField;
	@FXML
	DatePicker birthDateDatePicker;
	@FXML
	CheckBox isMaleCheckBox;
	@FXML
	CheckBox onLoanCheckBox;
	@FXML
	ComboBox<String> terrainComboBox;
	@FXML
	Label terrainDescriptionLabel;
	
	@FXML
	TextField searchTextField;
	@FXML
	Button viewButton;
	@FXML
	Button addButton;
	@FXML
	Button removeButton;
	@FXML
	ListView<Food> foodList;
	ObservableList<Food> foodObservable;
	FilteredList<Food> foodFilter;
	
	public AnimalPage(Animal animal)
	{
		FXMLSimplifier.loadFXML("AnimalPage.fxml", this);

		setTerrainComboBoxItems();
		foodList.setCellFactory(value -> new FoodListCell());
		foodList.setPlaceholder(new Label("No food found"));
		
		if (animal == null) { return; }

		reloadFoodList(animal.getFood());
		setControlValues(animal);
	}
	
	private void setTerrainComboBoxItems()
	{
		ObservableList<String> terrains = FXCollections.observableArrayList();
		terrains.addAll(TerrainFactory.getTerrainTypes());
		
		terrainComboBox.setItems(terrains);
	}
	
	private void setControlValues(Animal animal)
	{
		nameTextField.setText(animal.getName());
		speciesTextField.setText(animal.getSpecies());
		birthDateDatePicker.setValue(animal.getBirthDate());
		isMaleCheckBox.setSelected(animal.getIsMale());
		onLoanCheckBox.setSelected(animal.getOnLoan());
		
		terrainComboBox.getSelectionModel().select(animal.getTerrain().getName());
		terrainDescriptionLabel.setText(animal.getTerrain().toString());
	}

	@Override
	public void accept()
	{
		String name = nameTextField.getText();
		String species = speciesTextField.getText();
		LocalDate birthDate = birthDateDatePicker.getValue();
		Boolean isMale = isMaleCheckBox.isSelected();
		Boolean onLoan = onLoanCheckBox.isSelected();
		Terrain terrain = getSelectedTerrain();
		ArrayList<Food> food = new ArrayList<>(foodList.getItems());
		
		onReturn(new Animal(name, species, birthDate, isMale, onLoan, terrain, food));
	}

	@Override
	public void cancel()
	{
		onReturn(null);
	}
	
	public void viewButton_Click()
	{
		Food selected = foodList.getSelectionModel().getSelectedItem();
		
		if (selected == null) { return; }
		
		goToFoodPage(selected);
	}
	
	public void addButton_Click()
	{
		goToFoodPage(new Food());
	}
	
	private void goToFoodPage(Food food)
	{
		FoodPage page = new FoodPage(food);
		page.addReturnEvent((f) -> foodPageReturn(f));
		
		navigate(page);
	}
	
	private void foodPageReturn(Food food)
	{
		if (food == null) { return; }

		removeSelected();
		foodObservable.add(food);
	}
	
	public void removeButton_Click()
	{
		removeSelected();
	}
	
	private void removeSelected()
	{
		Food selected = foodList.getSelectionModel().getSelectedItem();
		
		foodObservable.remove(selected);
	}
	
	public void terrainComboBox_Changed()
	{
		terrainDescriptionLabel.setText(getSelectedTerrain().toString());
	}
	
	private Terrain getSelectedTerrain()
	{
		String selected = terrainComboBox.getSelectionModel().getSelectedItem();
		
		return TerrainFactory.getTerrain(selected);
	}
	
	public void searchTextField_KeyTyped()
	{
		String text = searchTextField.getText().toLowerCase();

		if (text.isEmpty())
		{
			foodFilter.setPredicate(s -> true);
		}
		else
		{
			foodFilter.setPredicate(s -> s.getName().toLowerCase().contains(text));
		}
	}
	
	private void reloadFoodList(List<Food> food)
	{
		foodObservable = FXCollections.observableArrayList(food);
		
		Predicate<? super Food> filter = foodFilter == null ? null : foodFilter.getPredicate();
		foodFilter = new FilteredList<Food>(foodObservable, filter == null ? s -> true : filter);
		
		foodList.setItems(foodFilter);
	}
}
