# https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':        

#         def helper(node, l, r):
#             if(node == None or node == r or node == l): return node
#             left = helper(node.left, l, r)
#             right = helper(node.right, l, r)
#             if left == None:
#                 return right
#             elif right == None:
#                 return left
#             else:
#                 return node
#         return helper(root,p,q)

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':        

        def helper(node, l, r):
            if(node == None or node == r or node == l): return node
            left = helper(node.left, l, r)
            right = helper(node.right, l, r)
            if left and right:
                return node
            return left if left else right
        return helper(root,p,q)

# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

#         def search(n, p, q):
#             if n == None or n==p or n==q:
#                 return n
#             l = search(n.left, p, q)
#             r = search(n.right, p, q)
#             if l and r:
#                 return n
#             return l if l else r

#         return search(root, p, q)
