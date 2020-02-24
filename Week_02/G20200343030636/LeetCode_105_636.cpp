/*
 * @lc app=leetcode.cn id=105 lang=cpp
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (63.95%)
 * Likes:    340
 * Dislikes: 0
 * Total Accepted:    43K
 * Total Submissions: 67K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    解法一：前序特点 ： 根 + 左子树 + 右子树；中序特点：左子树 + 根 + 右子树 ，根据这两个序列可唯一确定一棵树
    递归处理
    12ms 97.06%
    */
    /*
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if ( preorder.size() == 0 || inorder.size() == 0 || preorder.size() != inorder.size()) return nullptr ;

        TreeNode * root = buildTree(preorder, 0 ,inorder, 0, inorder.size()-1)   ;

        return root ;      
    }

    TreeNode * buildTree ( vector<int>& preorder,int rootpos,vector<int>& inorder,int start,int end) {
        //建立根节点
        TreeNode * root = new TreeNode ( preorder[rootpos] );

        auto it = find (inorder.begin(),inorder.end(), preorder[rootpos] ) ;
        if ( it == inorder.end() ) return nullptr ;

        int pos = it - inorder.begin() ;
        //有左子树
        if ( pos > start  ) {
            root -> left = buildTree ( preorder,rootpos + 1,inorder,start,pos-1 ) ;
        }

        if ( end > pos ) {
            root -> right = buildTree ( preorder,rootpos + pos - start + 1,inorder,pos + 1, end ) ;
        }

        return root ;
        
    }

    */
    /*
    解法二：迭代解法：高赞，借助栈
    */
   TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty()) return NULL;
        int ppre = 0, pin = 0;
        TreeNode* root = new TreeNode(preorder[ppre++]);
        stack<TreeNode*> stk;
        stk.push(root);
        while(true) {
            while(stk.top()->val != inorder[pin]) {
                TreeNode* newnode = new TreeNode(preorder[ppre++]);
                stk.top()->left = newnode;
                stk.push(newnode);
            }
            TreeNode* node;
            while(!stk.empty() && stk.top()->val == inorder[pin]) {
                node = stk.top();
                stk.pop();
                pin++;
            }
            if(ppre == preorder.size()) break;
            TreeNode* newnode = new TreeNode(preorder[ppre++]);
            node->right = newnode;
            stk.push(newnode);
        }
        return root;
   }
};
// @lc code=end

