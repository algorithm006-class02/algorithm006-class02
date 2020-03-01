#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
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
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        return self.levelOrder_v1(root)
    
    def levelOrder_v1(self, root: 'Node') -> List[List[int]]:
        res = []

        def helper(node: 'Node', level: int):
            if len(res) == level:
                res.append([])
            res[level].append(node.val)
            for child in node.children:
                helper(child, level + 1)
        if root:
            helper(root, 0)
        return res

# @lc code=end

