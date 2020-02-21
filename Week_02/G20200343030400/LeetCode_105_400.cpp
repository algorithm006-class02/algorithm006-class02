//105
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildHelper(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd, unordered_map<int, int>& idxInorder) {
        if (preStart == preEnd)
            return NULL;
        TreeNode* root = new TreeNode(preorder[preStart]);
        int idxRoot = idxInorder[preorder[preStart]] - inStart;
        root->left = buildHelper(preorder, preStart + 1, preStart + 1 + idxRoot, inorder, inStart, inStart + idxRoot, idxInorder);
        root->right = buildHelper(preorder, preStart + 1 + idxRoot, preEnd, inorder, inStart + idxRoot + 1, inEnd, idxInorder);
        return root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> idxInorder;
        for (int i = 0; i < inorder.size(); ++i) {
            idxInorder[inorder[i]] = i;
        }
        return buildHelper(preorder, 0, preorder.size(), inorder, 0, inorder.size(), idxInorder);
    }
};
