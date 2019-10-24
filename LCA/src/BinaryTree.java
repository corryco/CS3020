import java.util.LinkedList;
import java.util.Queue; 

public class BinaryTree  implements Tree
{
	 
	 private TreeNode root;
	 
	 public void add(int currentData)
	 {
		 if(root == null)
		 {
			 root = new TreeNode(0);
			 root.value= currentData;
			 return;
		 }
	  
		 this.add(currentData, root);
	 }
	 
	 private void add(int currentData, TreeNode position)
	 {
		 if(currentData < position.value)
		 {
			 if(position.nLeft == null)
			 {
				 position.nLeft  = new TreeNode();
				 position.nLeft.value = currentData;
		//		 position.nLeft.parent = position;
				 return;
			 }
			 add(currentData, position.nLeft);
		 }
		 else
		 {
			 if(position.nRight==null)
			 {
				position.nRight = new TreeNode();
				position.nRight.value = currentData;
	    //		position.nRight.parent = position;
				return;
			 }
			 add(currentData, position.nRight);
		 }
	 }
	 
	 public void printOrdered()
	 {
		 if(root == null)
			 return;

		 printOrdered(root);
	 }
	 
	 //DO A IN ORDER TRAVERSAL
	 //VISIT LEFT
	 //VISIT ROOT
	 //VISIT RIGHT
	 public void printOrdered(TreeNode node)
	 {
		 if(node.nLeft != null)
			 printOrdered(node.nLeft);

		 System.out.println(node.value);
		 
		 if(node.nRight!=null)
			 printOrdered(node.nRight);
	 }
	 
	 public void printValues()
	 {
		 this.print(root);
	 }
	 
	 private void print(TreeNode<A> node)
	 {
		 if(node == null)
			 return;
		 else
		 {
			 print(node.left);
			 print(node.right);
		 }
	 }
/*
	 public static void main(String args[]){

		 BinarySearchTree bTree = new BinarySearchTree();
	  
		 for(int i=0;i<10;i++){
	   int t = (int)(Math.random()*20);
	   System.out.println(t);
	   bTree.add(t);
	  }
		 
	  bTree.printValues();
	  for(int i=0;i<10;i++){
	   int t = (int)(Math.random()*20);
	   System.out.println("For i="+t+": "+bTree.search(t));
	  }
	  System.out.println();
	  bTree.printOrdered();
	 }
*/
}