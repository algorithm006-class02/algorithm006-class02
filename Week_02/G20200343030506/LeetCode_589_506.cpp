/*
 * @lc app=leetcode.cn id=589 lang=cpp
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
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
        vector<Node*> nodes; nodes.push_back(root);
        Node* tmp;
        while(!nodes.empty()){
            tmp = nodes.front(); nodes.erase(nodes.begin());
            if(tmp == NULL) continue;
            res.push_back(tmp->val);
            nodes.insert(nodes.begin(), tmp->children.begin(), tmp->children.end());
        }
        return res;
    }
};
// @lc code=end

