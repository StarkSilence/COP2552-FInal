package model.io;

import java.io.*;

public class FileIO
{
	private FileIO() { }
	
	public static <T> void writeObject(String path, T object)
	{
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)))
		{
			out.writeObject(object);
		}
		catch (FileNotFoundException e)
		{
			createNewFile(path);
			writeObject(path, object);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T readObject(String path)
	{
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path)))
		{
			return (T)in.readObject();
		}
		catch (Exception e)
		{
			System.out.printf("File at '%s' not found!\n", path);
			return null;
		}
	}
	
	private static void createNewFile(String path)
	{
		try 
		{
			File file = new File(path);
			file.createNewFile();
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}
}
