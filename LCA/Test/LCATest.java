import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest 
{
	
	@Test
	public void testBInaryTreeConstructor() 
	{
		BinaryTree<Integer> btree = new BinaryTree<>();

		assertNotNull("Test the constructor TreeNode :- ", btree);
	}


	@Test
	public void testEmptyTree() 
	{	
		int treeData[] = {}; // Empty Tree
		
		BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);

		assertTrue("Test for empty tree : ", btree.isEmpty());
	}

	@Test
	public void testNonEmptyTree() 
	{	
		int treeData[] = {0}; // Tree with Root Node
		
		BinaryTree<Integer> btree = new BinaryTree<>();		
		btree = LCA.createBinaryTree(treeData);

		assertFalse("Test for non-empty tree : ", btree.isEmpty());
	}

	@Test
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
        iNode1 = 11; iNode2 = 99; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);

        //Both Nodes Invalid 
        iNode1 = 44; iNode2 = 66; 
        tNode = LCA.lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    assertEquals("LCA of " + iNode1 + " and " + iNode2 + " is ", null, tNode);
	}
	
	@Test
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
