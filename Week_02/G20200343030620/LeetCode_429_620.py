"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        """
        # 错误的实现，在深度优先遍历的时候使用栈，而在广度优先遍历时候，使用队列来求解
        res=[]
        stack=[]
        cur=root

        while cur.children:
            stack.append(cur)
            for c in cur.children:
                cur=c
        while stack:
            cur=stack.pop()
            res.append([c.val for c in cur.children])
        res.append([cur.val])
        res.reverse()
        return res
        """
        """
        # 效率低下的实现，没有正确使用队列
        if not root:
            return [] 
        res=[[root.val]]
        que=[root,]
        while que:
            st=[]
            que_=[]
            for t in que:
                for c in t.children:
                    st.append(c.val)
                    que_.append(c)
            que=que_
            if st:
                res.append(st)
        return res
        #*************上述实现的代码改进***********
        if not root:
            return [] 
        res=[]
        current_layer=[root]
        while current_layer:
            res.append([])
            children_layer=[]
            for node in current_layer:
                res[-1].append(node.val)
                children_layer.extend(node.children)
                current_layer=children_layer
        return res 
     
        思路1：使用队列的思想来求解
        from collections import deque

        if not root:
            return []
        que = deque([root])
        res = []
        while que:
            level = []
            for _ in range(len(que)):
                node = que.popleft()
                level.append(node.val)
                que.extend(node.children)
            res.append(level)
        return res

        # 思路2 使用递归的思想来求解
        res=[]
        node=[root,]
        def bfs(node:List['Node']):
            if not node:
                return 
            level=[]
            values=[]
            for cur in node:
                if cur:
                    values.append(cur.val)
                    level.extend(cur.children)
            if values:
               res.append(values)
            bfs(level)
        bfs(node)
        return res 
        """

        # 思路2 递归实现中的优秀的代码实现
        res = []

        # 技巧点 记住节点属于哪个层，并将该元素存储到对应的数组中即可
        def traverse_node(cur, level):
            if len(res) == level:
                res.append([])
            res[level].append(cur.val)
            for node in cur.children:
                traverse_node(node, level + 1)

        if root:
            traverse_node(root, 0)
        return res
