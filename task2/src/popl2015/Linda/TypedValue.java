
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
	{ //Standard Object.equals() semantics
		if(!(o instanceof TypedValue))
		{
			if (o instanceof Hole && ((Hole)o).type == this.type) 
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if (((TypedValue)o).type == this.type && ((TypedValue)o).value == this.value) 
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	public String toString() { return value + ":" + type ; }
}