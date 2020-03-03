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
    int pre_idx{0};
    unordered_map<int, int> inorder_lookup_map_{};
    vector<int> preorder_;
    vector<int> inorder_;

    TreeNode *buildTreeHelper(int idx_left, int idx_right)
    {
        if (idx_left >= idx_right)
        {
            return nullptr;
        }

        TreeNode *node = new TreeNode(preorder_[pre_idx++]);
        node->left = buildTreeHelper(idx_left, inorder_lookup_map_[node->val]);
        node->right = buildTreeHelper(inorder_lookup_map_[node->val] + 1, idx_right);
        return node;
    }

    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        preorder_ = preorder;
        inorder_ = inorder_;

        for (int i = 0; i < inorder.size(); i++)
        {
            inorder_lookup_map_[inorder[i]] = i;
        }

        return buildTreeHelper(0, inorder.size());
    }
};