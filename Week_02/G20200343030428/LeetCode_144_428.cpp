//144. 二叉树的前序遍历
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// C++ 典型前序遍历模板
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
