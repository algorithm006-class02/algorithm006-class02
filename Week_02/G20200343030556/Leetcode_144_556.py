# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        # 法一：迭代
        if not root:
            return []

        stack, res = [root,], [] 
        while stack:
            node = stack.pop()
            res.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        
        return res

        # 法二：递归
        # res = []
        # def helper(root):
        #     res.append(root.val)
        #     helper(root.left)
        #     helper(root.right)
        
        # helper(root)
        # return res