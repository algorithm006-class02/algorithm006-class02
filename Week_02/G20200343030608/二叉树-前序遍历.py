class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        st=[(root,False)]
        res=[]
        while st:
            cur,vis=st.pop()
            if vis:
                res.append(cur.val)
            else:
                if cur.right:
                    st.append((cur.right,False))
                if cur.left:
                    st.append((cur.left,False))
                st.append((cur,True))
        return res