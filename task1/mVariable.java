
//package task1;
//import task1.aMonoVariable;

public class mVariable<T> implements aMonoVariable<T>
{
	private T storage;
	private boolean occupied;
	
	public void becomes(T val)
	{
		//Valid checking
		if (val==null)
		{
			System.out.println("Input not valid, nothing changed, abort.");
			return;
		}
		
		//Occupation block
		while (occupied)
		{
			//Occupied, blocking
		}
		
		//Not occupied, import data
		storage = val;
		occupied = true; //Set semaphore to occupied
	}
	
	public T consume()
	{
		//Occupation block
		while (!occupied)
		{
			//Unoccupied, blocking
		}
		
		//Occupied, consume it
		T tmp = storage;
		storage = null;
		occupied = false;
		
		return tmp;
	}
}