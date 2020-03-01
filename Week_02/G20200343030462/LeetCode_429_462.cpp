class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        int iLevels = 0;
        std::vector<std::vector<int>> vecRet;
        levelOrder(root,iLevels,vecRet);
        return vecRet;
    }
private:
    void levelOrder(const Node *pCurrNode,int iLevels,std::vector<std::vector<int>> &vecRet)
    {
        if(!pCurrNode)
            return;
        if(iLevels == vecRet.size())
            vecRet.emplace_back();
        vecRet[iLevels].push_back(pCurrNode->val);
        for(int i = 0; i < pCurrNode->children.size(); ++i)
        {
            levelOrder(pCurrNode->children[i],iLevels+1,vecRet);
        }
    }
};

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(nullptr == root)
            return {};
        int iLevels = 0;
        std::queue<Node*> queNode;
        std::vector<std::vector<int>> vecRet;
        queNode.push(root);
        while(!queNode.empty())
        {
            vecRet.emplace_back();
            int iSizePerLevel = queNode.size();
            for(int i = 0; i < iSizePerLevel; ++i)
            {
                Node *pTmp = queNode.front();
                vecRet[iLevels].push_back(pTmp->val);
                queNode.pop();
                for(int i = 0; i < pTmp->children.size(); ++i)
                {
                    queNode.push(pTmp->children[i]);
                }
            }
            ++iLevels;
        }
        return vecRet;
    }
};

