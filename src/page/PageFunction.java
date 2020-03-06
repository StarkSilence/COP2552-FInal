package page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class PageFunction<T> extends Page
{
	private List<Consumer<T>> _handlers = new ArrayList<>();
	
	protected void onReturn(T value)
	{
		_handlers.forEach(handler -> handler.accept(value));
		
		back();
	}
	
	public void addReturnEvent(Consumer<T> handler)
	{
		_handlers.add(handler);
	}
}
