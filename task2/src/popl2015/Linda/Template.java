
package popl2015.Linda;

import java.util.*;

public class Template implements aTemplate
{
	private List<TypedValue> elements;
	
	public Template(){ elements = new Vector<TypedValue>(); }
	public Template(List<TypedValue> es) { elements = es; }
	
	public boolean matches(aTuple t)
	{
		//Examine tuple length
		if (t.length() != this.length()) 
		{
			return false;
		}

		//Traverse this template
		for (int i = 0; i < this.length(); i++)
		{
			TypedValue tSelf = this.nth(i);
			TypedValue tArg = t.nth(i);

			if (!tArg.equals(tSelf)) return false;
		}

		return true;
	}
	
	public TypedValue nth(int n)
	{
		if (n < 0 || n >= elements.size()) return null;
		else return elements.get(n);
	}
	
	public aTemplate add(TypedValue v) { elements.add(v); return this; }
	public int length() { return elements.size(); }
	public String toString() { return "<| " + elements + " |>"; }
}
