import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest 
{
	
	@Test
	public void testTreeNodeConstructor() 
	{

		TreeNode temp = new TreeNode(1);

		assertNotNull("Test the constructor TreeNode :- ", temp);
	}


	@Test
	public void testEmptyTree() {	

		LCA tree = new LCA();

		assertNull("Test LCA for empty tree : ", tree.findLCA(1, 2));

	}

}
