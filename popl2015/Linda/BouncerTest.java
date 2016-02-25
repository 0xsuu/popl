
package popl2015.Linda; 

public class BouncerTest 
{
	public static void main(String[] args) 
	{
		TupleSpace ts = new TupleSpace();
		Bouncer ping = new Bouncer(ts, "Ping", "Pong", 10); 
		Bouncer pong = new Bouncer(ts, "Pong", "Ping", 10);

		//Start the bouncer processes:
		ping.start();
		pong.start();

		// Tell them to go!
		Tuple go = new Tuple();
		go.add(new TypedValue(TypedValue.Type.String, "Go")); 
		ts.out(go);

		MonoVariable<aTuple> complete = new MonoVariable<aTuple>(); 
		Template gone = new Template();
		gone.add(new Hole(TypedValue.Type.String))
			.add(new TypedValue(TypedValue.Type.String, "done")); 
		System.out.println("Main getting completion tuple 1"); 
		ts.in(gone, complete); 
		System.out.println(complete.consume()); 
		System.out.println("Main getting completion tuple 2"); 
		ts.in(gone, complete); 
		System.out.println(complete.consume());
		
		System.out.println("Main ending");
	}
}