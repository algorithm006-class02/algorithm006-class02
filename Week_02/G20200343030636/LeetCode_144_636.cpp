/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (63.97%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    68K
 * Total Submissions: 106.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
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
    /*
    解法一：递归，时间复杂度O(n) ,空间复杂度O(1)
    1ms 99%
    */
    /*
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result ;
        preorderTraversal ( root , result ) ;

        return result ;
    }

    void preorderTraversal( TreeNode* root , vector<int> & result )  {
        if ( root == nullptr ) return ;
        result.emplace_back( root -> val ) ;
        if( root -> left != nullptr ) preorderTraversal( root -> left , result ) ;
        if( root -> right != nullptr ) preorderTraversal( root -> right , result ) ;
    }
    */

    /*
    解法二：迭代，时间复杂度O(n)，借助栈，空间复杂度O(n)
    */
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result ;
        if ( root == nullptr ) return result ;

        stack<TreeNode*> s ;
        s.push( root ) ;
        while( !s.empty() ) {
            root =  s.top() ;
            result.emplace_back( root -> val ) ;
            s.pop() ;
            if( root->right != nullptr) s.push(root->right) ;
            if( root->left != nullptr) s.push(root->left) ;   
        }

        return result ;
       
    }
  
};
// @lc code=end

