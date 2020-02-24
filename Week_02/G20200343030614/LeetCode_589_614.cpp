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
//注意前序遍历时，由于栈是“先进后出”，因此子节点入栈时要倒序
class Solution {
public:
    vector<int> preorder(Node* root) {
        stack<Node*> S;
        vector<int> res;
        if (!root) return res;
        S.push(root);
        while (!S.empty()) {
            Node* rt=S.top();
            res.push_back(rt->val);
            S.pop();
            for (int i=rt->children.size()-1; i>=0; i--) {
                S.push(rt->children[i]);
            }
        }
        return  res;
    }
};