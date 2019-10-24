
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LCSBinaryTree {
 
	
	class Node 
	{
		Node left;
		Node right;
		int data;
	}

	private Node n1,n2;
 
 public static void main(String args[])
 {
  LCSBinaryTree nodeFinder = new LCSBinaryTree();
  nodeFinder.find();
 }
 
 public void find()
 {
  Tree t = getSampleTree();
  Node commonParent = findCommonParent(t,n1,n2);
  if(commonParent == null){
   System.out.println("Common Parent for "+n1.data+" and "+n2.data+" is null");
  }else{
   System.out.println("Common Parent for "+n1.data+" and "+n2.data+" is "+commonParent.data);
  }
 }

 
 public Node findCommonParent(Tree t, Node node1, Node node2){
  TracePath pathTracer = new TracePath();
  
  /**
   * If either of the nodes is root, then there is no common
   * parent
   */
  if(node1.equals(t.getRoot()) || node2.equals(t.getRoot())){
   return null;
  }
  //Using the path tracer, find the path of two nodes in 2*O(n) time.
  Stack<Node> path1 = pathTracer.trace(t, node1);
  Stack<Node> path2 = pathTracer.trace(t, node2);
  
  //All that is left to do is to find the common parent now.
  Set<Node> firstPath = new HashSet<Node>();
  for(Node iNode:path1){
   firstPath.add(iNode);
  }
  while(!path2.isEmpty()){
   Node currentNode = path2.pop();
   if(firstPath.contains(currentNode)){
    if(!path2.isEmpty() && firstPath.contains(currentNode = path2.peek())){
     return path2.peek();
    }
    return currentNode;
   }
  }
  return null;
 }
}
//SAMPLE OUTPUTS
//Common Parent for 887 and 334 is 43
//Common Parent for 43 and 334 is null
//Common Parent for 6 and 334 is 43
//Common Parent for 76 and 334 is 46
