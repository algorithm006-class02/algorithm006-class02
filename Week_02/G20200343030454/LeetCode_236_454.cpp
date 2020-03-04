/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root){
            if(root==p||root==q)
                return root;
            TreeNode* l=lowestCommonAncestor(root->left,p,q);
            TreeNode* r=lowestCommonAncestor(root->right,p,q);
            if(l!=NULL&&r!=NULL)
                return root;
            else if(l!=NULL)
                return l;
            else if(r!=NULL)
                return r;
        }
        return NULL;
    }
};