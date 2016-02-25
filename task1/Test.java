
public class Test extends Thread
{
	private static interface Arithmetic
	{
		public int calculate(int val);
	}
	
	private static class Adder implements Arithmetic
	{
		public int calculate(int val)
		{
			return val+1;
		}
	}
	private static class Multiplier implements Arithmetic
	{
		public int calculate(int val)
		{
			return val*2;
		}
	}
	
	aMonoVariable<Integer> testM0;
	
	Arithmetic ThreadP;
	
	public void run()
	{
		int tmp = testM0.consume();
		System.out.println(tmp);
		testM0.becomes(ThreadP.calculate(tmp));
	}
	public static void main(String args[])
	{
		//
		//Single thread test without blocking(simple judge on variable occupied)
		//
		/*
		aMonoVariable<String> testM0 = new mVariable<String>();
		 
		testM0.becomes("first");
		testM0.becomes("second"); <- Stuck here after blocking added
		testM0.becomes("hs1145");
		testM0.becomes("hs1145");
		testM0.becomes("hs1145");
		System.out.println(testM0.consume());
		testM0.becomes("second");
		testM0.becomes("hs1145");
		testM0.becomes(null);
		testM0.becomes("");
		System.out.println(testM0.consume());
		*/
		
		//
		//Multiple threads testing (with full code)
		//
		//Announcing test mono variable & initialising it
		aMonoVariable<Integer> testM0 = new mVariable<Integer>();
		testM0.becomes(1);
		
		//Announcing 2 arithmetic
		Adder p1 = new Adder();
		Multiplier p2 = new Multiplier();
		
		//Announcing 2 threads
		Test t1 = new Test();
		Test t2 = new Test();
		
		//Assigning mono variable & arithmetic
		t1.testM0 = testM0;
		t2.testM0 = testM0;
		t1.ThreadP = p1;
		t2.ThreadP = p2;
		
		//Start 2 threads
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException ie) {};
		
		System.out.println("Final value: "+testM0.consume());
	}
}