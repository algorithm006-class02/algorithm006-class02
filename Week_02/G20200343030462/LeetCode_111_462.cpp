class Solution {
public:
    //题目里说最小深度是从根结点出发到最近叶子结点经过的节点数目，而叶子结点的定义是没有左孩子也没有右孩子
    int minDepth(TreeNode* root) {
        if(nullptr == root)
            return 0;
        
        int iLeftTreeHeight = minDepth(root->left);
        int iRightTreeHeight = minDepth(root->right);
        
        //如果当前结点的左孩子或者右孩子为空，那么按照递归的终止条件，那么左树和右树必然有一个的高度是0，另外按照题目的意思，在这种情况下我们应该找的是左树或子树中较高的那一个
        if(nullptr == root->left || nullptr == root->right) 
            return iLeftTreeHeight + iRightTreeHeight + 1;
        
        //否则取较小的高度
        return (iLeftTreeHeight < iRightTreeHeight ? iLeftTreeHeight : iRightTreeHeight) + 1;
    }
};
