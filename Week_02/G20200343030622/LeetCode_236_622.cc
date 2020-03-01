/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    /* lowestCommonAncestor的含义是：求包含p或q的子树 */
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (root == nullptr || root == p || root == q)
        {
            return root;
        }

        TreeNode *left_result = lowestCommonAncestor(root->left, p, q);
        TreeNode *right_result = lowestCommonAncestor(root->right, p, q);

        if (left_result && right_result)
        {
            return root;
        }

        if (left_result != nullptr)
        {
            return left_result;
        }

        if (right_result != nullptr)
        {
            return right_result;
        }

        return nullptr;
    }
};