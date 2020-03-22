# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # return self.isValidBST_v1(root)
        return self.isValidBST_v2(root)

    def isValidBST_v1(self, root: TreeNode) -> bool:
        return self.helper(root, float('-inf'), float('inf'))
    def helper(self, node, min_val, max_val):
        if node:
            if node.val <= min_val or node.val >= max_val:
                return False
            
            return self.helper(node.left, min_val, node.val) and self.helper(node.right, node.val, max_val)
        return True
        

    def isValidBST_v2(self, root: TreeNode) -> bool:
        # 迭代, bst 中序遍历是递增的特性
        stack, pre = [], None
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if pre and pre.val >= root.val:
                return False
            pre = root
            root = root.right

        return True

