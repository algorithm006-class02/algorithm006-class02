#!/usr/bin/env python

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        def helper(root):
            if not root:
                return 
            helper(root.left)
            res.append(root.val)
            helper(root.right)
        helper(root)
        return res



"""
思路：
其实明白了二叉树遍历就很容易了。
二叉树遍历的方法：(前后中)序方法
https://www.bilibili.com/video/av44373042?from=search&seid=17697122351619518914

     a

   b     c
  e f   g h

中序
ebfagch

迭代还还有点郁闷，再看
"""