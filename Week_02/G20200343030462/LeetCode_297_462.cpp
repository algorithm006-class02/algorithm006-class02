class Codec {
public:

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data.empty())
            return nullptr;
        std::stringstream ss(data);
        TreeNode *pRoot = nullptr;
        rebuild(pRoot,ss);
        return pRoot;
    }

    // Encodes a tree to a single string.
    //序列化的时候使用前序遍历，根结点用#表示，结点之间用空格做标记
    string serialize(TreeNode* root) {
        if(!root)
            return "";
        std::stringstream ss;
        preorder(root,ss);
        return ss.str();
    }
private:
    void preorder(const TreeNode *pCurrNode,std::stringstream &ss)
    {
        if(!pCurrNode)
        {
            //空节点给特殊标记#，结点之间使用空格隔开
            ss << "# ";
            return;
        }
        
        ss << std::to_string(pCurrNode->val) << " ";
        preorder(pCurrNode->left,ss);
        preorder(pCurrNode->right,ss);
    }
    
    void rebuild(TreeNode *&pCurrNode,std::stringstream &ss)
    {
        std::string strValue;
        ss >> strValue;
        if("#" == strValue)
        {
            pCurrNode = nullptr;
            return;
        }
        
        pCurrNode = new TreeNode(stoi(strValue));
        //重建左树
        rebuild(pCurrNode->left,ss);
        rebuild(pCurrNode->right,ss);
    }
};
