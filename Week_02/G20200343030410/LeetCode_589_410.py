class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        list = []
        list.append(root.val)
        if root.children:
            for item in root.children:
                list += self.preorder(item)
        return list
