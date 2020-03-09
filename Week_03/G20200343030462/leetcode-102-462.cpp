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
