# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.isBST(root, float("-inf"), float("inf"))

    def isBST(self, root: TreeNode, min: float, max: float):
#       如果是二叉树，那么中序遍历可以得到从小到大的顺序。
#       在代码中，有几个边界要强调一下
#       当这个节点不存在的时候，就返回True。就代表父节点没有（左或右）孩子
#       初始化root的时候，它没有最大最小的限制
#       递归检查左右孩子，两个都为True才可以返回True

        if not root:
            return True

        if not min < root.val < max:
            return False

        return self.isBST(root.left, min, root.val) and self.isBST(root.right, root.val, max)