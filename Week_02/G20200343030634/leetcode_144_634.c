/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
typedef struct retTag
{
    int* vList;
    int len;
}retType;

void Dfs(struct TreeNode* node,retType *retInfo)
{
    retInfo->vList[retInfo->len]=node->val;
    retInfo->len++;
    if (node->left!=NULL)
    {
        Dfs(node->left, retInfo);
    }
    if (node->right!=NULL)
    {
        Dfs(node->right, retInfo);
    }

}

int* preorderTraversal(struct TreeNode* root, int* returnSize){
    if(root==NULL)
    {
        *returnSize=0;
        return NULL;
    }
    retType retInfo = {0};
    retInfo.vList = (int*)malloc(sizeof(int)*10000);
    retInfo.len = 0;
    Dfs(root,&retInfo);
    *returnSize = retInfo.len;
    return retInfo.vList;
}