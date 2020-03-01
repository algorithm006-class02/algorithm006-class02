# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        def levelOrderE(root, level: int):
            if not root:
                return
            if len(res) > level:
                sub = res[level]
                sub.append(root.val)
                res[level] = sub
            else:
                sub = [root.val]
                res.append(sub)
            for child in root.children:
                levelOrderE(child, level + 1)
        levelOrderE(root, 0)
        return res
