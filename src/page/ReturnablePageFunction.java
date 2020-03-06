package page;

public abstract class ReturnablePageFunction<T> extends PageFunction<T>
{
	public abstract void accept();
	public abstract void cancel();
}
