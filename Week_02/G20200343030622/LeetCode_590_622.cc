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
    void postOrder_r(Node *root, std::vector<int> &result)
    {
        if (root == nullptr)
            return;

        for (int i = 0; i < root->children.size(); i++)
        {
            Node *child = root->children[i];
            postOrder_r(child, result);
        }

        result.push_back(root->val);
    }

    void postorder_iter(Node *root, std::vector<int> &result)
    {
        stack<Node *> _stack;

        if (root == nullptr)
            return;

        _stack.push(root);
        while (!_stack.empty())
        {
            Node *node = _stack.top();
            _stack.pop();

            if (node == nullptr)
                continue;

            for (Node *child : node->children)
                _stack.push(child);

            result.push_back(node->val);
        }

        reverse(result.begin(), result.end());
        return;
    }

    vector<int> postorder(Node *root)
    {
        vector<int> result{};
        postorder_iter(root, result);
        return result;
    }
};