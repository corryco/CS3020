// @author Conor Corry
// Course CS3012 - Task 2. DAG (Lowest Common Ancestor) in a DAG
// Date: Oct 2019

import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest 
{	
	@Test
	public void ConstructTest()
	{
		//Can't make a directed graph with less than 0 vertices
		DAG test = new DAG(2);
		assertEquals("Test Constructor", 2, test.getV());

		test = new DAG(9999);
		assertEquals("Test Constructor", 9999, test.getV());
	}

	@Test(expected=Exception.class)
	public void InvalidConstrutorTest()
	{
		//Can't make a directed graph with less than 0 vertices
		DAG test = new DAG(-1);
	}

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
