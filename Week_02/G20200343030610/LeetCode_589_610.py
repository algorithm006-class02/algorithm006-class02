"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

#思路 递归和迭代两种方法
#迭代  后序遍历  左右根
#1.先遍历一个节点的所有子节点，载遍历这个节点本身
# root -> v1,v2,v3   后续遍历的顺序
#cv1,v1,cv2,v2,cv3,v3 ,root
#反转后  root,v3,cv3，v2，cv2，v1，cv1 【类似前序遍历 根左右，只是反转后是跟右左】 此处想到将前序遍历的左右反转成右左 即还原了 后续遍历的逆序的结果。


#前序遍历的子节点顺序反转 再整体反转即得到后续遍历

#前序遍历的实现？理解
class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype List(int)
        """
        if root is None:
            return []
        stack, output = [root, ] ,[]
        while stack:
            root = stack.pop()
            output.append(root.val)
            stack.extend(root.children[::-1]
        return output


#递归实现

#迭代
