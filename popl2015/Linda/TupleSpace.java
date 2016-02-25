
package popl2015.Linda;

import java.util.*;

public class TupleSpace implements aTupleSpace
{
	private Collection<aTuple> theSpace;
	public TupleSpace()
	{
		//??? Initialisations
	}
	
	// out(aTuple v) method
	public void out(aTuple v)
	{
		//???
	}
	// in(aTemplate t, aMonoVariable<aTuple> result) method
	public void in(aTemplate t, aMonoVariable<aTuple> result)
	{
		//???
	}
	// rd(aTemplate t, aMonoVariable<aTuple> result) method
	public void rd(aTemplate t, aMonoVariable<aTuple> result)
	{
		//???
	}

	public String toString() { return "# " + theSpace + " #"; }
}