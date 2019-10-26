class TreeNode<T extends Comparable<T>>
{
    T nValue;
    TreeNode<T> nLeft;
    TreeNode<T> nRight;

    public TreeNode(T value) 
    {
        this.nValue = value;
        this.nLeft = null;
        this.nRight = null;
     }

     // Set left TreeNode
     public void setLeft(TreeNode<T> n)
     {
         this.nLeft = n;
     }

     //Set right TreeNode
     public void setRight(TreeNode<T> n)
     {
         this.nRight = n;
     }
     
     // Get left TreeNode
     public TreeNode<T> getLeft()
     {
         return this.nLeft;
     }

     // Get right TreeNode
     public TreeNode<T> getRight()
     {
         return this.nRight;
     }
     
     // Set TreeNode value
     public void setData(T value)
     {
         this.nValue = value;
     }
     
     // Get note value
     public T getData()
     {
         return this.nValue;
     } 
}

