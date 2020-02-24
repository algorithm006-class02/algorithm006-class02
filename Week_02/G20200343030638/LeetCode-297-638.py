# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def reserialize(root, s):
            if root is None:
                s += 'None,'
            else:
                s += str(root.val) + ','
                s = reserialize(root.left, s)
                s = reserialize(root.right, s)
            return s

        return reserialize(root, '')

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def rdeserialize(l):
            if not l:
                return None

            if l[0] == 'None':
                l.pop(0)
                return None
            
            root = TreeNode(l[0])
            l.pop(0)
            root.left = rdeserialize(l)
            root.right = rdeserialize(l)
            return root
        
        data_list = data.split(',')
        root = rdeserialize(data_list)
        return root       

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))