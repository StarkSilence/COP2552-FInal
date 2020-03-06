package model.food;

import model.io.Repository;

public class FoodRepository extends Repository<Food>
{
	protected String getFileName()
	{
		return "food";
	}
}
