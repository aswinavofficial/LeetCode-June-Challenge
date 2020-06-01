class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(!root||(!root->left && !root->right))
            return root;
        TreeNode* t= root->left;
        root->left=invertTree(root->right);
        root->right=invertTree(t);
        return root;
    }
};