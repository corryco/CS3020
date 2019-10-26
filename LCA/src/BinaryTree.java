public class BinaryTree<T extends Comparable<T>> 
{

	// Binary Tree with a Root TreeNode (Null)
	TreeNode<T> root;

	// default Constructor 
    BinaryTree() 
    { 
    	root = null; 
    } 

    BinaryTree(T value) 
    { 
    	root = new TreeNode<T>(value);
    } 
  
    // Is empty tree
   public boolean isEmpty()
   {
	   return root == null;
   }
    
    // Add a TreeNode to tree
   public void add(T value) 
   {
	   if(isEmpty() )
		   root = new TreeNode<T>(value);
	   else
		   add(root, value);
   }

   //Insert value into tree - recursively
   private void add(TreeNode<T> current, T value) 
   {

	   if(value.compareTo(current.getData()) < 0) 
	   {
           if(current.nLeft == null)
        	   current.nLeft = new TreeNode(value);
           else
               add(current.nLeft, value);
       }
       else 
       {
           if(current.nRight == null)
        	   current.nRight = new TreeNode(value);
           else
               add(current.nRight, value);
       }
	          	
//    	return current;
    } 

    // TreeNode Counter 
    public int countTreeNodes()
    {
    	return countTreeNodesRecursive(root);
    }
 
    // Count TreeNodes recursively
    private int countTreeNodesRecursive(TreeNode rNode)
    {
    	int iCounter = 0;
                    
        // If root TreeNode only          
    	if (rNode == null)
    		return iCounter;

    	iCounter = 1;
    	// Traverse Tree Left
    	iCounter += countTreeNodesRecursive(rNode.getLeft());
    	// Traverse Tree Left
    	iCounter += countTreeNodesRecursive(rNode.getRight());
    	
    	return iCounter;
    }


	 public void printTree()
	 {
		 if(root == null)
			 return;

		 printTree(root);
	 }
	 
	 public void printTree(TreeNode<T> current)
	 {
		 if(current.nLeft != null)
			 printTree(current.nLeft);

		 System.out.println(current.getData());
		 
		 if(current.nRight!=null)
			 printTree(current.nRight);
	 }
	 

}

