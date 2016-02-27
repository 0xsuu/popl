package popl2015.Linda;

public interface aTemplate extends aTuple
{
	public boolean matches(aTuple t);
	// matches returns true iff aTuple t matches this instance of aTemplate, 
	// according to the Linda matching criteria
}
