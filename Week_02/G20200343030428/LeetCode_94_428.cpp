//94. 二叉树的中序遍历
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// C++ 典型中序遍历模板
class Solution {
private:
	vector<int> traversalValues;
public:
    vector<int> inorderTraversal(TreeNode* root) {
        if (!root) return traversalValues;  // 递归退出条件

        inorderTraversal(root->left);
        traversalValues.push_back(root->val);
        inorderTraversal(root->right);

        return traversalValues;
    }
};

// 自己维护一个栈
// class Solution {
// public:
//     vector<int> inorderTraversal(TreeNode* root) {
//         stack<TreeNode*> S;
//         vector<int> v;
//         TreeNode* rt = root;
//         while (rt || S.size()) {
//             while(rt) {
//                 S.push(rt);
//                 rt = rt->left;
//             }
//             rt = S.top(); S.pop();
//             v.push_back(rt->val);
//             rt = rt->right;
//         }
//         return v;
//     }
// };