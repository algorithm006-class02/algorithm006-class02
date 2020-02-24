# https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# class Solution:
#     def preorder(self, root: 'Node') -> List[int]:
#         if not root:
#             return []
#         res = []

#         def _pre(root: 'Node'):
#             res.append(root.val)
#             for node in root.children:
#                 _pre(node)
#         _pre(root)
#         return res

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        res, stack = [], [root]

        while stack:
            curr = stack.pop()
            res.append(curr.val)
            stack.extend(curr.children[::-1])
        return res