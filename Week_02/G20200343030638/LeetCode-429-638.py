"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return []

        res = []
        queue = [root]
        while queue:
            line = []
            new_queue = []
            for node in queue:
                if node:
                    line.append(node.val)
                    new_queue.extend(node.children)
            queue = new_queue
            res.append(line)
        return res