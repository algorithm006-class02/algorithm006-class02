//98
//https://leetcode-cn.com/problems/validate-binary-search-tree

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
    bool isValid(TreeNode* cur, long left, long right) {
        if (cur == NULL)
            return true;
        else if (left >= cur->val || cur->val >= right)
            return false;
        return isValid(cur->left, left, cur->val) && isValid(cur->right, cur->val, right);
    }

    bool isValidBST(TreeNode* root) {
        return isValid(root, LONG_MIN, LONG_MAX);
    }
};
