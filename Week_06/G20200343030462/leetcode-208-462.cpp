class Trie {
private:
    bool m_isEnd;        //是否是单词的结尾
    Trie *nodes[26];    //保存结点
public:
    /** Initialize your data structure here. */
    Trie()
    {
        m_isEnd = false;
        memset(nodes,0x0,sizeof(nodes));
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *currentNode = this;
        for(auto c : word)
        {
            if(NULL == currentNode->nodes[c-'a'])
                currentNode->nodes[c - 'a'] = new Trie();
            currentNode = currentNode->nodes[c - 'a'];     //向下一层移动
        }
        currentNode->m_isEnd = true;       //到了字符串结尾
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie *currentNode = this;
        for(auto c : word)
        {
            currentNode = currentNode->nodes[c - 'a'];
            if(nullptr == currentNode)
                return false;
            
        }
        
        return currentNode->m_isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *currentNode = this;
        for(auto c : prefix)
        {
            currentNode = currentNode->nodes[c - 'a'];
            if(nullptr == currentNode)
                return false;
        }
        
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
