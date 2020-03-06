package view;

import page.Page;
import view.animal.AnimalListCell;
import view.animal.AnimalPage;

import java.util.function.Predicate;

import helper.FXMLSimplifier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.animal.Animal;
import model.animal.AnimalRepository;

public class HomePage extends Page
{
	AnimalRepository _animalRepo = new AnimalRepository();

	@FXML
	TextField searchTextField;
	
	@FXML
	ListView<Animal> animalList;
	FilteredList<Animal> animalFilter;
	
	public HomePage()
	{
		FXMLSimplifier.loadFXML("HomePage.fxml", this);
		
		animalList.setCellFactory((listView) -> new AnimalListCell());
		animalList.setPlaceholder(new Label("No animals found"));
		
		reloadAnimalList();
	}
	
	public void viewButton_Click()
	{
		Animal selected = animalList.getSelectionModel().getSelectedItem();
		
		if (selected == null) { return; }
		
		goToAnimalPage(selected);
	}
	
	public void addButton_Click()
	{
		goToAnimalPage(new Animal());
	}
	
	private void goToAnimalPage(Animal animal)
	{
		AnimalPage page = new AnimalPage(animal);
		page.addReturnEvent((anim) -> animalPageReturn(anim));
		
		navigate(page);
	}
	
	private void animalPageReturn(Animal animal)
	{
		if (animal == null) { return; }
		
		removeSelected();
		_animalRepo.save(animal);
		
		reloadAnimalList();
	}
	
	public void removeButton_Click()
	{
		removeSelected();
		
		reloadAnimalList();
	}
	
	private void removeSelected()
	{
		Animal selected = animalList.getSelectionModel().getSelectedItem();

		if (selected == null) { return; }
		
		_animalRepo.delete(selected);
	}
	
	public void searchTextField_KeyTyped()
	{
		String text = searchTextField.getText().toLowerCase();

		if (text.isEmpty())
		{
			animalFilter.setPredicate(s -> true);
		}
		else
		{
			animalFilter.setPredicate(s -> s.getName().toLowerCase().contains(text));
		}
	}
	
	private void reloadAnimalList()
	{
		ObservableList<Animal> animalObservable = FXCollections.observableArrayList(_animalRepo.load());
		
		Predicate<? super Animal> filter = animalFilter == null ? null : animalFilter.getPredicate();
		animalFilter = new FilteredList<Animal>(animalObservable, filter == null ? s -> true : filter);
		
		animalList.setItems(animalFilter);
	}
}
