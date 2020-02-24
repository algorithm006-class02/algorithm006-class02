class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(nullptr == root)
            return root;
        std::queue<TreeNode *> queNode;
        queNode.push(root);
        
        while(!queNode.empty())
        {
            int iSizePerLevel = queNode.size();
            for(int i = 0; i < iSizePerLevel; ++i)
            {
                TreeNode *pCurrNode = queNode.front();
                if(pCurrNode->left)
                    queNode.push(pCurrNode->left);
                if(pCurrNode->right)
                    queNode.push(pCurrNode->right);
                //交换结点
                TreeNode *pTmp = pCurrNode->left;
                pCurrNode->left = pCurrNode->right;
                pCurrNode->right = pTmp;
                queNode.pop();
            }
        }
        return root;
    }
};
