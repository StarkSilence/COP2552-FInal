package view.animal;

import javafx.scene.control.ListCell;
import model.animal.Animal;

public class AnimalListCell extends ListCell<Animal>
{
	@Override
	protected void updateItem(Animal item, boolean empty)
	{
		super.updateItem(item, empty);
		
		setText(item != null ? item.getName() : "");
	}
}
