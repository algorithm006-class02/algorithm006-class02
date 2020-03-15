#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # return self.inorderTraversal_v1(root)
        # return self.inorderTraversal_v2(root)
        return self.inorderTraversal_v3(root)
    def inorderTraversal_v1(self, root: TreeNode) -> List[int]:
        res = []
        def helper(root: TreeNode, res: List):
            if root:
                helper(root.left, res)
                res.append(root.val)
                helper(root.right, res)
        helper(root, res)
        return res
    
    def inorderTraversal_v2(self, root: TreeNode) -> List[int]:
        """
            迭代做法, 利用栈, 使用标记的方法
            1. 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
            2. 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈
            3. 如果遇到的节点为灰色，则将节点的值输出
        """
        stack = []
        res = []
        white, gray = 0, 1
        stack.append((white, root))
        while stack:
            color, node = stack.pop()
            if node is None: 
                continue
            if color == white:
                stack.append((white, node.right))
                stack.append((gray, node))
                stack.append((white, node.left))
            else:
                res.append(node.val)
        
        return res


    def inorderTraversal_v3(self, root: TreeNode) -> List[int]:
        stack, res = [], []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            res.append(root.val)
            root = root.right
        return res



        
# @lc code=end

