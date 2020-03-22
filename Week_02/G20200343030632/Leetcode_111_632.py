# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        # return self.minDepth_v1(root)
        return self.minDepth_v2(root)
    
    def minDepth_v1(self, root: TreeNode) -> int:
        if not root:
            return 0
        if not root.left:
            return self.minDepth_v1(root.right) + 1
        if not root.right:
            return self.minDepth_v1(root.left) + 1
        return min(self.minDepth_v1(root.left), self.minDepth_v1(root.right)) + 1

    def minDepth_v2(self, root: TreeNode) -> int:
        if not root: return 0
        d = map(self.minDepth, (root.left, root.right))
        return 1 + (min(d) or max(d))
 