package model.terrain;

import java.io.Serializable;

public class Desert extends Terrain implements Serializable
{
	private static final long serialVersionUID = 5194738000754903531L;

	public Desert()
	{
		super("Desert", "Desert Climate", "Desert Topography", 80);
	}
}
