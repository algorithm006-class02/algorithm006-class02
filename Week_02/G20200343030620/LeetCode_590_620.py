"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        # clarification  children 存储结构是什么样的
        # positive resolution 递归遍历和使用栈来操作
        """
        思路1 :使用递归的思想求解
        res=[]
        def dfs(root):
            if not root:
                return
            for c in root.children:
                dfs(c)
            res.append(root.val)
        dfs(root)
        return res
        """

        """
        #使用两个栈来实现
        if root is None:
            return root
        stack1, stack2, result = [], [], []
        stack1.append(root)
        while stack1:
            node = stack1.pop()
            stack2.append(node)
            if node.children:
                stack1.extend(node.children)
        while stack2:
            top = stack2.pop()
            result.append(top.val)
        return result
        """

        res = []
        if not root:
            return []
        stack = [root, ]
        while stack:
            cur = stack.pop()
            res.append(cur.val)
            for c in cur.children:
                stack.append(c)
        return res[::-1]
