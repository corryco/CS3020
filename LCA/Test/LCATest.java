import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest 
{
	
	@Test
	// Test the Tree constructor 
	public void testBInaryTreeConstructor() 
	{
		BinaryTree<Integer> btree = new BinaryTree<>();

		assertNotNull("Test the constructor TreeNode :- ", btree);
	}


	@Test
	// Test for Empty Tree
	public void testEmptyTree() 
	{	
		int treeData[] = {}; // Empty Tree
		
		BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);

		assertTrue("Test for empty tree : ", btree.isEmpty());
	}

	@Test
	// Test for tree with at least root node
	public void testNonEmptyTree() 
	{	
		int treeData[] = {0}; // Tree with Root Node
		
		BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);

		assertFalse("Test for non-empty tree : ", btree.isEmpty());
	}

	@Test
	// Test LCA on an empty tree - should return NULL 
	public void testLCAEmptyTree() 
	{	

		int iNode1; 
	    int iNode2; 
	    TreeNode<Integer> tNode; 

		BinaryTree<Integer> btree = new BinaryTree<>();		

        btree.printTree();

        iNode1 = 1; iNode2 = 2; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);
	}

	@Test
	// Test LCA on tree with 2 nodes - should return the root.
	public void test2NodeTree() 
	{	
        int iNode1; 
	    int iNode2; 
		int treeData[] = {1,2}; // Tree with two Node
	    TreeNode<Integer> tNode; 

		BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);

        btree.printTree();

        iNode1 = 1; iNode2 = 2; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 1, (int)tNode.getData());
	}


	@Test
	// Test LCA on tree with 2 same nodes - should return null.
	public void testSameNodeTree() 
	{	
        int iNode1; 
	    int iNode2; 
	    int treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
	    TreeNode<Integer> tNode; 

		BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);

        btree.printTree();

        //Both Nodes same 
        iNode1 = 44; iNode2 = 44; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);
	}
	
	@Test
	// Invalid LCA Test - either nodes do not exist on tree - should return NULL 
	public void testInValidTree() 
	{	
        int iNode1; 
	    int iNode2; 
	    int treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
	    TreeNode<Integer> tNode; 
		
	    BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);
        btree.printTree();

        //One Node Invalid 
        iNode1 = 99; iNode2 = 11; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
//	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);

        //Both Nodes Invalid 
        iNode1 = 44; iNode2 = 66; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);

	}
	
	@Test
	// Valid LCA Tests
	public void testValidTree() 
	{	
        int iNode1; 
	    int iNode2; 
	    int treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
	    TreeNode<Integer> tNode; 
		
	    BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);
        btree.printTree();

        iNode1 = 11; iNode2 = 76; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 43, (int)tNode.getData());

        iNode1 = 32; iNode2 = 334; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 43, (int)tNode.getData());

        iNode1 = 11; iNode2 = 6; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 11, (int)tNode.getData());

        iNode1 = 76; iNode2 = 45; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 46, (int)tNode.getData());

        iNode1 = 76; iNode2 = 734; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 76, (int)tNode.getData());
	
        iNode1 = 6; iNode2 = 32; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 11, (int)tNode.getData());

        iNode1 = 6; iNode2 = 0; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 3, (int)tNode.getData());
}

}
