// @author Conor Corry
// Course CS3012 - Task 2. DAG (Lowest Common Ancestor) in a DAG
// Date: Oct 2019

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG 
{
	int V; // number of vertices in this digraph
	int E; // number of edges in this digraph
	boolean marked[]; // Boolean List to track visited vertices
	boolean hasCycle; // True if cycle in graph
	boolean stack[]; // Order that vertices were visited
	int[] indegree; // indegree[v] = indegree of vertex v
	ArrayList<Integer>[] adj; // adj[v] = adjacency list for vertex v

	public DAG(int V) 
	{
		if (V < 0)
			throw new IllegalArgumentException("No Vertices");

		this.V = V;
		this.E = 0;
		this.indegree = new int[V];
		this.marked = new boolean[V];
		this.stack = new boolean[V];
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for (int i = 0; i < this.V; i++) 
			this.adj[i] = new ArrayList<Integer>();

		return;
	}

	// Returns current vertex
	public int getV() 
	{
		return V;
	}

	public int getE() 
	{
		return E;
	}

	// Adds a directed edge from v->w
	public int addEdge(int v, int w) 
	{
		if (!validVertex(v) || !validVertex(w) ) 
			return -1;
		
		adj[v].add(w);
		indegree[w]++;
		E++;
			
		return E;
	}

	private boolean validVertex(int v) 
	{
		return (v < 0 || v >= V) ? false : true;
	}

	// Returns amount of directed edges incident to vertex v
	public int indegree(int v) 
	{
		return validVertex(v) ? indegree[v] : -1;
	}
	
	// Returns amount of directed edges from vertex v
	public int outdegree(int v) 
	{
		return validVertex(v) ? adj[v].size() : -1;
	}

	// Returns the adjacent vertices to v
	public Iterable<Integer> adj(int v) 
	{
		return adj[v];
	}

	public int findLCA(int v, int w) 
	{
		boolean found = false;

		findCycle(0);
	
		if (hasCycle) // Graph is not a DAG
			return -1;

		//LCA comes before the two nodes - traverse the graph backwards
		DAG backwards = reverse();

		// Locate the two points in the graph
		ArrayList<Integer> vPath = backwards.BFS(v);
		ArrayList<Integer> wPath = backwards.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		// cycle through the BFS paths, adding all common ancestors to the arrayList
		// return the first one found, as it is the closest to the nodes.
		for (int i = 0; i < vPath.size(); i++) 
		{
			for (int t = 0; t < wPath.size(); t++) 
			{
				if (vPath.get(i) == wPath.get(t)) 
				{
					commonAncestors.add(vPath.get(i));
					found = true;
				}
			}
		}
		
		// return LCA or -1 if no LCA is found
		return found ? commonAncestors.get(0) : -1;
	}

	//. Reverse the DAG 
	public DAG reverse() 
	{
		DAG reverse = new DAG(V); // new DAG of same parameter
	
		for (int v = 0; v < V; v++) 
		{
			for (int w : adj(v)) 
				reverse.addEdge(w, v); // reverse the direction of the edges
		}

		return reverse;
	}

	public ArrayList<Integer> BFS(int s) 
	{
		// Mark all the vertices as not visited(By default set as false)
		boolean visited[] = new boolean[V];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> order = new ArrayList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) 
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			order.add(s);
			
			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it as visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) 
			{
				int n = i.next();
				if (!visited[n]) 
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}

		return order;
	}

	public boolean getCycle() 
	{
		return this.hasCycle;
	}

	public void findCycle(int v) 
	{
		marked[v] = true;
		stack[v] = true;

		for (int w : adj(v)) 
		{
			if (!marked[w]) 
			{
				findCycle(w);
			} 
			else if (stack[w]) 
			{
				hasCycle = true;
				return;
			}
		}
		stack[v] = false;
	}

	public static void main(String[] args) 
	{
		DAG dag = new DAG(10);
		dag.addEdge(1, 2);
		dag.addEdge(1, 3);
		dag.addEdge(3, 4);
		dag.addEdge(4, 5);
		dag.addEdge(4, 6);
		
    	System.out.println("Vertices = [" + dag.getV() + "] " + "Edges [" + dag.getE() + "] "); 
    	
    	dag.addEdge(1, 2);
    	System.out.println("Add Edge Vertices = [" + dag.getV() + "] " + "Edges [" + dag.getE() + "] "); 
		
    	dag.addEdge(7, 99);
    	System.out.println("Add Edge Vertices = [" + dag.getV() + "] " + "Edges [" + dag.getE() + "] "); 

		//System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

		DAG test = new DAG(7);
		test.addEdge(0, 1); 
		test.addEdge(0, 2); 
		test.addEdge(1, 3);
		test.addEdge(2, 4);
		test.addEdge(4, 5);	
		test.addEdge(3, 5); 
		test.addEdge(5, 6); 
    	System.out.println("Add Edge Vertices = [" + test.getV() + "] " + "Edges [" + test.getE() + "] "); 

    	int iNode1 = 3; int iNode2 = 5; 
		System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + test.findLCA(iNode1, iNode2)); 

		iNode1 = 4; iNode2 = 6; 
		System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + test.findLCA(iNode1, iNode2)); 

		iNode1 = 1; iNode2 = 4; 
		System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + test.findLCA(iNode1, iNode2)); 

		iNode1 = 4; iNode2 = 4; 
		System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + test.findLCA(iNode1, iNode2)); 

		DAG g = new DAG(6);
		g.addEdge(0, 1);
		g.addEdge(0, 3); 
		g.addEdge(0, 4);
		g.addEdge(3, 4);
		g.addEdge(1, 0);	
		g.addEdge(1, 4); 
		g.addEdge(1, 2);
		g.addEdge(4, 2);
		g.addEdge(4, 5);	
				
    	iNode1 = 3; iNode2 = 2; 	
		System.out.println("Multi-LCA of " + iNode1 + " and " + iNode2 + " is " + g.findLCA(iNode1, iNode2)); 
	}
}
