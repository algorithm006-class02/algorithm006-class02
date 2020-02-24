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
#class Solution(object):
#    def preorder(self, root):
#        """
#        :type root: Node
#        :rtype List(int)
#        if root is None:
#            return []
#        stack, output = [root, ], []
#        while stack:
#            root = stack.pop() #根弹出，如果是子节点 是弹出左子树，因此 栈是先压入右子树
#            output.append(root.val)
#            stack.extend(root.children[::-1] #此处对应栈的pop 反向弹出左子树
#        return output

#后序遍历  左右根  》跟右左》  跟左右  有一个部分子树反转得出跟前序遍历的关系
#前序遍历修改子树顺序得到 根右左  反转结果即为后序遍历

#递归实现

#迭代
class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if root == None:
            return []
        stack , output = [root, ], []
        while stack:
            root = stack.pop()
            if root is not None:
                output.append(root.val)
            for c in root.children:
                stack.append(c)
        return output[::-1]
