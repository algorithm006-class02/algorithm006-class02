#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
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
    def preorder(self, root: 'Node') -> List[int]:
        return self.preorder_v2(root)
    def preorder_v1(self, root: 'Node') -> List[int]:
        res = []
        def helper(root: 'Node', res: List[int]):
            if root:
                res.append(root.val)
                for child in root.children:
                    helper(child, res)
        helper(root, res)
        return res
    def preorder_v2(self, root):
        res, stack = [], root and [root]
        while stack:
            cur = stack.pop()
            res.append(cur.val)
            stack += [child for child in cur.children[::-1] if child]
        return res
        
# @lc code=end

