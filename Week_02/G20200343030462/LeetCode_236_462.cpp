class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q){
        if(!root)
            return nullptr;
        if(root == p)
            return p;
        if(root == q)
            return q;
        //在左树上搜索p和q
        TreeNode *pLeft = lowestCommonAncestor(root->left,p,q);     //返回的就是找到的p或者q
        //在右树上搜索p和q
        TreeNode *pRight = lowestCommonAncestor(root->right,p,q);
        
        if(pLeft && pRight)
            return root;            //注意，理解好递归，这个root只代表参数名，而不是实际意义上输入树的根
        if(pLeft)
            return pLeft;
        return pRight;
    }
};
