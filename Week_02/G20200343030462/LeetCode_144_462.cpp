class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if(nullptr == root)
            return {};
        std::vector<int> vecRet;
        preorderTraversal(root,vecRet);
        return vecRet;
    }
private:
    void preorderTraversal(const TreeNode *root,std::vector<int> &vecRet)
    {
        //递归终止条件
        if(nullptr == root)    
            return;
        vecRet.push_back(root->val);
        if(nullptr != root->left)
            preorderTraversal(root->left,vecRet);
        if(nullptr != root->right)
            preorderTraversal(root->right,vecRet);
    }
};

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if(nullptr == root)
            return {};
        //借助栈来完成二叉树前序遍历的非递归实现
        std::stack<TreeNode*> stackTmp;       //和中序遍历不同，前序遍历中这个栈是用来做回溯使用的，栈不空，说明还有结点要处理
        std::vector<int> vecRet;
        TreeNode *pCurrNode = root;
        while(pCurrNode != nullptr || false == stackTmp.empty())
        {
            //从根结点开始，对左子树一撸到底，如果root等于null，那么要么是访问了一个左子树为空但右子树不为空的结点，要么是遍历到了根结点
            while(pCurrNode != nullptr)
            {
                stackTmp.push(pCurrNode);
                vecRet.push_back(pCurrNode->val);
                pCurrNode = pCurrNode->left;
            }
            pCurrNode = stackTmp.top();
            pCurrNode = pCurrNode->right;
            stackTmp.pop();
        }
        return vecRet;
    }
};
