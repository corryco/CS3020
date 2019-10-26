public class LCA 
{
	// Create a Binary Tree with a Root Node (Null) .
	private BinaryTree createBinaryTree() 
	{
	    BinaryTree<Integer> btree = new BinaryTree<>();

	    btree.add(20);
	    btree.add(8);
	    btree.add(22);
	    btree.add(3);
	    btree.add(5);
	    btree.add(7);
	    btree.add(9);

	    return btree;
	}

	public static void main(String args[])  
	{ 
			// Creating a binary tree
			int randomData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
	                
			//TreeNode<Integer> tNode;

			BinaryTree<Integer> btree = new BinaryTree<>();

            btree.add(20);
            btree.add(8);
            btree.add(22);
            btree.add(4);
            btree.add(12);
            btree.add(10);
            btree.add(14);

            int i  = btree.countTreeNodes();            
            btree.printTree();

/*
	        int iNode1 = 10; 
	        int iNode2 = 14; 

	        tNode = LCA.lca(btree, iNode1, iNode2); 
	        System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.value); 
	   
	        iNode1 = 14; 
	                iNode2 = 8; 
	        tNode = LCA.lca(btree, iNode1, iNode2); 
	        System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.value); 
	   
	        iNode1 = 10; 
	                iNode2 = 22; 
	        tNode = LCA.lca(btree, iNode1, iNode2); 
	        System.out.println("LCA of " + iNode1 + " and " + iNode2 + " is " + tNode.value); 
*/	   
	    }
}	
