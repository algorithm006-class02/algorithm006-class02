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
class Solution
{
public:
    void levelOrderTraversalHelper(vector<vector<int>> &result, Node *node, int level)
    {
        if (level >= result.size())
        {
            result.push_back(vector<int>());
        }

        for (Node *child : node->children)
        {
            if (child != nullptr)
                levelOrderTraversalHelper(result, child, level + 1);
        }

        result[level].push_back(node->val);
    }

    vector<vector<int>> levelOrder(Node *root)
    {
        vector<vector<int>> result{};
        if (root == nullptr)
        {
            return result;
        }

        levelOrderTraversalHelper(result, root, 0);
        return result;
    }
};