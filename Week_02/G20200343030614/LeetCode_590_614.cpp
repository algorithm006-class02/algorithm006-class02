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
//先按照“根——右——左”顺序遍历，最后再翻转遍历的向量，得到结果
class Solution {
public:
    vector<int> postorder(Node* root) {
        stack<Node*> S;
        vector<int> res;
        if (!root) return res;
        S.push(root);
        while (!S.empty()) {
            Node* rt=S.top();
            S.pop();
            res.push_back(rt->val);
            for (int i=0; i<rt->children.size(); i++) {
                S.push(rt->children[i]);
            }
        }
        reverse(res.begin(),res.end());
        return res;
    }
};