
public class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	
	// Constructor 
	TreeNode(int data)
	{
		this.data=data;
	}
	
	//Get Node Data 
	int getTreeNode(int data)
	{
		return this.data;
	}

    public void print() 
    {
        print("", this, false);
    }

    // Print the Binary Tree - Horizontal
    public void print(String prefix, TreeNode n, boolean isLeft) 
    {
        if (n != null) 
        {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

}// TreeNode Class 