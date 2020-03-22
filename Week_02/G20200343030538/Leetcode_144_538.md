[Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)  

#### 题解
```Python
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res

        res.append(root.val)
        if root.left:
            res.extend(self.preorderTraversal(root.left))
        if root.right:
            res.extend(self.preorderTraversal(root.right))
        return res


def main():
    solution = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)
    result = solution.preorderTraversal(root)
    print(result)


if __name__ == '__main__':
    main()
```

```C++
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        preorder(root, res);
        return res;
    }

    void preorder(TreeNode* root, vector<int>& res) {
        if (!root) {
            return;
        }
        res.push_back(root->val);
        preorder(root->left, res);
        preorder(root->right, res);
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
    TreeNode* p1 = new TreeNode(1);
    TreeNode* p2 = new TreeNode(2);
    TreeNode* p3 = new TreeNode(3);
    p1->right = p2;
    p2->left = p3;

    vector<int> res = s.preorderTraversal(p1);
    printf_node(res);
    return 0;
}
```
