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
	
	@Test
	public void testsDAGCyclic()
	{
		DAG test= new DAG(3);
		// 0 - 1 - 2 - 0
		test.addEdge(0, 1);
		test.addEdge(1, 2);
		test.addEdge(2, 0);
		test.findCycle(0);
		
		assertTrue("DAG Test Cyclic : ", test.getCycle());
	}

	@Test
	public void testsDAGNonCyclic()
	{
		DAG test= new DAG(3);
		// 0 - 1 - 2 - 0
		test.addEdge(0, 1);
		test.addEdge(1, 2);
		test.addEdge(2, 3);
		test.findCycle(0);
		
		assertFalse("DAG Test Non-Cyclic : ", test.getCycle());
	}

	@Test
	public void testValidDAGS() 
	{  
		DAG test = new DAG(7);
		test.addEdge(0, 1); 
		test.addEdge(0, 2); 
		test.addEdge(1, 3);
		test.addEdge(2, 4);
		test.addEdge(4, 5);	
		test.addEdge(3, 5); 
		test.addEdge(5, 6); 
		
    	int iNode1 = 3; int iNode2 = 5; 
		assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is : ", 3, test.findLCA(iNode1, iNode2));

		iNode1 = 4; iNode2 = 6; 
		assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is : ", 4, test.findLCA(iNode1, iNode2));

		iNode1 = 1; iNode2 = 4; 
		assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is : ", 0, test.findLCA(iNode1, iNode2));
	}

	@Test
	public void testDAGSameNode() 
	{  
		DAG test = new DAG(7);
		test.addEdge(0, 1); 
		test.addEdge(0, 2); 
		test.addEdge(1, 3);
		test.addEdge(2, 4);
		test.addEdge(4, 5);	
		test.addEdge(3, 5); 
		test.addEdge(5, 6); 
		
    	int iNode1 = 3; int iNode2 = 3; 
		assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is : ", 3, test.findLCA(iNode1, iNode2));

		iNode1 = 4; iNode2 = 4; 
		assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is : ", 4, test.findLCA(iNode1, iNode2));

	}
	
	@Test
	public void testDAGWithCycle() 
	{  
		DAG test = new DAG(6);
		test.addEdge(0, 1); 
		test.addEdge(0, 2); 
		test.addEdge(0, 3);
		test.addEdge(2, 0);
		test.addEdge(2, 3);	
		test.addEdge(2, 4); 
		test.addEdge(3, 4); 
		test.addEdge(3, 5); 
		
    	int iNode1 = 1; int iNode2 = 4; 
		assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is : ", -1, test.findLCA(iNode1, iNode2));

	}
}
