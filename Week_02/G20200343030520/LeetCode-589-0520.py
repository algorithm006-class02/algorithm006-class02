
from typing import List
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    """ Given an n-ary tree, return the preorder traversal of its nodes' values.

        N-ary Tree input serialization is represented in their level order traversal, 
        each group of children is separated by the null value (See examples).

        Follow up:
        Recursive solution is trivial, could you do it iteratively?

        Example:
            Input: root = [1,null,3,2,4,null,5,6]
            Output: [1,3,5,6,2,4]
    """
    def preorder(self, root: Node) -> List[int]:

        if not root:
            return []

        stack = [root, ]
        output = []

        while stack:
            root = stack.pop()
            output.append(root.val)
            stack.extend(root.children[::-1])

        return output