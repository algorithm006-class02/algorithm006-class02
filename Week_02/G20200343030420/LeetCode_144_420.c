/**
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
} ; 
void _preorderRecursion(struct TreeNode *root, int *out, int *size) {
    if (NULL != root) {
        out[(*size)++] = root->val; 
        _preorderRecursion(root->left, out, size); 
        _preorderRecursion(root->right, out, size); 
    }    
}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* preorderTraversal(struct TreeNode* root, int* returnSize) {
    if (NULL == root) 
        return NULL; 
    int *res = calloc(1024, sizeof(int)); 
    *returnSize = 0; 
    _preorderRecursion(root, res, returnSize); 
    return res; 
}
typedef struct _TreeNodeStack {
    int top; 
    struct TreeNode** node; 
} TreeNodeStack; 
/**
 * 二叉树前序遍历：root->leftTree->rightTree.
 * 借助栈，初始先将root压入栈。循环取栈顶元素，该元素即为局部子树的root，
 * 先访问它，然后将它的right压入栈，再将它的left压入栈，重复循环过程，直至栈空。
 */ 
int* preorderTraversal_2(struct TreeNode* root, int* returnSize) {
    if (NULL == root) 
        return NULL; 
    int *res = calloc(1024, sizeof(int));  
    struct TreeNode* node; 
    TreeNodeStack myStack; 
    myStack.top = -1; 
    myStack.node = calloc(1024, sizeof(struct TreeNode*)); 
    *returnSize = 0; 
    myStack.node[++myStack.top] = root; 
    while (-1 != myStack.top) {
        node = myStack.node[myStack.top--];
        res[(*returnSize)++] = node->val; 
        if (node->right) 
            myStack.node[++myStack.top] = node->right; 
        if (node->left) 
            myStack.node[++myStack.top] = node->left; 
    } 
    free(myStack.node); 
    return res; 
}


