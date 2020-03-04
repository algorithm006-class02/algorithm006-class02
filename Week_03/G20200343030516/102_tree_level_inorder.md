## description

102. 二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

## solution

recursion

```python
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        def helper(root,level):
            if not root:return
            if level == len(res):
                res.append([])
            res[level].append(root.val)
            if root.left:
                helper(root.left,level+1)
            if root.right:
                helper(root.right,level+1)
        helper(root,0)
        return res
```
