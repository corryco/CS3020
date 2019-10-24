
public class TreeNode< A extends Comparable>
{
	A value;
	TreeNode<A> nLeft;
	TreeNode<A> nRight;
	
	// Constructor - Creates root Node 
	TreeNode(A value)
	{
		this.value = value;
		nLeft = nRight = null;
	}
	
	// Get Node iValue 
	A getTreeNode(A value)
	{
		return this.value;
	}

	// Set Node iValue 
	public void setTreeNode(A value)
	{
		this.value = value;
	}

	public void print() 
    {
        print("", this, false);
    }

    // Print the Binary Tree - Horizontal
    public void print(String prefix, TreeNode n, boolean isnLeft) 
    {
        if (n != null) 
        {
            System.out.println (prefix + (isnLeft ? "|-- " : "\\-- ") + n.value);
            print(prefix + (isnLeft ? "|   " : "    "), n.nLeft, true);
            print(prefix + (isnLeft ? "|   " : "    "), n.nRight, false);
        }
    }

}// TreeNode Class 
