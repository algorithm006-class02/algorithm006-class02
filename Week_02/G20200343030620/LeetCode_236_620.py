# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # clarification:p 和q 是否都为每个节点的孩子节点，注意：一个节点为其另一个节点父节点的情况
        # 思路1： 递归的思想，当找到一个节点之后，就需要去判断其另一个节点是否为于该节点或父节点的孩子节点。 变量一个节点使用前序变量法。

        # 拿到一个节点，就递归的判断，p,q 是否在其孩子节点中
        self.ans = root

        def dfs(root: 'TreeNode'):
            if not root:
                return False
            left = dfs(root.left)
            right = dfs(root.right)
            mid = root == p or root == q
            if mid + left + right >= 2:
                self.ans = root
            return mid or left or right

        dfs(root)
        return self.ans