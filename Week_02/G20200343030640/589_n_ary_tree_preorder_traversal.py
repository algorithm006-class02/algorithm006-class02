# py3

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def __init__(self):
        self.nodes = []
        self.stack = []

    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []

        # 1. 递归
        # self.nodes.append(root.val)
        # for child in root.children:
        #     self.preorder(child)
        
        # return self.nodes

        # 2. 迭代
        self.stack.append(root)
        while self.stack:
            node = self.stack.pop()
            self.nodes.append(node.val)
            self.stack.extend(node.children[::-1])
        return self.nodes




