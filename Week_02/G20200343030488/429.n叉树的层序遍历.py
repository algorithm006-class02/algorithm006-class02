#
# @lc app=leetcode.cn id=429 lang=python
#
# [429] N叉树的层序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        result = []
        def traverse_node(node,level):
            if len(result)==level:
                result.append([])
            result[level].append(node.val)
            for child in node.children:
                traverse_node(child,level+1)
        if root is not None:
            traverse_node(root,0)
        return result


        
# @lc code=end

