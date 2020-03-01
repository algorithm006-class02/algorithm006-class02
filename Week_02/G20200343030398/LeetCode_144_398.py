import collections

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# 时间复杂度O(N) N节点总个数
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = collections.UserList()
        if (not root):
            return result
        result.append(root.val)
        result.extend(self.preorderTraversal(root.left))
        result.extend(self.preorderTraversal(root.right))
        return result
