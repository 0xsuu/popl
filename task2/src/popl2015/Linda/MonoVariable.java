
package popl2015.Linda;

//Implementation of MonoVariable

public class MonoVariable<T> implements aMonoVariable<T>
{
	private T storage;
	private boolean occupied;
	
	public synchronized void becomes(T val)
	{
		//Validation checking
		if (val==null)
		{
			System.out.println("Input not valid, nothing changed, abort.");
			return;
		}
		
		//Occupied, blocking
		while (occupied)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		//Not occupied, import(or override) data
		storage = val;
		occupied = true; //Set to occupied
		
		notify();
	}
	
	public synchronized T consume()
	{
		//Unoccupied, blocking
		while (!occupied)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		//Occupied, consume it
		occupied = false;
		notify();
		
		return storage;
	}
}