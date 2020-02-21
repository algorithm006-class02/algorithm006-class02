//590. N叉树的后序遍历
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
    void postorder(Node* node, vector<int>& result) {
        for (auto node: node->children) 
            postorder(node, result);
        result.push_back(node->val);
    }
    vector<int> postorder(Node* root) {
        if (!root) return result;
        postorder(root, result);
        return result;
    }
};

class Solution {
public:
    vector<int> postorder(Node* root) {
        if (!root) return vector<int> {};
        vector<Node*> stack { root };
        vector<int> res;
        while (stack.size()) {
            Node *node = stack.back();
            stack.pop_back();
            res.push_back(node->val);
            for (Node *c: node->children) 
                stack.push_back(c);
        }
        reverse(begin(res), end(res));
        return res;
    }
};