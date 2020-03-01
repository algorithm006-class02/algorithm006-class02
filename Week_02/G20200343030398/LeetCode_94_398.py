# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 时间复杂度O(N) N节点总个数
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        if (not root):
            return result
        result.extend(self.inorderTraversal(root.left))
        result.append(root.val)
        result.extend(self.inorderTraversal(root.right))
        return result


# 讨论区解法
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
