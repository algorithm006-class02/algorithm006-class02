from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    """ Given a binary tree, return the inorder traversal of its nodes' values.

        Example:
            Input: [1,null,2,3]
                1
                    \
                    2
                    /
                3

            Output: [1,3,2]

        Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

    """
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self.traverse(root, result)
        return result

    def traverse(self, root, result) -> None:

        if root:
            self.traverse(root.left, result)
            result.append(root.val)
            self.traverse(root.right, result)

if __name__ == "__main__":
    pass
        