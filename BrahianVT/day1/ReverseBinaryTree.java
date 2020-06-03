
/**
 * Definition for a binary tree node.
 *  class TreeNode {
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
 Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9
 
 
 Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class ReverseBinaryTree{
	
	
	// Use in-order itarator and just swap the left child with the right child
	public TreeNode invertTree(TreeNode root) {
		if(root == null)return root;
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		root.left = right;  root.right = left;
		
		return root;
	}
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }