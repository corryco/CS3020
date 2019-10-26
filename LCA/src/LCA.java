public class LCA 
{

	// Create a Binary Tree with a Root Node (Null) .
	public static BinaryTree<Integer> createBinaryTree(int treeData[])
	{
		BinaryTree<Integer> btree = new BinaryTree<>();
			
		for(int i = 0; i < treeData.length; i++)
			btree.add(treeData[i]);

		return btree;
	}

	public static TreeNode<Integer> lowestCommonAncestorRecursive(TreeNode<Integer> node, int a, int b) 
	{
		//If node is null, return null
		if(node == null)
			return null;
	
		// If root = either input note - return root
		if(node.getData() == a || node.getData() == b)
			return node;
	 
		TreeNode<Integer> leftNode=lowestCommonAncestorRecursive(node.nLeft,a,b);
		TreeNode<Integer> rightNode=lowestCommonAncestorRecursive(node.nRight,a,b);
	 
		// If we get left and right not null, this node is LCA for a and b
		if(leftNode != null && rightNode != null)
			return node;
			
		if(leftNode != null)
			return leftNode;
		else if (rightNode != null)
			return rightNode;
		else
			return null;
	}

	public static void main(String args[])
	{
		int treeData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
		BinaryTree<Integer> btree = new BinaryTree<Integer>();
		
		// Binary Tree with a Root TreeNode (Null)
		btree = createBinaryTree(treeData);

        btree.printTree();

        int iNode1 = 19; 
	    int iNode2 = 76; 

        TreeNode<Integer> tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
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

        iNode1 = 999; iNode2 = 11; 
	    tNode = lowestCommonAncestorRecursive(btree.getRootNode(), iNode1, iNode2); 
	    if(tNode != null )
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
	
}	
