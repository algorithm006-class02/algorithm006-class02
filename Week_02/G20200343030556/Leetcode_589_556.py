"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """

        # 法一： 递归
        if root is None:
            return []
        res = []
        res.append(root.val)
        for child in root.children:
            res.extend(self.preorder(child))
            # res += self.preorder(child)
        return res

        # 法二：迭代，利用栈先进后出的特性（故推入栈的顺序应为v3,v2,v1）
        # v3,v2,v1为子节点
        if root is None:
            return []
        stack,output = [root,], []
        while stack:
            root = stack.pop()
            output.append(root.val)
            stack.extend(root.children[::-1])
        return output