
package popl2015.Linda;

public interface aTuple
{
	public TypedValue nth(int n);
	// nth returns the element n of the tuple,
	// where 0 is the first element.
	
	public int length();
	//length returns the number of elements in the tuple
	
	public aTuple add(TypedValue v);
	//add updates this tuple by appending the TypedValue v to the end of the tuple,
	//returning the updated tuple.
}