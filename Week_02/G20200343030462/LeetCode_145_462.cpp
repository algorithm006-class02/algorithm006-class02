class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        std::vector<int> vecRet;
        postorderTraversal(root,vecRet);
        return vecRet;
    }
private:
    void postorderTraversal(const TreeNode* node,std::vector<int> &vecRet)
    {
        //递归终止条件
        if(nullptr == node)
            return;
        if(nullptr != node->left)
            postorderTraversal(node->left,vecRet);
        if(nullptr != node->right)
            postorderTraversal(node->right,vecRet);
        vecRet.push_back(node->val);
    }
};

class Solution {
public:
    //非递归的实现
    vector<int> postorderTraversal(TreeNode* root) {
        if(nullptr == root)
            return {};
        TreeNode *pCurrNode = root;             //当前正在被处理的结点
        std::stack<TreeNode*> stackTmp;         //辅助栈
        std::deque<int> dequeRet;                 //存储最终结果的队列
        stackTmp.push(pCurrNode);
        while(!stackTmp.empty())
        {
            pCurrNode = stackTmp.top();
            dequeRet.push_front(pCurrNode->val);
            stackTmp.pop();
            if(pCurrNode->left)
                stackTmp.push(pCurrNode->left);
            if(pCurrNode->right)
                stackTmp.push(pCurrNode->right);
        }
        return {dequeRet.begin(),dequeRet.end()};
    }
};
