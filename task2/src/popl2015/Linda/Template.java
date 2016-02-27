
package popl2015.Linda;

import java.util.*;

public class Template implements aTemplate
{
	private List<TypedValue> elements;
	
	public Template(){ elements = new Vector<TypedValue>(); }
	public Template(List<TypedValue> es) { elements = es; }
	
	public boolean matches(aTuple t)
	{
		if (t instanceof aTemplate)
		{
			return true;
		}
		else
		{
			return false;//
		}
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
