int Dfs(struct TreeNode* node, struct TreeNode* p, struct TreeNode* q,struct TreeNode **ret)
{
    if(node==NULL)
    {
        return 0;
    }
    int mid=0;
    if ((node->val==p->val)||(node->val==q->val)) {
        mid=1;
    }
    int left = Dfs(node->left,p,q,ret);
    if(left==100)
    {
        return 100;
    }
    int right = Dfs(node->right,p,q,ret);
    if(right==100)
    {
        return 100;
    }
    
    int sum = mid+left+right;
    
    if(sum>=2)
    {
  
        *ret= node;
        return  100;
    }else if(sum>=1)
    {
        return 1;
    }
    return 0;
}
struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {

   
    struct TreeNode *ret;
    Dfs(root,p,q,&ret);
    
    return ret;
    
}