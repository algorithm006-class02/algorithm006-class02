//递归法
struct TreeNode {
int val;
TreeNode *left;
TreeNode *right;
TreeNode(int x) : val(x), left(NULL), right(NULL) {}

};
class Solution {
public:
	std::vector<int> inorderTraversal(TreeNode* root) {
		std::vector<int> res;
		helper(root,res);
		return res;
	}

	void helper(TreeNode* root, std::vector<int>& res) {
		if (root != nullptr) {
			if (root->left != nullptr) {
				helper(root->left, res);
			}
			res.push_back(root->val);
			if (root->right != nullptr) {
				helper(root ->right, res);
			}
		}
	}
};
