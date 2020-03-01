/**
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};
/**
 * 二叉树的定义决定了其处理非常适合使用递归。待处理节点如果是p或q或NULL，直接返回待处理节点，
 * 否则递归其左子树和右子树，返回结果记为resLeft和resRight，氛围四种情况：
 * 1. resLeft和resRight均不为空，说明p和q分居待处理节点的左子树和右子树上，直接返回待处理节点；
 * 2. resLeft和resRight中有一个为空，一个不为空，则返回不为空的查找节点；
 * 3. resLeft和resRight均为空，说明未查找到p和q。
 */
struct TreeNode* lowestCommonAncestor(struct TreeNode* root, struct TreeNode* p, struct TreeNode* q) {
    if ((p == root) || (q == root) || (!root)) 
        return root; 
    struct TreeNode *resLeft = lowestCommonAncestor(root->left, p, q); 
    struct TreeNode *resRight = lowestCommonAncestor(root->right, p, q); 
    if (resLeft && resRight) 
        return root;
    else if (resLeft && (!resRight)) 
        return resLeft; 
    else if ((!resLeft) && resRight) 
        return resRight; 
    return NULL; 
}


