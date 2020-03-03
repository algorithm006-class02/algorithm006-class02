class Solution {
public:
    vector<int> postorder(Node* root) {
        std::vector<int> vecRet;
        postorder(root,vecRet);
        return vecRet;
    }
private:
    //后序遍历的话就是逻辑上按照从左到右的次序依次访问当前结点的所有孩子结点，最后访问当前结点
    void postorder(const Node *pCurrNode,std::vector<int> &vecRet)
    {
        if(nullptr == pCurrNode)
            return;
        for(int i = 0; i < pCurrNode->children.size(); ++i)
        {
            if(pCurrNode->children[i])
                postorder(pCurrNode->children[i],vecRet);
        }
        vecRet.push_back(pCurrNode->val);
    }
};

class Solution {
public:
    //非递归的解法
    vector<int> postorder(Node* root) {
        if(nullptr == root)
            return {};
        std::stack<Node*> stackTmp;
        stackTmp.push(root);
        std::deque<int> dequeRet;           //存储临时结果的队列
        while(!stackTmp.empty())
        {
            Node *pCurrNode = stackTmp.top();
            dequeRet.push_front(pCurrNode->val);
            stackTmp.pop();
            for(int i = 0; i < pCurrNode->children.size(); ++i)
            {
                if(pCurrNode->children[i])
                    stackTmp.push(pCurrNode->children[i]);
            }
        }
        return {dequeRet.begin(),dequeRet.end()};
    }
};
