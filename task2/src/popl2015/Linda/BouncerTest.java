
package popl2015.Linda; 

public class BouncerTest 
{
	public static void main(String[] args) 
	{
		//
		// Single thread testing
		//
		/*
		//Initialise tuple space
		TupleSpace ts = new TupleSpace();
		//Result stores here
		MonoVariable<aTuple> complete = new MonoVariable<aTuple>(); 

		for (int i = 0; i < 10; i ++)
		{
			System.out.println("Sending Ping");
			Tuple ping = new Tuple();
			ping.add(new TypedValue(TypedValue.Type.String, "Ping")); 
			ts.out(ping);

			System.out.println("Make response to Ping");
			Tuple tp = new Tuple();
			tp.add(new TypedValue(TypedValue.Type.String, "Response"))
			  .add(new TypedValue(TypedValue.Type.String, "Pong")); 
			ts.out(tp);

			Template pong = new Template();
			pong.add(new Hole(TypedValue.Type.String))
				.add(new TypedValue(TypedValue.Type.String, "Pong")); 
			ts.in(pong, complete);

			System.out.println("Comfirm received: "+complete.consume());
		}
		*/

		//
		// Multi-thread testing
		//

		TupleSpace ts = new TupleSpace();
		Bouncer ping = new Bouncer(ts, "Ping", "Pong", 1); 
		Bouncer pong = new Bouncer(ts, "Pong", "Ping", 1);

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