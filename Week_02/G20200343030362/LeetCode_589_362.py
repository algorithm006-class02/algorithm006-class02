# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        ret = []
        def preorderE(root):
            if not root:
                return
            ret.append(root.val)
            for child in root.children:
                preorderE(child)
        preorderE(root)
        return ret