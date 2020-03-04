"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """

        # 法一：同二叉树的后序递归遍历
        if root is None:
            return []
        res = []
        for child in root.children:
            res.extend(self.postorder(child))
        res.append(root.val)
        return res

        # dfs：列表推导式
        # res, stack = [], [root,]
        # while stack:
        #     node = stack.pop()
        #     res.append(node.val)
        #     stack.extend([child for child in node.children if child])
        # return ret[::-1]

        # 法二：迭代法，还没看懂，记录如下：
        # if root is None:
        #     return []
        
        # stack, output = [root, ], []
        # while stack:
        #     root = stack.pop()
        #     if root is not None:
        #         output.append(root.val)
        #     for c in root.children:
        #         stack.append(c)
                
        # return output[::-1]
