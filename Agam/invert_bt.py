# June Leetcode Challenege: Day 1
"""
Problem #226
Difficulty: Medium
Question: Invert a binary tree.

Example:

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


Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        """ 
        We can use DFS to go to the bottom-most left node and then store that value;
        and we could swap that value with the bottom-most right node.
        """
        
        # base case
        if not root: 
            return None
        # recursive case
        r, l = self.invertTree(root.right), self.invertTree(root.left)
        # swapping values
        root.left, root.right = r, l
        # returning root
        return root
