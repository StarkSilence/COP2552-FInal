package page;

import javafx.scene.layout.BorderPane;

public class Page extends BorderPane
{
	public Page()
	{
		
	}
	
	public void back()
	{
		PageFrame frame = getFrame();
		
		frame.back();
	}
	
	public void navigate(Page to)
	{
		PageFrame frame = getFrame();
		
		frame.navigate(to);
	}
	
	protected PageFrame getFrame()
	{
		return (PageFrame)getParent();
	}
}
