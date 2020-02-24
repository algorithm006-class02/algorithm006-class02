# https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        res, stack = [], [root]
        while stack:
            cur = stack.pop()
            res.append(cur.val)
            stack.extend(cur.children)
        return res[::-1]
        

# class Solution:
#     def postorder(self, root: 'Node') -> List[int]:
#         if not root:
#             return []
#         res = []
        
#         def post(root: 'Node'):
#             for n in root.children:
#                 post(n)
#             res.append(root.val)
        
#         post(root)
#         return res

# class Solution:
#     def postorder(self, root: 'Node') -> List[int]:
#         if not root:
#             return []
#         res = []
        
#         def post(root: 'Node'):
#             if not root:
#                 return
#             for n in root.children:
#                 post(n)
#             res.append(root.val)
        
#         post(root)
#         return res