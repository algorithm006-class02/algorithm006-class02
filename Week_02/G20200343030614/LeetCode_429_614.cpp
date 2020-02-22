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
//层序遍历用队列，先进先出，且每个节点遍历过程中将其子节点入队，等待后续遍历
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if (!root) return {};
        vector<vector<int>> res;
        queue<Node*> Q;
        Q.push(root);
        while (!Q.empty()) {
            vector<int> el;
            for (int i=Q.size(); i; i--) {
                Node* curr=Q.front();
                Q.pop();
                el.push_back(curr->val);
                for (Node* item:curr->children) {
                    Q.push(item);
                }
            }
            res.push_back(el);
        }
        return res;
    }
};