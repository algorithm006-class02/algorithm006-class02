# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.res = []

    def preorderTraversal(self, root: TreeNode) -> List[int]:
        self._preorder(root)
        return self.res
    
    def _preorder(self, root: TreeNode):
        if root:
            self.res.append(root.val)
            self._preorder(root.left)
            self._preorder(root.right)