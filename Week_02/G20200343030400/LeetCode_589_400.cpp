//589
//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal

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
public:
    vector<int> preorder(Node* root) {
        vector<int> res;
        if (root == NULL) return res;
        stack<Node*> stk;
        stk.push(root);
        while (!stk.empty()) {
            Node* cur = stk.top();
            stk.pop();
            res.push_back(cur->val);
            int size = cur->children.size();
            for (int i = size - 1; i >= 0; --i) {
                stk.push(cur->children[i]);
            }
        }
        return res;
    }
};
