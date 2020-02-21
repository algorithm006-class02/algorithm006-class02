### description

Binary Tree Inorder Traversal
Category	Difficulty	Likes	Dislikes
algorithms	Medium (60.71%)	2474	103
Tags
Companies
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

### methods 1 while loop with stack
```python
#
# @lc app=leetcode id=94 lang=python
#
# [94] Binary Tree Inorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        stack,ans = [],[]
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack:
                return ans
            cur  = stack.pop()
            ans.append(cur.val)
            root = cur.right
            

```

# methods2:
using  Recursive solution
```python
def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []

        def helper(res,root):
            if not root: return
            helper(res,root.left)
            res.append(root.val)
            helper(res,root.right)
        helper(res,root)
        return res 
```



##### 学习一下 top solution



```java
pulic List<Interger> inorderTraversal(TreeNode root){
    List<Interger> list = new ArrayList<> ();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;
    while(cur != null || !stack.empty()){
        while(cur!= null){
            stack.add(cur)
            cur = cur.left
        }
        cur = stack.pop()
        list.add(cur.val)
        cur = cur.right
    }
    return list;
}

```
[c++](https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31231/C%2B%2B-Iterative-Recursive-and-Morris) 

```c++
class Solution{
    public:
    vector<int> inorderTraversal(TreeNode root){
        vector<int> nodes;
        stack<TreeNode *> todo;
        while(root|| !todo.empty()){
            while(root){
                todo.push(toot);
                root = root -> left;
            }
            root = todo.top()
            todo.pop();
            nodes.push_back(root -> val);
            root = root->right;
        }
        return nodes
    }
}
```

```c++
// morris
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> nodes;
        while (root) {
            if (root -> left) {
                TreeNode* pre = root -> left;
                while (pre -> right && pre -> right != root) {
                    pre = pre -> right;
                }
                if (!pre -> right) {
                    pre -> right = root;
                    root = root -> left;
                } else {
                    pre -> right = NULL;
                    nodes.push_back(root -> val);
                    root = root -> right;
                }
            } else {
                nodes.push_back(root -> val);
                root = root -> right;
            }
        }
        return nodes;
    }
};
```

