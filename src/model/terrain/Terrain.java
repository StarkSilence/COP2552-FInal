package model.terrain;

import java.io.Serializable;

public class Terrain implements Serializable
{
	private static final long serialVersionUID = 5924337868302311909L;
	
	private final String _name;
	private final String _climate;
	private final String _topography;
	private final int _averageTemperature;
	
	public String getName() { return _name; }
	public String getClimate() { return _climate; }
	public String getTopography() { return _topography; }
	public int getAverageTemperature() { return _averageTemperature; }
	
	public Terrain()
	{
		this("", "", "", 0);
	}
	
	public Terrain(String name, String climate, String topography, int averageTemperature)
	{
		_name = name;
		_climate = climate;
		_topography = topography;
		_averageTemperature = averageTemperature;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		addLine(sb, "Name: " + _name);
		addLine(sb, "Climate: " + _climate);
		addLine(sb, "Topography: " + _topography);
		addLine(sb, "Average Temperature: " + _averageTemperature);
		
		return sb.toString();
	}
	
	protected void addLine(StringBuilder sb, String line)
	{
		sb.append(line);
		sb.append('\n');
	}
}
