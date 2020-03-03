/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//从根一路向左遍历，遇到有右节点就入栈，内层while循环完根和左子树就都遍历完了，然后右节点依次出栈，遍历，前序完成！
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        stack<TreeNode*> S;
        vector<int> res;
        TreeNode* rt=root;
        while (rt || S.size()) {
            while (rt) {
                S.push(rt->right);
                res.push_back(rt->val);
                rt = rt->left;
            }
            rt=S.top();
            S.pop();
        }
        return res;
    }
};