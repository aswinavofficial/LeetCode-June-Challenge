
/**
	Count Complete Tree Nodes

	Given a complete bianry tree, count the numbers of nodes.
	
	Note:
	Definition of a binary Tree, count the numbers of nodes.
	
	Definition of a complete binary tree:
	Ay every Level except possibly the last, is completety filled, and all
	nodes in the last levels are as far left as possible. It can have between
	1 and 2^h nodes inclusive at the last level h.
	
	Solution:
	So if the binary tree is perfect the number of nodes is 2^h -1 .
	
	Example:

		Input: 
			1
		   / \
		  2   3
		 / \  / \
		4  5 6   5

		Output: 7  
	
	2^3 -1 = 7 elements
	
	but we know this is not posible always
		Input: 
		1
	   / \
	  2   3
	 / \  /
	4  5 6

	Output: 6
	
	Here we can aplied the formula so 
	
	One way one to resolve first is calculate h (height) of the
	left subtree and right subtree and if h is the same aplied the formula
	otherwise count the elements where the height is different.
	
	This is a good solution but will be not so readible to implement.
	
	The best solution is just count the elements as the same ways you calculate the size of a tree
	traversing all the nodes and storing all the elements in a variable.
	With recursion is:
	when you traverse to a child add one to the total size
	sum up the values
	when you reach to a leaf node add 0
	that all
	@author Brahian VT

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class CountCompleteTreeNodes{
	public int countNodes(TreeNode root) {
		if(root == null)return 0;
		
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
}

