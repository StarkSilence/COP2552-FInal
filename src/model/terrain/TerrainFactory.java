package model.terrain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TerrainFactory
{
	private static Map<String, Class<? extends Terrain>> _terrains = Map.ofEntries
	(
		newEntry(Desert.class),
		newEntry(Forest.class),
		newEntry(Jungle.class),
		newEntry(Lake.class),
		newEntry(Mountain.class),
		newEntry(Ocean.class),
		newEntry(Plains.class),
		newEntry(River.class),
		newEntry(Savanna.class),
		newEntry(SnowMountain.class),
		newEntry(Swamp.class),
		newEntry(Taiga.class),
		newEntry(Tundra.class)
	);
	
	private static Entry<String, Class<? extends Terrain>> newEntry(Class<? extends Terrain> cls)
	{
		Terrain terrain = createInstance(cls);
		
		return Map.entry(terrain.getName(), cls);
	}
	
	public static Terrain getTerrain(String terrainType)
	{
		Class<? extends Terrain> terrain = _terrains.get(terrainType);
		
		return terrain == null ? null : createInstance(terrain);
	}
	
	private static Terrain createInstance(Class<? extends Terrain> cls)
	{
		try
		{
			return cls.getConstructor().newInstance();
		} 
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public static Set<String> getTerrainTypes()
	{
		return _terrains.keySet();
	}
}
