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
        res = []
        def helper(root: 'Node', res: List[int]):
            if root:
                for child in root.children:
                    helper(child, res)
                res.append(root.val)
        helper(root, res)
        return res
        
# @lc code=end

