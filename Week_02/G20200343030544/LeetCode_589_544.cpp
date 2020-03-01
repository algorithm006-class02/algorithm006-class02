//递归
class Solution {

public:
	std::vector<int> preorder(Node* root) {
		
		if(root == nullptr) return res;
		res.push_back(root->val);
		int len = root->children.size();
		for (int i = 0; i < len;i++){
			preorder(root->children[i]);
		}
		return res;
	}

private:
	std::vector<int> res;
};
