"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

#时间复杂度O(n),n所有节点个数
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        
        def helper(curLevelRoots):
            if (not len(curLevelRoots)):
                return
            curRst = []
            nextLevelRoots = []
            for curRoot in curLevelRoots:
                curRst.append(curRoot.val)
                nextLevelRoots.extend(curRoot.children)
            rst.append(curRst)
            helper(nextLevelRoots)
        
        rst = []

        if (root):
            helper([root])

        return rst


# 官方，代码更简洁，临时数组更少，自己的extend等数据操作底层应该耗时不少
def levelOrder(self, root: 'Node') -> List[List[int]]:

    def traverse_node(node, level):
        if len(result) == level:
            result.append([])
        result[level].append(node.val)
        for child in node.children:
            traverse_node(child, level + 1)

    result = []

    if root is not None:
        traverse_node(root, 0)
    return result
