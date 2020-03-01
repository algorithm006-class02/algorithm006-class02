#
# @lc app=leetcode.cn id=236 lang=python
#
# [236] 二叉树的最近公共祖先
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        if root in (None,p,q):
            return root
        L = self.lowestCommonAncestor(root.left,p,q)
        R = self.lowestCommonAncestor(root.right,p,q)

        return R if None==L else L if None==R else root

# @lc code=end

