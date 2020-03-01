//144
//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if (!root) return res;
        TreeNode* cur = root;
        stack<TreeNode*> stk;
        stk.push(cur);
        while (!stk.empty()) {
            cur = stk.top();
            stk.pop();
            res.push_back(cur->val);
            if (cur->right) stk.push(cur->right);
            if (cur->left)  stk.push(cur->left);
        }
        return res;
    }
};
