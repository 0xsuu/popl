
package popl2015.Linda;

import java.util.*;
import java.util.Random;

public class TupleSpace implements aTupleSpace
{
	private Collection<aTuple> theSpace;
	public TupleSpace()
	{
		theSpace = Collections.synchronizedList(new ArrayList<aTuple>());
	}
	
	//Added this function for easier understanding and less code
	private aTuple fetchTuple(aTemplate t, boolean delete)
	{
		synchronized(theSpace)
		{
			List<Integer> indexPool = new ArrayList<Integer>();
			for (int k = 0; k < theSpace.size(); k++)
			{
				indexPool.add(k);
			}

			while (indexPool.size()>0)
			{
				Random randomGenerator = new Random();
				int randomIndex = randomGenerator.nextInt(indexPool.size());
				int i = indexPool.remove(randomIndex);
				aTuple ti = (aTuple)((List)theSpace).get(i);
				if (t.matches(ti))
				{
					if (delete)
					{
						//Clone the tuple instance using iteration as I have NO ACCESS to the given code to add a copy initialiser
						//Although the efficiency of cloning a vector seems no significant difference
						List<TypedValue> retL = new Vector<TypedValue>();
						for (int j = 0; j < ti.length(); j ++)
						{
							retL.add(ti.nth(j));
						}
						
						//Finally I could construct my very new Tuple
						aTuple ret = new Tuple(retL);
						
						//Remove the old rubbish tuple in the tuple space
						theSpace.remove(ti);
						
						return ret;
					}
					else
					{
						return ti;
					}
				}
			}
		}
		
		return null;
	}
	
	// out(aTuple v) method
	public void out(aTuple v)
	{
		theSpace.add(v);
	}
	
	// in(aTemplate t, aMonoVariable<aTuple> result) method
	public void in(aTemplate t, aMonoVariable<aTuple> result)
	{
		aTuple tp = fetchTuple(t, true);
		while (tp == null)
		{//Blocking
			tp = fetchTuple(t, true);
		}
		result.becomes(tp);
	}
	
	// rd(aTemplate t, aMonoVariable<aTuple> result) method
	public void rd(aTemplate t, aMonoVariable<aTuple> result)
	{
		//Same as in but the argument to pass is false, and that means not deleting the matching tuple
		aTuple tp = fetchTuple(t, false);
		while (tp == null)
		{//Blocking
			tp = fetchTuple(t, false);
		}
		result.becomes(tp);
	}
	
	public String toString() { return "# " + theSpace + " #"; }
}