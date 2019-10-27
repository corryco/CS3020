import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest 
{

	@Test
	void testConstructor1() 
	{
		DAG dag = new DAG(1);
		assertEquals("Test Constructor", 1, dag.getV());

		dag = new DAG(999);
		assertEquals("Test Constructor", 999, dag.getV());
	}

	@Test
	void testConstructor2() 
	{
		try 
		{
			DAG dag = new DAG(-1);
		} 
		catch (IllegalArgumentException e) 
		{
		}
	}



}
