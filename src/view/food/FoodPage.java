package view.food;

import model.food.Food;
import page.ReturnablePageFunction;

import java.util.function.UnaryOperator;

import helper.FXMLSimplifier;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

public class FoodPage extends ReturnablePageFunction<Food>
{
	@FXML
	TextField nameTextField;
	@FXML
	TextField descriptionTextField;
	@FXML
	TextField vendorTextField;
	@FXML
	TextField unitTextField;
	@FXML
	TextField quantityTextField;
	
	public FoodPage(Food food)
	{
		FXMLSimplifier.loadFXML("FoodPage.fxml", this);
		
		setQuantityTextFieldFormatter();
		
		if (food == null)
		{
			return;
		}
		
		setControlValues(food);
	}
	
	private void setQuantityTextFieldFormatter()
	{
		UnaryOperator<Change> floatFilter = change ->
		{
			if (change.getControlNewText().matches("\\d*\\.?\\d*"))
			{
				return change;
			}
			
			return null;
		};
		
		quantityTextField.setTextFormatter(new TextFormatter<Float>(floatFilter));
	}
	
	private void setControlValues(Food food)
	{
		nameTextField.setText(food.getName());
		descriptionTextField.setText(food.getDescription());
		vendorTextField.setText(food.getVendor());
		unitTextField.setText(food.getUnit());
		quantityTextField.setText(String.valueOf(food.getQuantity()));
	}

	@Override
	public void accept()
	{
		String name = nameTextField.getText();
		String description = descriptionTextField.getText();
		String vendor = vendorTextField.getText();
		String unit = unitTextField.getText();
		
		float quantity = 0;
		
		String quantityText = quantityTextField.getText();
		if (!quantityText.isEmpty())
		{
			quantity = Float.parseFloat(quantityText);
		}
		
		onReturn(new Food(name, description, vendor, unit, quantity));
	}

	@Override
	public void cancel()
	{
		onReturn(null);
	}
}
