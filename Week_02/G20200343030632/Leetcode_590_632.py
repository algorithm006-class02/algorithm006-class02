#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        return self.postorder_v2(root)
    def postorder_v1(self, root: 'Node') -> List[int]:
        res = []
        def helper(root: 'Node', res: List[int]):
            if root:
                for child in root.children:
                    helper(child, res)
                res.append(root.val)
        helper(root, res)
        return res

    def postorder_v2(self, root: 'Node') -> List[int]:
        res, stack = [], root and [root]
        while stack:
            cur = stack.pop()
            res.append(cur.val)
            stack += cur.children
        return res[::-1]



    
# @lc code=end

