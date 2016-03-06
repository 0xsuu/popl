
package popl2015.Linda; 

public class BouncerTest 
{
	public static void main(String[] args) 
	{
		// 
		//
		// Single thread testing
		//
		// 

		//
		// Basic Functionality test
		//
		// Output: ./outputTest/singleBasic.txt

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
		// Non-determinism test with feching multiple matched tuples
		//
		// Output: ./outputTest/singleRandomTupleMatch.txt
		/*
		TupleSpace ts = new TupleSpace();

		//Filling the tuple space with integer from 0..99
		for (int i = 0; i < 100; i ++)
		{
			Tuple num = new Tuple();
			num.add(new TypedValue(TypedValue.Type.Integer, i));
			ts.out(num);
			if (i==5||i==62||i==33||i==98)
			{
				Tuple st = new Tuple();
				st.add(new TypedValue(TypedValue.Type.String, Integer.toString(i)));
				ts.out(st);
			}
		}

		//A template that matches all the 100 integer tuples in the tuple space
		Template t1 = new Template();
		t1.add(new Hole(TypedValue.Type.Integer));

		MonoVariable<aTuple> result = new MonoVariable<aTuple>();

		//Get the tuple from the tuple space
		ts.in(t1, result);
		//And see if it is randomly fetched
		System.out.println(result.consume());

		//A template that matches 4 string tuples in the tuple space
		Template t2 = new Template();
		t2.add(new Hole(TypedValue.Type.String));
		int count1=0,count2=0,count3=0,count4=0;
		for (int i = 0; i < 10000; i ++) 
		{
			ts.rd(t2, result);
			String res = (String)result.consume().nth(0).value();
			if (res.equals("5"))
			{
				count1++;
			}
			else if (res.equals("62")) 
			{
				count2++;
			}
			else if (res.equals("33")) 
			{
				count3++;
			}
			else if (res.equals("98"))
			{
				count4++;
			}
		}

		//Get the probabilities for getting 4 different matched tuples, each should be around 0.25
		System.out.println("4 Probabilities are: " + count1/10000.0+ ", " + count2/10000.0 + ", " + count3/10000.0 + ", " + count4/10000.0);
		*/

		//
		//
		// Multi-thread testing
		//
		//

		//
		// MultiThread Bouncing test provided by assignment
		// 
		//
		// Output: ./outputTest/multiBounce.txt
		/*
		TupleSpace ts = new TupleSpace();
		Bouncer ping = new Bouncer(ts, "Ping", "Pong", 4); 
		Bouncer pong = new Bouncer(ts, "Pong", "Ping", 4);

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
		*/
		
		//
		// Multiple threads access same tuple at same time
		//
		//
		
		final TupleSpace ts = new TupleSpace();

		//Two threads try to access the same tuple
		Thread t1 = new Thread()
		{
    		public void run()
    		{
    			Template get = new Template();
    			get.add(new TypedValue(TypedValue.Type.Integer, 0));
    			MonoVariable<aTuple> result = new MonoVariable<aTuple>();
        		ts.rd(get, result);
        		System.out.println("Thread "+Thread.currentThread().getId()+" Got 0");
   			}
   		};

		Thread t2 = new Thread()
		{
    		public void run()
    		{
        		Template get = new Template();
    			get.add(new TypedValue(TypedValue.Type.Integer, 0));
    			MonoVariable<aTuple> result = new MonoVariable<aTuple>();
        		ts.rd(get, result);
        		System.out.println("Thread "+Thread.currentThread().getId()+" Got 0");
    		}
    	};

    	//Start
		t1.start();
		t2.start();

		//Put target tuple in the tuple space, they start at same time
		Tuple num = new Tuple();
		num.add(new TypedValue(TypedValue.Type.Integer, 0));
		ts.out(num);
	}
}