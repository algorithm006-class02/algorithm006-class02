//递归
class Solution {
public:
	std::vector<int> postorder(Node* root) {
		std::vector<int> v;

		postorder(root, v);

		return v;
	}

	void postorder(Node* root, std::vector<int>& v) {
		if (root == nullptr)
			return;

		for (int i = 0; i < root->children.size(); ++i)
		{
			postorder(root->children[i], v);
		}
		v.push_back(root->val);
	}

};
