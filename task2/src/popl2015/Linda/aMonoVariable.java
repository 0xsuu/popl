
package popl2015.Linda;

public interface aMonoVariable<T>
{
	public void becomes(T v);
	public T consume();
}