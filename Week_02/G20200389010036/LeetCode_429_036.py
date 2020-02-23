# https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root: return 
        self.res = []
        self._dfs(root,0)
        return self.res

    def _dfs(self, node, level):
        if not node: return

        if len(self.res) < level+1:
            self.res.append([])
        self.res[level].append(node.val)
        for chil in node.children:
            self._dfs(chil,level+1)

# class Solution:
#     def levelOrder(self, root: 'Node') -> List[List[int]]:
#         if not root: return []

#         res = []
#         queue = collections.deque()
#         queue.append(root)

#         while queue:
#             level_size = len(queue)
#             curr_level = []

#             for _ in range(level_size):
#                 node = queue.popleft()
#                 curr_level.append(node.val)
#                 for chil in node.children:
#                     queue.append(chil)
#             res.append(curr_level)
    
#         return res

# class Solution:
#     def levelOrder(self, root: 'Node') -> List[List[int]]:
#         if not root: return []

#         res = []
#         queue = []
#         queue.append(root)

#         while queue:
#             level_size = len(queue)
#             curr_level = []

#             for _ in range(level_size):
#                 node = queue.pop(0)
#                 curr_level.append(node.val)
#                 for chil in node.children:
#                     queue.append(chil)
#             res.append(curr_level)
    
#         return res