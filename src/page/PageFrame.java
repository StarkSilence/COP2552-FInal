package page;

import java.util.ArrayList;
import java.util.Stack;


import helper.FXMLSimplifier;
import javafx.scene.layout.BorderPane;

public class PageFrame extends BorderPane
{
	private ArrayList<Runnable> _navigating = new ArrayList<Runnable>();
	private ArrayList<Runnable> _navigated = new ArrayList<Runnable>();
	
	private Stack<Page> _pages = new Stack<>();
	
	public PageFrame()
	{
		FXMLSimplifier.loadFXML("PageFrame.fxml", this);
	}
	
	public int getPageCount()
	{
		return _pages.size();
	}
	
	public Page getCurrentPage()
	{
		return _pages.peek();
	}
	
	public void back()
	{
		_navigating.forEach(r -> r.run());
		
		_pages.pop();
		goTo(_pages.peek());
	}
	
	public void navigate(Page page)
	{
		_navigating.forEach(r -> r.run());
		
		_pages.add(page);
		goTo(page);
	}
	
	private void goTo(Page page)
	{
		getChildren().clear();

		setCenter(page);
		
		_navigated.forEach(r -> r.run());
	}
	
	public void addNavigatingEvent(Runnable r)
	{
		_navigating.add(r);
	}
	
	public void addNavigatedEvent(Runnable r)
	{
		_navigated.add(r);
	}
}
