/*
 * @lc app=leetcode.cn id=105 lang=cpp
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
// 函数值返回指针一般为递归，递归root->left 和 root->right 继续调用这个函数
class Solution {
public:
    /* ------------------------------------------ */
    // TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    //     int pos = 0;
    //     return buildTree(preorder, pos, inorder, 0, inorder.size());
    // }
    // TreeNode* buildTree(vector<int>& preorder, int& pos, vector<int>& inorder, int left, int right) {
    //     if (pos >= preorder.size()) return 0;
    //     int i = left;
    //     for (i = left; i < right; ++i) {
    //         if (inorder[i] == preorder[pos]) break; //寻找root节点
    //     }
    //     TreeNode* node = new TreeNode(preorder[pos]);   //创建root节点
    //     // 创建完root 之后，分别创建左节点，右节点
    //     if (left < i) node->left = buildTree(preorder, ++pos, inorder, left, i);  // 左子树
    //     if (i + 1 < right) node->right = buildTree(preorder, ++pos, inorder, i + 1, right);  // 右子树
    //     return node;
    // }
    /* ------------------------------------------ */
    // Accepted
    // 203/203 cases passed (12 ms)
    // Your runtime beats 97.08 % of cpp submissions
    // Your memory usage beats 96.02 % of cpp submissions (14.6 MB)
    TreeNode* buildTree_method(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty()) return NULL;
        TreeNode* root = new TreeNode(preorder[0]); 
        stack<TreeNode*> st;
        st.push(root);  //将 root 放入栈里

        for(int i = 1, j = 0; i < preorder.size(); ++i) {
            TreeNode *curRoot = NULL;
            TreeNode *curNode = new TreeNode(preorder[i]); //先取出root的左节点

            // 节点top()->val值 == inorder[j] 中序里面存在
            while(!st.empty() && st.top()->val == inorder[j]) { 
                curRoot = st.top(); 
                st.pop();   //每个root只用一次
                ++j;
            }

            // 遍历一次分成2部分，left在中序遍历找不到，right在中序遍历能找到
            if(curRoot) curRoot->right = curNode;
            else st.top()->left = curNode;
            // 每个节点都会放进 st
            st.push(curNode);
        }
        return root;
    }
    /* ------------------------------------------ */
};

// @lc code=end

