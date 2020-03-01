//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
// 说明:
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

//leetcode submit region begin(Prohibit modification and deletion)
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

/*

class Solution1 {
public:
    vector <vector<int>> ans;

    vector <vector<int>> levelOrder(Node *root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(Node *root, int dep) {
        if (!root) return;
        if (dep == ans.size())
            ans.emplace_back();
        ans[dep].push_back(root->val);
        auto      children = root->children;
        for (auto ele:children) {
            dfs(ele, dep + 1);
        }
    }
};

 */
class Solution {
public:
    vector <vector<int>> levelOrder(Node *root) {
        vector <vector<int>> ans;
        queue < Node * > q;
        if (!root) return ans;
        q.push(root);
        while (!q.empty()) {
            int         size = q.size();
            vector<int> cur;

            for (int i = 0; i < size; i++) {
                Node *front = q.front();
                q.pop();
                cur.push_back(front->val);
                for (auto item : front->children) {
                    q.push(item);
                }
            }
            ans.push_back(cur);
        }
        return ans;
    }
};

//leetcode submit region end(Prohibit modification and deletion)
