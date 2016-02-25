
package popl2015.Linda;

public class TypedValue
{
	public static enum Type{ Integer, Float, String, Bool, Null };
	private Object value;
	protected Type type;
	
	public TypedValue() { type = Type.Null; value = null;}
	public TypedValue(Type t, Object v ) { type = t; value = v; }

	public Object value() { return value; } 
	public Type type() { return type; }

	public boolean equals(Object o)
	{ //Standard Oject.equals() semantics
		if(!(o instanceof TypedValue))
		{
			//??? Code to be inserted
			return false;
		}
		else
		{
			//??? Code to be inserted
			return true;
		}
	}

	public String toString() { return value + ":" + type ; }
}