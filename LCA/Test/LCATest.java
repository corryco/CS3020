// @author Conor Corry
// Course CS3012 - Task 1. LCA (Lowest Common Ancestor) in a Binary Tree
// Date: Oct 2019

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
		
		BinaryTree<Integer> btree = new BinaryTree<>();		

		assertTrue("Test for empty tree : ", btree.isEmpty());
	}

	@Test
	// Test for empty tree with at least root node
	public void testNonEmptyTree() 
	{	
		Integer treeData[] = {0}; // Tree with Root Node
		
		BinaryTree<Integer> btree = new BinaryTree<>(treeData);		

		assertFalse("Test for non-empty tree : ", btree.isEmpty());
	}

	@Test
	// Test for Empty Tree
	public void PrintEmptyTree() 
	{	
		Integer treeData[] = {}; // Empty Tree
		
		BinaryTree<Integer> btree = new BinaryTree<>(treeData);		

		assertFalse("Print empty tree : ", btree.printTree());
	}

	@Test
	// Test LCA on an empty tree - should return NULL 
	public void testLCAEmptyTree() 
	{	

		BinaryTree<Integer> btree = new BinaryTree<>();		

        btree.printTree();

        int iNode1 = 1; int iNode2 = 2; 
        TreeNode<Integer> tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);
	}

	@Test
	// Test LCA on tree with 2 nodes - should return the root.
	public void test2NodeTree() 
	{	
		Integer treeData[] = {1,2}; // Tree with two Node
		BinaryTree<Integer> btree = new BinaryTree<>(treeData);		
	
        btree.printTree();

        int iNode1 = 1; int iNode2 = 2; 
        TreeNode<Integer> tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
        assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 1, (int)tNode.getData());
	}

	@Test
	// Test LCA on tree with 2 same nodes.
	public void testSameNodeTree() 
	{	
	    Integer treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
		BinaryTree<Integer> btree = new BinaryTree<>(treeData);		

        btree.printTree();

        //Both Nodes same 
        int iNode1 = 11; int iNode2 = 11; 
        TreeNode<Integer> tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
        assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", 11, (int)tNode.getData());
	}
	
	@Test
	// Invalid LCA Test - either nodes do not exist on tree - should return NULL 
	public void testInValidTree() 
	{	
	    Integer treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
	    BinaryTree<Integer> btree = new BinaryTree<>(treeData);		
        
		btree.printTree();

        //Both Nodes Invalid 
        int iNode1 = 44; int iNode2 = 66; 
        TreeNode<Integer> tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);

	}
	
	@Test
	// Valid LCA Tests
	public void testValidTree() 
	{	
        int iNode1; 
	    int iNode2; 
	    Integer treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
	    TreeNode<Integer> tNode; 
		
	    BinaryTree<Integer> btree = new BinaryTree<>(treeData);		
        
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

}// End Class 
