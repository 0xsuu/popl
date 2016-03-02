
package popl2015.Linda;

import java.util.*;

public class Tuple implements aTuple 
{
	private List<TypedValue> elements;

	public Tuple() { elements = new Vector<TypedValue>(); }
	public Tuple(List<TypedValue> es) { elements = es; }

	public TypedValue nth(int n)
	{
		if( n < 0 || n >= elements.size()) return null;
		else return elements.get(n);
	}

	public int length() 
	{
		return elements.size(); 
	}

	public aTuple add(TypedValue v) 
	{ 
		elements.add(v);
		return this;
	}
	
	public String toString() { return "<" + elements + ">"; }
}
