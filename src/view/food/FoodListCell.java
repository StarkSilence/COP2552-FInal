package view.food;

import javafx.scene.control.ListCell;
import model.food.Food;

public class FoodListCell extends ListCell<Food>
{
	@Override
	protected void updateItem(Food item, boolean empty)
	{
		super.updateItem(item, empty);
		
		setText(item != null ? item.getName() : "");
	}
}
