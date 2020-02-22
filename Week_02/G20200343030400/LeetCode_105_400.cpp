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

/*preorder的第一位是根节点值，只有这个有用*/

class Solution {
public:
    TreeNode* buildHelper(vector<int>& preorder, int preStart, vector<int>& inorder, int inStart, int inEnd, unordered_map<int, int>& idxInorder) {
        if (inStart == inEnd)
            return NULL;
        TreeNode* root = new TreeNode(preorder[preStart]);
        int idxRoot = idxInorder[root->val];
        root->left = buildHelper(preorder, preStart + 1, inorder, inStart, idxRoot, idxInorder);
        root->right = buildHelper(preorder, preStart + 1 + idxRoot - inStart, inorder, idxRoot + 1, inEnd, idxInorder);
        return root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> idxInorder;
        for (int i = 0; i < inorder.size(); ++i) {
            idxInorder[inorder[i]] = i;
        }
        return buildHelper(preorder, 0, inorder, 0, inorder.size(), idxInorder);
    }
};
