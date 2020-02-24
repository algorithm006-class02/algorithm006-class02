[N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)  

和590题的后序遍历基本没啥变化，代码只改一行:  
#### 题解  
```Python
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        if not root:
            return res

        res.append(root.val)
        for child in root.children:
            res.extend(self.preorder(child))

        return res


def main():
    solution = Solution()

    c = Node(2, [])
    d = Node(4, [])
    e = Node(5, [])
    f = Node(6, [])
    b = Node(3, [e, f])
    root = Node(1, [b, c, d])
    result = solution.preorder(root)
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
    vector<int> postorder(Node* root) {
        vector<int> res;
        helper(root, res);
        return res;
    }

    void helper(Node* node, vector<int>& res) {
        if (!node) {
            return;
        }

        res.push_back(node->val);

        for (auto child : node->children) {
            helper(child, res);
        }
    }
};

void printf_node(vector<int> v)
{
    for (size_t i = 0; i < v.size(); i++) {
        cout << v[i] << endl;
    }
}

int main(int argc, const char * argv[])
{
    Solution s;
    Node *p1 = new Node(3, vector<Node*>({new Node(5, vector<Node*>()), new Node(6, vector<Node*>())}));
    Node *p2 = new Node(2, vector<Node*>({}));
    Node *p3 = new Node(4, vector<Node*>({}));
    Node *root = new Node(1, vector<Node*>({p1, p2, p3}));

    vector<int> result = s.postorder(root);
    printf_node(result);
    return 0;
}
```
