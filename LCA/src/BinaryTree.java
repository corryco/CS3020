// @author Conor Corry
// Course CS3012 - Task 1. LCA (Lowest Common Ancestor) in a Binary Tree
// Date: Oct 2019

public class BinaryTree<T extends Comparable<T>> 
{

	// Binary Tree with a Root TreeNode (Null)
	TreeNode<T> root;
	
	// default Constructor 
	BinaryTree() 
	{ 
		root = null; 
		return;
	} 
  
	// Constructor - Create a Binary Tree from a Array of Generic types
	BinaryTree(T treeData[])
	{
		for(int i = 0; i < treeData.length; i++)
				add(treeData[i]);
		return;
	}

	// return root node 
	TreeNode<T> getRootNode()
	{
		return root;
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

		return;
	}

	//Insert value into tree - recursively
	private void add(TreeNode<T> current, T value) 
	{
		if(value.compareTo(current.getData()) < 0) 
		{
			if(current.nLeft == null)
				current.nLeft = new TreeNode<T>(value);
			else
				add(current.nLeft, value);
		}
		else 
		{
			if(current.nRight == null)
				current.nRight = new TreeNode<T>(value);
			else
				add(current.nRight, value);
		}
	          	
		return;
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

	public boolean printTree() 
    {
		 if(root == null)
			 return false;

		 printTree("", root, false);
		 return true;
    }

    // Print the Binary Tree - Horizontal
    public void printTree(String prefix, TreeNode<T> n, boolean isnLeft) 
    {
        if (n != null) 
        {
            System.out.println (prefix + (isnLeft ? ">-- " : ">>-- ") + n.getData());
            printTree(prefix + (isnLeft ? "|   " : "    "), n.nLeft, true);
            printTree(prefix + (isnLeft ? "|   " : "    "), n.nRight, false);
        }
    }


} // End Class
