class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || inorder.empty())
            return nullptr;
        if(preorder.size() != inorder.size())
            return nullptr;
        return buildTree(0,0,preorder.size() - 1,preorder,inorder);
    }
private:
    TreeNode* buildTree(int iLeft,int iRoot,int iRight,const std::vector<int> &preorder,const std::vector<int> &inorder)
    {
        if(iLeft > iRight)   //当iLeft和iRight相等时对应的是叶子结点
            return nullptr;
        int i = iLeft;
        while(i < iRight && inorder[i] != preorder[iRoot])
            ++i;        
        TreeNode *pRoot = new TreeNode(preorder[iRoot]);
        //构建以pRoot为根的左子树
        pRoot->left = buildTree(iLeft,iRoot + 1, i -1,preorder,inorder);
        //构建以pRoot为根的右子树
        pRoot->right = buildTree(i + 1,iRoot + 1 + i - iLeft,iRight,preorder,inorder);
        return pRoot;
    }
};
