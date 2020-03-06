package view;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;

public class MainWindow extends Application
{
	public static Random random = new Random();
	
	@Override
	public void start(Stage arg0) throws Exception
	{
		MainWindowPage mainPage = new MainWindowPage();
		Scene scene = new Scene(mainPage, 750, 400);
    	
		Stage stage = new Stage();
    	stage.setTitle("COP2552 Project 3");
    	stage.setMinHeight(400);
    	stage.setMinWidth(735);
    	stage.setScene(scene);
    	stage.show();
	}
}
