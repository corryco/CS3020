
public class LCA 
{

	public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode a, TreeNode b) 
	{	
		
		//If node is null, return null
		if(root == null)
			return null;
		
		// If root = either input note - return root
		if(root.data == a.data || root.data == b.data )
			return root;

//FIX 
		
		return root;
	}
	
	public static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode a, TreeNode b) 
	{
		//If node is null, return null
		if(root == null)
			return null;
	
		// If root = either input note - return root
		if(root.data == a.data || root.data == b.data )
			return root;
	 
		TreeNode left=lowestCommonAncestorRecursive(root.left,a,b);
		TreeNode right=lowestCommonAncestorRecursive(root.right,a,b);
	 
		// If we get left and right not null , it is LCA for a and b
		
		if(left!=null && right!=null)
				return root;
			
		if(left== null)
			return right;
		else
			return left;
	}

	public static TreeNode createRandomBinaryTree(int randomData[])
	{
		TreeNode rootNode =new TreeNode(randomData.length);
			
		for(int i=0;i<randomData.length;i++)
		{
			rootNode.add(randomData[i]);
		}
 		return rootNode;		
	}
	
	public static void main(String[] args)
	{	
		// Creating a binary tree
		int randomData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
		TreeNode rootNode=createRandomBinaryTree(randomData);

		TreeNode node5 = new TreeNode(11);
		TreeNode node30 = new TreeNode(76);
				
		System.out.println(lowestCommonAncestorRecursive(rootNode,node5,node30).data);
	 
	} 
}	


/*		
System.out.println("Lowest common ancestor for node 5 and 30:");

TreeNode node20=new TreeNode(20);
TreeNode node10=new TreeNode(10);
TreeNode node30=new TreeNode(30);
TreeNode node60=new TreeNode(60);
TreeNode node50=new TreeNode(50);
TreeNode node70=new TreeNode(70);
TreeNode node5=new TreeNode(5);
TreeNode node45=new TreeNode(45);
TreeNode node55=new TreeNode(55);

rootNode.left=node20;
rootNode.right=node60;

node20.left=node10;
node20.right=node30;

node60.left=node50;
node60.right=node70;

node10.left=node5;
node50.right=node55;
*/
