class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(nullptr == root)
            return {};
        std::vector<std::vector<int>> vecRet;
        helper(root,0,vecRet);
        return vecRet;
    }
private:
    //参数：pCurrNode：当前要处理的结点
    //参数：iLevel：树的层号，从0开始编号，否则算法会执行错误
    //参数：vecRet：保存最终的结果的
    void helper(const TreeNode *pCurrNode,int iLevel,std::vector<std::vector<int>> &vecRet)
    {
        if(!pCurrNode)  //如果为空，则说明这个方向上已经遍历完了
            return;
        if(iLevel == vecRet.size())         //这个地方要理解好，递归的解法，iLevel在走完左子树后走右子树的时候iLevel会有一个回溯的情况，这是一个关键步骤
            vecRet.emplace_back();
        vecRet[iLevel].push_back(pCurrNode->val);
        //这个地方不要加if(!pCurrNode->left)这样的判断，原因的话，你可以画一个只有3个结点的完全二叉树走一遍代码，这是和前中后序不同的
        helper(pCurrNode->left,iLevel + 1,vecRet);
        helper(pCurrNode->right,iLevel + 1,vecRet);     //当做左子树的递归返回后，右子树上的递归其iLevel的初始值从0开始，不理解的话可以画个递归栈思考一下
    }
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(nullptr == root)
            return {};
        int iLevels = 0;
        std::queue<TreeNode*> queNode;
        std::vector<std::vector<int>> vecRet;   //返回结果
        queNode.push(root);
        //外层循环，这个树有多少层就执行多少次
        while(!queNode.empty())
        {
            vecRet.emplace_back();
            int iSizePerLevel = queNode.size();         //当前层一共有多少个元素，注意它一定是在内层for循环开始之前进行，因为内层for循环里会添加元素，添加完以后，队列里包含的就不再仅是当前层的元素了，而是还会包含下一层的元素
            for(int i = 0; i < iSizePerLevel; ++i)
            {
                //遍历当前层的所有元素
                TreeNode *pCurrNode = queNode.front();      //层序遍历，用队列的话是一个先进先出的关系
                //如果当前正在处理的结点有孩子结点，就把它加入队列
                if(pCurrNode->left)
                    queNode.push(pCurrNode->left);
                if(pCurrNode->right)
                    queNode.push(pCurrNode->right);
                    
                vecRet[iLevels].push_back(pCurrNode->val);
                queNode.pop();
                //内层for循环处理完以后，队列中应该只剩余当前层的下一层的所有结点
            }
            ++iLevels;
        }
        return vecRet;
    }
};
