
/**
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.


Example 2:
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 
 
 Solution this examble can be resolve by traversing the tree either with Depth First Search 
 or breadth first search 
 I use DFS because with that we will get the better performance
 
 Input: [1,2,3]
    1
   / \
  2   3
  
  With this tree just traverse every child with a pre-order style
  and in every level you need aa one decimal to the number
  example 
  level  value
  1      1
  2		 10
  3		 100
  
  So following this style we will end up 
  doing this
  res = (res * 10) + root.val
  apply it to every nood until reach the leaf nodes and just
  return the sum of the left and right brach and that all
  
   Input: [1,2,3]
     1  num = 1
   /  \
  2    3
 num = 12  + num = 13 = 25
 
 @author Brahian VT
**/
public class SumLeafNodes{
	
	public int sumNumbers(TreeNode root) {
		 if(root == null) return 0;
		 
		 return dfs(root, 0);
	}
	
	private int dfs(TreeNode root, int tol){
		if(root == null)return 0;
		tol = tol*10 + root.val;
		
		if(root.left == null && root.right == null)
			return tol;
		
		return dfs(root.left, tol) + dfs(root.right, tol);
		
	}	
	
}