package helper;

import javafx.fxml.FXMLLoader;

import java.net.URL;

public class FXMLSimplifier
{
	private FXMLSimplifier() { }
	
	public static void loadFXML(String fileName, Object root)
	{
		URL url = root.getClass().getResource(fileName);

		FXMLLoader fxmlLoader = new FXMLLoader(url);
		fxmlLoader.setRoot(root);
		fxmlLoader.setController(root);
		
		try
		{
			fxmlLoader.load();
		} 
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
