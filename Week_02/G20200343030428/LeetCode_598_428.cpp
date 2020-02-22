//598. N叉树的前序遍历
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
private:
    vector<int> result;
    
public:
    vector<int> preorder(Node* root, vector<int>& result) {
        result.push_back(root->val);
        for(auto node: root->children)
            preorder(root, result);
    }

    vector<int> preorder(Node* root) {
        if (!root) return result;
        preorder(root,result);
        return result;
    }
};