class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.empty() || postorder.empty())
            return nullptr;
        if(inorder.size() != postorder.size())
            return nullptr;
        return buildTree(0,postorder.size() - 1, inorder.size() - 1,inorder,postorder);
    }
private:
    TreeNode* buildTree(int iLeft,int iRoot,int iRight,std::vector<int> &inorder,std::vector<int> &postorder)
    {
        if(iLeft > iRight)
            return nullptr;
        TreeNode *pRoot = new TreeNode(postorder[iRoot]);
        //难处就在于递归方程（或者说是递归状态怎么变化）
        
        //先找到当前处理的子树的根结点在inorder中的位置
        int iRootInInorder = iLeft;         //子树的根结点在inorder中的索引
        while(iRootInInorder < iRight && inorder[iRootInInorder] != postorder[iRoot])
            ++iRootInInorder;
        //构建以pRoot为根结点的左子树
        pRoot->left = buildTree(iLeft, iRoot - 1 - (iRight - iRootInInorder)   ,iRootInInorder - 1,inorder,postorder);
        //构建以pRoot为根结点的右子树
        pRoot->right = buildTree(iRootInInorder + 1, iRoot - 1,iRight, inorder, postorder );
        return pRoot;
    }
};
