def preorderTraversal(self, root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """
    ret = []
    stack = [root]
    while stack:
        node = stack.pop()
        if node:
            ret.append(node.val)
            stack.append(node.right)
            stack.append(node.left)
    return ret