class Solution {
public:
    //利用上下界来解答此题
    bool isValidBST(TreeNode* root) {
        return isValidBST(root,LONG_MIN,LONG_MAX);
    }
private:
    //pCurrNode是当前要处理的结点，lLower：当前遍历树的下界；lUpper：当前遍历树的上界；上下界类型为long的原因是，结点的数据类型值为int，结点的数据值完全有可能是int的极限，而我们的上下界不能喝这个极限值相同，不然可能会出现错误
    bool isValidBST(const TreeNode* pCurrNode,long lLower,long lUpper)
    {
        //空树也是二叉搜索树
        if(!pCurrNode)
            return true;
        int iRootEle = pCurrNode->val;
        if (iRootEle <= lLower || iRootEle >= lUpper)
            return false;
        return isValidBST(pCurrNode->left,lLower,pCurrNode->val) && isValidBST(pCurrNode->right,pCurrNode->val,lUpper);		//返回值一定要这么写的原因是，你必须确保左右子树都是二叉搜索树才能保证整棵树是二叉搜索树
    }
};

class Solution {
public:
    //使用中序遍历的方法来解答此题
    bool isValidBST(TreeNode* root) {
        if(!root)
            return true;
        if(!isValidBST(root->left)) return false;
        if(m_pPreNode != nullptr && root->val <= m_pPreNode->val) return false;
        m_pPreNode = root;
        if(!isValidBST(root->right)) return false;
        return true;
    }
private:
    TreeNode *m_pPreNode{nullptr};
};

class Solution {
public:
    //使用迭代的方法来实现中序遍历，利用中序遍历的方法来求解此题
    bool isValidBST(TreeNode* root) {
        if(!root)
            return true;
        std::stack<TreeNode *> stackTmp;       //用来存储已经遍历过的结点的值
        TreeNode *pCurrNode = root;     //当前正在被访问的结点
        TreeNode *pPreNode = nullptr;
        while(nullptr != pCurrNode || false == stackTmp.empty())
        {
            //从当前结点开始，沿着左子树一撸到底，直到结点的left指针为nullptr，将途中经过的每一个结点都保存到stackTmp这个栈里，这样，当这个内部的while循环结束的时候，存在栈顶的一定是左叶子或者是没有左叶子的根。
            while(nullptr != pCurrNode)
            {
                stackTmp.push(pCurrNode);
                pCurrNode = pCurrNode->left;
            }
            
            pCurrNode = stackTmp.top();
            if(nullptr != pPreNode && pPreNode->val >= pCurrNode->val)
                return false;
            pPreNode = pCurrNode;
            pCurrNode = pCurrNode->right;
            stackTmp.pop();
        }
        return true;
    }
};
