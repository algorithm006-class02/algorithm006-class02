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
class Solution {
public:
	int preIndex;
	int n;

	int getIndex(vector<int>& preorder, int val)
	{
		for (int i = 0; i < n; i++)
		{
			if (preorder[i] == val)
				return i;
		}
		return 0;
	}

	TreeNode* buildTreeUtil(vector<int>& preorder, vector<int>& inorder, int inorderStart, int inorderStop)
	{
		if (preIndex == n || inorderStart > inorderStop)
		{
			return NULL;
		}
		TreeNode * node = new TreeNode(preorder[preIndex]);
		if (inorderStart == inorderStop)
        {
            preIndex++;
            return node;
        }
			
		int index = getIndex(inorder, preorder[preIndex]);
        preIndex++;
		node->left = buildTreeUtil(preorder, inorder, inorderStart, index - 1);
		node->right = buildTreeUtil(preorder, inorder, index + 1, inorderStop);
		return node;
	}

	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) 
	{
		preIndex = 0;
		n = preorder.size();
		return buildTreeUtil(preorder, inorder, 0, n - 1);
	}
};
// @lc code=end

