/*
 * @lc app=leetcode.cn id=429 lang=cpp
 *
 * [429] N叉树的层序遍历
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
    vector<vector<int>> levelOrder(Node* root) {
        if (!root) return {};
        vector<vector<int>> to_return;
        to_return.push_back({root->val});
        vector<int> vec;
        int curr_level = 0;
        queue<pair<Node*, int>> q;
        q.push(make_pair(root, 0));
        while (!q.empty()) {
            Node* tmp = q.front().first;
            int level = q.front().second;
            q.pop();
            if (level > curr_level) {
                to_return.push_back(vec);
                vec.clear();
                curr_level = level;
            }
            for (auto n : tmp->children) {
                vec.push_back(n->val);
                q.push(make_pair(n, curr_level + 1));
            }
        }
        return to_return;
    }
};
// @lc code=end

