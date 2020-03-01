class Solution {
public:
    vector<int> preorder(Node* root) {
        std::vector<int> vecRet;
        preorder(root,vecRet);
        return vecRet;
    }
private:
    void preorder(const Node *pCurrNode,std::vector<int> &vecRet)
    {
        if(!pCurrNode)
            return;
        vecRet.push_back(pCurrNode->val);
        for(int i = 0; i < pCurrNode->children.size(); ++i)
        {
            if(pCurrNode->children[i])
                preorder(pCurrNode->children[i],vecRet);
        }
    }
};

class Solution {
public:
    vector<int> preorder(Node* root) {
        if(nullptr == root)
            return {};
        std::stack<Node*> stackTmp;
        std::vector<int> vecRet;
        stackTmp.push(root);
        while(!stackTmp.empty())
        {
            Node *pCurrNode = stackTmp.top();
            stackTmp.pop();			//pop一定是在内层的for循环之前调用
            vecRet.push_back(pCurrNode->val);
            std::reverse(pCurrNode->children.begin(),pCurrNode->children.end());        //翻转
            for(int i = 0; i < pCurrNode->children.size(); ++i)
            {
                stackTmp.push(pCurrNode->children[i]);
            }
        }
        return vecRet;
    }
};
