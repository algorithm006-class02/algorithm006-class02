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
    vector<int> preorderTraversal(TreeNode *root)
    {
        vector<int> result{};
        stack<TreeNode *> st_node;
        st_node.push(root);

        while (!st_node.empty())
        {
            TreeNode *node = st_node.top();
            st_node.pop();

            if (node == nullptr)
                continue;

            st_node.push(node->right);
            st_node.push(node->left);
            result.push_back(node->val);
        }

        return result;
    }
};