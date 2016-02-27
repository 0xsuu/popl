
package popl2015.Linda;

import java.util.*;

public class MonoVariable<T> implements aMonoVariable<T>
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
		
		//Not occupied, import(or override) data
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
		occupied = false;
		
		return storage;
	}
}