/**
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
}; 
int getIndex(int *data, int size, int key) {
    for (int i = 0; i < size; i++) {
        if (key == data[i]) 
            return i; 
    }
    return -1; 
}
/**
 * 二叉树的前序遍历：root->leftTree->rightTree; 二叉树的中序遍历：leftTree->root->rightTree; 
 * 通过前序遍历确定root，然后在中序遍历中找到root所在位置，root前面的为左子树，后面的为右子树
 * 递归处理左子树和右子树，结束条件为待处理的前序数组和中序数组为空。
 */
struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize) {
    if ((!preorder && !inorder) || ((0 == preorderSize) && (0 == inorderSize))) 
        return NULL; 
    int mid = 0; 
    struct TreeNode *rootNode = calloc(1, sizeof(struct TreeNode)); 
    rootNode->val = preorder[0]; 
    mid = getIndex(inorder, inorderSize, rootNode->val); 
    rootNode->left = buildTree(preorder + 1, mid, inorder, mid); 
    rootNode->right = buildTree(preorder + mid + 1, preorderSize - mid - 1, inorder + mid + 1, inorderSize - mid - 1); 
    return rootNode; 
}


