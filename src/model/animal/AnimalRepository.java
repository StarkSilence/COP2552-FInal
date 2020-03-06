package model.animal;

import model.io.Repository;

public class AnimalRepository extends Repository<Animal>
{
	protected String getFileName()
	{
		return "animals";
	}
}
