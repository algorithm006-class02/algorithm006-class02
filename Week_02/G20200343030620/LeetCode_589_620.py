"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        """
        # 思路1：使用递归的思想求解
        res=[]
        def dfs(root):
            if root:
                res.append(root.val)
                for  c in root.children:
                    dfs(c)
        dfs(root)
        return res
        """
        # 思路2：使用栈的思想求解
        res = []
        stack = [root, ]
        while stack:
            cur = stack.pop()
            if cur:
                res.append(cur.val)
                # 技巧点，将所有孩子节点逆序压入栈中
                stack.extend(cur.children[::-1])
        return res
