/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
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
private:
    vector<int> TraversalVal;
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if (!root) return TraversalVal;

        TraversalVal.push_back(root->val);
        preorderTraversal(root->left);
        preorderTraversal(root->right);

        return TraversalVal;
    }
};
// @lc code=end

