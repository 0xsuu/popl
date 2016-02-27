
package popl2015.Linda;

public class Hole extends TypedValue 
{
	public Hole(Type t) { type = t; }
	public String toString() { return "?" + type; }
}
