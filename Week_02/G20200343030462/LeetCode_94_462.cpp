class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        std::vector<int> vecRet;
        helper(root,vecRet);
        return vecRet;
    }
private:
    void helper(TreeNode* root,std::vector<int> &vecRet)
    {
        if(root != nullptr)
        {
            helper(root->left,vecRet);
            vecRet.push_back(root->val);
            helper(root->right,vecRet);
        }
    }
};

class Solution {
public:
    //既然是中序遍历，那么在任何一个子树里第一个被放到结果集vecRet里的一定是左子树的叶子结点
    //理解这个解法的最好方法是自己画出一棵树，看树走代码
    vector<int> inorderTraversal(TreeNode* root) {
        if(nullptr == root)
            return {};
        std::vector<int> vecRet;
        std::stack<TreeNode *> stackTmp;       //用来存储已经遍历过的结点的值
        TreeNode *pCurrNode = root;     //当前正在被访问的结点
        while(nullptr != pCurrNode || false == stackTmp.empty())
        {
            //从当前结点开始，沿着左子树一撸到底，直到结点的left指针为nullptr，将途中经过的每一个结点都保存到stackTmp这个栈里，这样，当这个内部的while循环结束的时候，存在栈顶的一定是左叶子或者是没有左叶子的根。
            while(nullptr != pCurrNode)
            {
                stackTmp.push(pCurrNode);
                pCurrNode = pCurrNode->left;
            }
            
            pCurrNode = stackTmp.top();
            vecRet.push_back(pCurrNode->val);
            pCurrNode = pCurrNode->right;
            stackTmp.pop();
        }
        return vecRet;
    }
};
