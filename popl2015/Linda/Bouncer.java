
package popl2015.Linda;

public class Bouncer extends Thread 
{
	private String response; 
	private String greeting; 
	private int times;
	private TupleSpace tuplespace;

	public Bouncer(TupleSpace ts, String i, String o, int t) 
	{ 
		response = i; 
		greeting = o; 
		times = t;
		tuplespace = ts;
	}

	public void run() 
	{
		MonoVariable<aTuple> result = new MonoVariable<aTuple>(); 
		Tuple tuple;
		Template templ;
		//
        System.out.println(greeting + " started");
        // Wait until the ’go’ tuple is available:
		templ = new Template();
		templ.add(new TypedValue(TypedValue.Type.String, "Go")); 
		tuplespace.rd(templ, result);
		result.consume(); // Clear out the result variable for later use.

		for(int i=0; i<times; i++) 
		{ // Send the out string
			tuple = new Tuple();
			tuple.add(new TypedValue(TypedValue.Type.String, greeting)); 
			tuplespace.out(tuple);
			//get the in string
			templ = new Template();
			templ.add(new TypedValue(TypedValue.Type.String, response)); 
			tuplespace.in(templ, result);
			// Show prgress
			System.out.println("Got: " + result.consume() + "number " + (i+1));
		}

		tuple = new Tuple();
		tuple.add(new TypedValue(TypedValue.Type.String, greeting))
			.add(new TypedValue(TypedValue.Type.String, "done")); tuplespace.out(tuple);
	}
}
