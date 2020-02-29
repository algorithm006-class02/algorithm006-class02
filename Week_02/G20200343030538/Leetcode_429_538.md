[N-ary Tree Level Order Traversal](https://leetcode.com/problems/n-ary-tree-level-order-traversal/)  

需要用一个level来表示当前的层数，知道节点在哪一层并确保在那一层的列表顺序  
#### 题解  
```Python
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[int]:
        result = []

        def traverse(node, level):
            if len(result) == level:
                result.append([])

            result[level].append(node.val)
            for child in node.children:
                traverse(child, level + 1)

        if root is not None:
            traverse(root, 0)

        return result


def main():
    solution = Solution()

    c = Node(2, [])
    d = Node(4, [])
    e = Node(5, [])
    f = Node(6, [])
    b = Node(3, [e, f])
    root = Node(1, [b, c, d])
    result = solution.levelOrder(root)
    print(result)


if __name__ == '__main__':
    main()
```

```C++
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

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

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (!root) {
            return res;
        }
        helper(root, 0, res);
        return res;
    }

    void helper(Node* node, int level, vector<vector<int>>& res)
    {
        if (res.size() <= level) {
            res.resize(res.size() + 1);
        }
        res[level].push_back(node->val);
        for(auto i : node->children) {
            helper(i, level + 1, res);
        }
    }
};

void printf_node(vector<vector<int>> v)
{
    for (size_t i = 0; i < v.size(); i++) {
        for (size_t j = 0; j < v[i].size(); j++) {
            cout << v[i][j] << endl;
        }
    }
}

int main(int argc, const char * argv[])
{
    Solution s;
    Node *p1 = new Node(3, vector<Node*>({new Node(5, vector<Node*>()), new Node(6, vector<Node*>())}));
    Node *p2 = new Node(2, vector<Node*>({}));
    Node *p3 = new Node(4, vector<Node*>({}));
    Node *root = new Node(1, vector<Node*>({p1, p2, p3}));

    vector<vector<int>> result = s.levelOrder(root);
    printf_node(result);
    return 0;
}
```
