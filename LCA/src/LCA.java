public class LCA 
{
	BinaryTree<Integer> btree; 
	TreeNode<Integer> tNode1;
	TreeNode<Integer> tNode2; 

	// Create a Binary Tree with a Root Node (Null) .
	public static BinaryTree<Integer> createBinaryTree(int randomData[])
	{
		BinaryTree<Integer> btree = new BinaryTree<>();
			
		for(int i=0; i < randomData.length; i++)
			btree.add(randomData[i]);

		return btree;
	}

	public static void main(String args[])
	{
		LCA lca = new LCA();

		int randomData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};

		// Binary Tree with a Root TreeNode (Null)
		BinaryTree<Integer> btree = createBinaryTree(randomData);
    
		int i  = btree.countTreeNodes();            
        btree.printTree();

        return;
	}
	
}	

/*

		int iNode1 = 10; 
	    int iNode2 = 14; 
	    
		TreeNode<Integer> tNode = new TreeNode<Integer>(0); 
	    tNode = lca(btree, iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.value); 
	   
	    iNode1 = 14; 
	    iNode2 = 8; 
	    tNode = LCA.lca(btree, iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.value); 
	   
	    iNode1 = 10; 
	    iNode2 = 22; 
	    tNode = LCA.lca(btree, iNode1, iNode2); 
	    System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.value); 
btree.add(20);
btree.add(8);
btree.add(22);
btree.add(4);
btree.add(12);
btree.add(10);
btree.add(14);

*/