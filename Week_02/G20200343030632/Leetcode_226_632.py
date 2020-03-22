# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        # return self.invertTree_v1(root)
        # return self.invertTree_v2(root)
        return self.invertTree_v3(root)
    
    def invertTree_v1(self, root: TreeNode) -> TreeNode:
        self.helper(root)
        return root
    
    def helper(self, node: TreeNode):
        if node:
            node.left, node.right = node.right, node.left
            self.helper(node.left)
            self.helper(node.right)

    def invertTree_v2(self, root: TreeNode) -> TreeNode:
        if root:
            invert = self.invertTree_v2
            root.left = invert(root.right)
            root.right = invert(root.left)
            return root
    
    def invertTree_v3(self, root: TreeNode) -> TreeNode:
        # 迭代
        stack = [root]
        while stack:
            cur = stack.pop()
            if cur:
                cur.left, cur.right = cur.right, cur.left
                stack.append(cur.left)
                stack.append(cur.right)
        return root