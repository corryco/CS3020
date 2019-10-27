// @author Conor Corry
// Course CS3012 - Task 1. LCA (Lowest Common Ancestor) in a Binary Tree
// Date: Oct 2019

// binary tree -  find the lowest common ancestor (LCA) of two given nodes in the tree
public class LCA 
{

	public static TreeNode<Integer> lowestCommonAncestorRecursive(TreeNode<Integer> node, int a, int b) 
	{
		//If node is null, return null
		if(node == null)
			return null;
	
		// If node = either input node value - return node
		if(node.getData() == a || node.getData() == b)
			return node;
	 
		TreeNode<Integer> leftNode=lowestCommonAncestorRecursive(node.nLeft,a,b);
		TreeNode<Integer> rightNode=lowestCommonAncestorRecursive(node.nRight,a,b);
	 
		// If both return Non-NULL, then keys are present different subtree, this node is the LCA
		if(leftNode != null && rightNode != null)
			return node;
			
		// Otherwise check if left subtree or right subtree is LCA
		if(leftNode != null)
			return leftNode;
		else if (rightNode != null)
			return rightNode;
		else
			return null;
	}

	
	
	public static void main(String args[])
	{
		Integer treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
		BinaryTree<Integer> btree = new BinaryTree<Integer>(treeData);
		
		// Print Binary Tree
        btree.printTree();

        int iNode1 = 11; 
	    int iNode2 = 11; 

        TreeNode<Integer> tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 
        

	    iNode1 = 19; 
	    iNode2 = 76; 

        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 
        
	    iNode1 = 32; 
	    iNode2 = 334; 
        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

	    iNode1 = 11; 
	    iNode2 = 6; 
        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

	    iNode1 = 887; 
	    iNode2 = 45; 
        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

	    iNode1 = 76; 
	    iNode2 = 45; 
        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

        iNode1 = 76; iNode2 = 734; 
        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

        iNode1 = 6; iNode2 = 32; 
        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 
	    
        iNode1 = 6; iNode2 = 0; 
        tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 
   
        iNode1 = 44; iNode2 = 66; 
	    tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    if(tNode != null )
	    	System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

        iNode1 = 44; iNode2 = 44; 
	    tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    if(tNode != null )
	    	System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.getData()); 

	    return;
	}
	
}// End Class	
