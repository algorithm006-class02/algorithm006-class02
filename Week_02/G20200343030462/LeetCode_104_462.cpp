class Solution {
public:
    //解法一：迭代法
    int maxDepth(TreeNode* root) {
        if(nullptr == root)
            return 0;
        int iLevels = 0;
        std:queue<TreeNode*> queNode;
        queNode.push(root);
        while(!queNode.empty())
        {
            int iSizePerLevel = queNode.size();
            for(int i = 0; i < iSizePerLevel; ++i)
            {
                TreeNode *pTmpNode = queNode.front();
                if(pTmpNode->left)		//层序遍历一定要注意这个条件
                    queNode.push(pTmpNode->left);
                if(pTmpNode->right)
                    queNode.push(pTmpNode->right);  //层序遍历一定要注意这个条件
                queNode.pop();
            }
            ++iLevels;
        }
        return iLevels;
    }
};

class Solution {
public:
    //解法一：迭代法
    int maxDepth(TreeNode* root) {
        if(nullptr == root)
            return 0;
        int iLeftTreeHeight = 0;
        int iRightTreeHeight = 0;
        iLeftTreeHeight = maxDepth(root->left);
        iRightTreeHeight = maxDepth(root->right);
        return (iLeftTreeHeight > iRightTreeHeight ? iLeftTreeHeight : iRightTreeHeight) + 1; 
    }
};
