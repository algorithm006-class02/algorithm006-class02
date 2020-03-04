#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # return self.preorderTraversal_v1(root)
        return self.preorderTraversal_v2(root)

    def preorderTraversal_v1(self, root: TreeNode) -> List[int]:
        res = []
        def helper(root: TreeNode, res: List[int]):
            if root:
                res.append(root.val)
                helper(root.left, res)
                helper(root.right, res)
        helper(root, res)
        return res

    def preorderTraversal_v2(self, root: TreeNode) -> List[int]:
        """
            迭代做法, 利用栈.
            前序遍历的进栈顺序是先右, 左, 根
        """
        stack, res = [], []
        white, gray = 0, 1
        stack.append((white, root))
        while stack:
            color, node = stack.pop()
            if node is None:
                continue
            if color == white:
                stack.append((white, node.right))
                stack.append((white, node.left))
                stack.append((gray, node))
            else:
                res.append(node.val)
        return res







# @lc code=end

