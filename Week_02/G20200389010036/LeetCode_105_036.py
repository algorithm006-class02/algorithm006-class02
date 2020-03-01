# https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if inorder:
            curr = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[curr])
            root.left = self.buildTree(preorder, inorder[0:curr])
            root.right = self.buildTree(preorder, inorder[curr+1:])

            return root