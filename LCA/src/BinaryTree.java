import LCA.TreeNode;

public class BinaryTree 
{

	public static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
	
		TreeNode(int data)
		{
			this.data=data;
		}
		
		int getTreeNode(int data)
		{
			return this.data;
		}
	}

	public static void printLevelOrder(Node root) 
	{
		if (root == null)
			return;

		Queue < Node > q = new LinkedList < Node > ();

		q.add(root);
	
		while (true)
		{
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;

			while (nodeCount > 0)
			{
				Node node = q.peek();
				System.out.print("(" + node.data + ")");

				q.remove();
	
		        if (node.left != null)
		            q.add(node.left);
		        if (node.right != null)
		            q.add(node.right);
		        if (node.depth != null)
		            System.out.print(" ");
		        if (nodeCount > 1)
		        {
		            System.out.print(", ");
		        }
	
		        nodeCount--;
		    }
			
			System.out.println();
		}
	}

}
