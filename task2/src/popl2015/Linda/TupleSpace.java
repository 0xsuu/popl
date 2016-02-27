
package popl2015.Linda;

import java.util.*;

public class TupleSpace implements aTupleSpace
{
	private Collection<aTuple> theSpace;
	public TupleSpace()
	{
		theSpace = new Vector<aTuple>();
	}

	// out(aTuple v) method
	public void out(aTuple v)
	{
		theSpace.add(v);
	}
	// in(aTemplate t, aMonoVariable<aTuple> result) method
	public void in(aTemplate t, aMonoVariable<aTuple> result)
	{
		// ???
		result.becomes(t);
	}
	// rd(aTemplate t, aMonoVariable<aTuple> result) method
	public void rd(aTemplate t, aMonoVariable<aTuple> result)
	{
		// ???
		result.becomes(t);
	}

	public String toString() { return "# " + theSpace + " #"; }
}