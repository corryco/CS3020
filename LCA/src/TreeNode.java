
public class TreeNode
{
	int iValue;

	TreeNode nLeft;
	TreeNode nRight;
	
	// Constructor - Creates root Node 
	TreeNode(int iValue)
	{
		this.iValue = iValue;
		nLeft = nRight = null;
	}
	
	// Get Node iValue 
	int getTreeNode(int iValue)
	{
		return this.iValue;
	}

	// Set Node iValue 
	public void setTreeNode(int iValue)
	{
		this.iValue = iValue;
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
            System.out.println (prefix + (isnLeft ? "|-- " : "\\-- ") + n.iValue);
            print(prefix + (isnLeft ? "|   " : "    "), n.nLeft, true);
            print(prefix + (isnLeft ? "|   " : "    "), n.nRight, false);
        }
    }

}// TreeNode Class 
