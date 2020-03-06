package view;


import helper.FXMLSimplifier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import page.*;

public class MainWindowPage extends BorderPane
{
	@FXML
	private PageFrame pageFrame;
	
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button exitButton;
	
	public MainWindowPage()
	{
		FXMLSimplifier.loadFXML("MainWindowPage.fxml", this);
		
		pageFrame.addNavigatingEvent(() -> pageFrame_Navigating());
		pageFrame.addNavigatedEvent(() -> pageFrame_Navigated());
		
		pageFrame.navigate(new HomePage());
	}
	
	public void okButton_Click()
	{
		ReturnablePageFunction<?> page = getReturnablePage();
		
		if (page != null)
		{
			page.accept();
		}
	}
	
	public void cancelButton_Click()
	{
		ReturnablePageFunction<?> page = getReturnablePage();
		
		if (page != null)
		{
			page.cancel();
		}
	}
	
	private ReturnablePageFunction<?> getReturnablePage()
	{
		Page currentPage = pageFrame.getCurrentPage();

		if (currentPage instanceof ReturnablePageFunction)
		{
			return (ReturnablePageFunction<?>)currentPage;
		}
		
		return null;
	}
	
	public void exitButton_Click()
	{
		System.exit(0);
	}
	
	private void pageFrame_Navigating() 
	{
		
	}
	
	private void pageFrame_Navigated()
	{
		System.out.println("Page count: " + pageFrame.getPageCount());
		showExitButton(pageFrame.getPageCount() == 1);
	}
	
	private void showExitButton(Boolean show)
	{
		okButton.setVisible(!show);
		okButton.setManaged(!show);
		
		cancelButton.setVisible(!show);
		cancelButton.setManaged(!show);
		
		exitButton.setVisible(show);
	}
}
