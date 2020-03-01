# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        """
        # 使用递归的思想求解
        res=[]
        def dfs(root):
            if not root:
                return
            res.append(root.val)
            dfs(root.left)
            dfs(root.right)
        # 遍历函数的调用
        dfs(root)
        return res
        """
        # 思路2： 使用栈的思想求解
        res = []
        stack = []
        cur = root
        while cur or stack:
            while cur:
                res.append(cur.val)
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            cur = cur.right
        return res
