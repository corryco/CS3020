import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest 
{
/*
	@Test
	void testConstructor1() 
	{
		DAG dag = new DAG(1);
		assertEquals("Test Constructor", 1, dag.getV());

		dag = new DAG(999);
		assertEquals("Test Constructor", 999, dag.getV());
	}
*/
	
/*	@Test
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
*/

	@Test
	public void testDirectedGraph() 
	{
		DAG test = new DAG(10);
		// Add edges 
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
	
		//Test 
		assertEquals("Number of Edges : ", 5, test.getE());
		assertEquals("Number of Vertices : ", 10, test.getV());

    	test.addEdge(3, 7);
		assertEquals("Add Edge - Testing edge count is 2", 6, test.getE());
		assertEquals("Number of Vertices : ", 10, test.getV());

	}

	@Test
	public void testAddValidEdge() 
	{
		DAG test = new DAG(10);
		// Add edges 
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);	
		//Test 
		assertEquals("Number of Edges : ", 5, test.getE());
		assertEquals("Number of Vertices : ", 10, test.getV());
		// add new edge
    	test.addEdge(3, 7);
		assertEquals("Add Edge - Testing edge count", 6, test.getE());
		assertEquals("Number of Vertices : ", 10, test.getV());
	}

	@Test
	public void testAddInvalidEdge() 
	{
		DAG test = new DAG(10);
		// Add edges 
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);
	
        assertEquals("Add Invalid Edge (7, 99)",  -1, test.addEdge(7, 99));
		assertEquals("Add Invalid Edge - Testing edge count has not increased :", 5, test.getE());
		assertEquals("Add Invalid Edge - Testing Number of Vertices has not increased : ", 10, test.getV());
	}
}
