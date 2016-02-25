package popl2015.Linda;

public interface aTupleSpace 
{
	public void out(aTuple v);
	// out places aTuple v into this tuple space, and returns. It does not block.
	public void in(aTemplate t, aMonoVariable<aTuple> result);
	// in removes a tuple from this tuple-space which matches the template t, 
	// according to the Linda tuple-space semantics as described in the
	// assessment text. The matching tuple is placed into the
	// MonoVariable result before returning from the in method.
	public void rd(aTemplate t, aMonoVariable<aTuple> result);
	// rd follows the same semantics as in, except that a matched tuple is not 
	// removed from the tuple-space
}