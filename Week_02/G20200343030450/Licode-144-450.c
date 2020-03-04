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

 preorder(struct TreeNode* root, int* returnSize,int *a){
     if(!root) return;
     a[*returnSize]=root->val;
     *returnSize=*returnSize+1;
     preorder(root->left,returnSize,a);
     preorder(root->right,returnSize,a);
 }
int* preorderTraversal(struct TreeNode* root, int* returnSize){
     int *a=(int*)malloc(sizeof(int)*1000);
     *returnSize=0;
     preorder(root,returnSize,a);
     return a;
}