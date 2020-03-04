/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
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
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == NULL) return NULL;
        return bfs(root, p, q);
    }
    
    TreeNode* bfs(TreeNode* root, TreeNode* p, TreeNode* q) {
        // 边界条件
        if(root == NULL) return NULL;
        if(root == p) return p;
        if(root == q) return q;
        
        TreeNode* l = bfs(root -> left, p, q); // 向左查
        TreeNode* r = bfs(root -> right, p, q); // 向右查
        
        // 当前子树的最近公共祖先判断
        if(l != NULL && r != NULL) return root;
        else if(l != NULL) return l;
        else return r;
    }
};
// @lc code=end

