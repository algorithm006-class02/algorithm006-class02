//590
//https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal

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
    vector<int> postorder(Node* root) {
        vector<int> res;
        if (root == NULL) return res;
        stack<pair<Node*, bool>> stk;
        stk.push(make_pair(root, false));
        while (!stk.empty()) {
            Node* cur = stk.top().first;
            bool visited = stk.top().second;
            stk.pop();
            if (cur == NULL) continue;
            if (visited) {
                res.push_back(cur->val);
            } else {
                stk.push(make_pair(cur, true));
                int size = cur->children.size();
                for (int i = size - 1; i >= 0; --i) {
                    stk.push(make_pair(cur->children[i], false));
                }
            }
        }
        return res;
    }
}
