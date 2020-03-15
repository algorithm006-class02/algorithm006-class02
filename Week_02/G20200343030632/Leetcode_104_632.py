# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # return self.maxDepth_v1(root)
        return self.maxDepth_v2(root)
    def maxDepth_v1(self, root: TreeNode) -> int:
        return self.helper(root, 0)
    def helper(self, node: TreeNode, level: int):
        if node:
            return max(self.helper(node.right, level + 1), self.helper(node.left, level + 1))
        return level

    def maxDepth_v2(self, root: TreeNode) -> int:
        # 迭代
        queue, res = [root] if root else [], 0
        while queue:
            res += 1
            for i in range(len(queue)):
                cur = queue.pop(0)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
        return res


