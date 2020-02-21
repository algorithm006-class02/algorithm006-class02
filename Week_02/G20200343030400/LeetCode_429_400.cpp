//429
//https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal

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
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (!root) return res;
        vector<Node*> preLevel;
        preLevel.push_back(root);
        while (preLevel.size() > 0) {
            vector<int> preRes;
            vector<Node*> curLevel;
            for (Node* preNode : preLevel) {
                preRes.push_back(preNode->val);
                for (Node* curNode : preNode->children) {
                    curLevel.push_back(curNode);
                }
            }
            res.push_back(preRes);
            preLevel = curLevel;
        }            
        return res;
    }
};
