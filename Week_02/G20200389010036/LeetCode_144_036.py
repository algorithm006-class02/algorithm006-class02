# https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        stack, res = [root], []

        while stack:
            curr = stack.pop()
            res.append(curr.val)
            if curr.right: stack.append(curr.right)
            if curr.left: stack.append(curr.left)
        return res


# class Solution:
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         list = []

#         def _pro(root: TreeNode):
#             if not root:
#                 return
            
#             list.append(root.val)
#             _pro(root.left)
#             _pro(root.right)
        
#         _pro(root)
#         return list