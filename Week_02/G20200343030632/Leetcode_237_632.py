# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.lowestCommonAncestor_v1(root, p, q)

    def lowestCommonAncestor_v1(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # 从根节点出发遍历
        # 如果当前节点的左子树包含p, q 则LCA节点一定在左子树, 继续遍历左子树
        # 如果当前节点的右子树包含p, q 则LCA节点一定在右子树, 继续遍历右子树
        # 如果p, q分别在当前节点左子树和右子树, 则当前节点为LCA节点
        self.helper(0, root, p, q)
        pass
    
    def helper(self, level, node, p, q):


