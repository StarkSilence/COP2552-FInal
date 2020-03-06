package model.io;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Repository<T extends Serializable> 
{
	private ArrayList<T> _values;
	
	protected abstract String getFileName();

	public Repository()
	{
		load();
	}
	
	public ArrayList<T> load()
	{
		if (_values == null)
		{
			_values = readFile();
		}
		
		return new ArrayList<T>(_values);
	}
	
	private ArrayList<T> readFile()
	{
		ArrayList<T> newValues = FileIO.readObject(getFileName());
		
		return newValues == null ? new ArrayList<T>() : newValues;
	}
	
	public void save(T value)
	{
		_values.remove(value);
		_values.add(value);
		
		FileIO.writeObject(getFileName(), _values);
	}
	
	public void delete(T value)
	{
		_values.remove(value);
		
		FileIO.writeObject(getFileName(), _values);
	}
}
