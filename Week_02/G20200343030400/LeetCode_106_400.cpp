//106
//https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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
    TreeNode* buildHelper(vector<int>& inorder, int inStart, int inEnd, unordered_map<int, int>& idxInorder, vector<int>& postorder, int postEnd) {
        if (inStart == inEnd)
            return NULL;
        TreeNode* root = new TreeNode(postorder[postEnd - 1]);
        int idxRoot = idxInorder[root->val];
        root->left = buildHelper(inorder, inStart, idxRoot, idxInorder, postorder, postEnd - inEnd + idxRoot);
        root->right = buildHelper(inorder, idxRoot + 1, inEnd, idxInorder, postorder, postEnd - 1);
        return root;
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int, int> idxInorder;
        for (int i = 0; i < inorder.size(); ++i) {
            idxInorder[inorder[i]] = i;
        }
        return buildHelper(inorder, 0, inorder.size(), idxInorder, postorder, postorder.size());
    }
};
