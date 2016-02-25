
package popl2015.Linda;

import java.util.*;

public class Template implements aTemplate
{
	private List<TypedValue> elements;
	
	public Template()
	{
		//elements = //??? initialisation
	}
	
	public Template(List<TypedValue> es) { elements = es; }
	
	public boolean matches(aTuple t)
	{
		//??? implmentation code
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
