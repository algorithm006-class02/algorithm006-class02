struct TrieNode
{
    unordered_map<char,TrieNode*>   m_Node; //key：char，value：下一层的指针
    string m_strNodeValue;                  //结点的值
    bool m_bWord{false};                    //此结点上有没有保存单词
};

class Trie
{
private:
    TrieNode *root{nullptr};
public:
    Trie():root(new TrieNode()){};
    ~Trie()
    {
        if(!root)
        {
            delete root;
            root = nullptr;
        }
    }
    
    //插入一个单词
    void insert(const string &word)
    {
        TrieNode *currNode = root;
        for(const auto &alahabet : word)
        {
            //检查当前字母是不是已经存在了
            if(currNode->m_Node.end() == currNode->m_Node.find(alahabet))
            {
                currNode->m_Node[alahabet] = new TrieNode();
            }
            //跳到下一层
            currNode = currNode->m_Node[alahabet];
        }
        currNode->m_strNodeValue = word;
        currNode->m_bWord = true;
    }
    
    //搜索
    void search(vector<vector<char>> &board,vector<string> &result)
    {
        for(int i = 0; i < board.size(); ++i)
            for(int j = 0; j < board[i].size(); ++j)
                dfs(board,result,root,i,j);
    }
    
    void dfs(vector<vector<char>> &board,vector<string> &result,TrieNode *node,int row,int col)
    {
        if(nullptr == node)
            return;
        if(true == node->m_bWord)
        {
            result.push_back(node->m_strNodeValue);
            node->m_bWord = false;      //这个单词已经被搜索过了就不用找了
            return;
        }
        
        //检查边界
        if( 0 > row || 0 > col || row >= board.size() || col >= board[row].size() )
            return;
        
        //在DFS搜索路径上减枝
        if(node->m_Node.find(board[row][col]) == node->m_Node.end())
            return;
        
        //开始使用回溯进行单词搜索
        char c = board[row][col];
        //if( '#' == c )            这已经包含在 if(node->m_Node.find(board[row][col]) == node->m_Node.end())里了
        //    return;
        node = node->m_Node[c]; //当前层处理完了，跳到下一层
        board[row][col] = '#';      //表示这个位置上已经搜索过了
        dfs(board,result,node,row + 1,col);
        dfs(board,result,node,row - 1,col);
        dfs(board,result,node,row,col + 1);
        dfs(board,result,node,row,col - 1);
        board[row][col] = c;        //恢复状态
    }
};

class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie trieTree;
        vector<string> result;
        for(const auto &word : words)
        {
            trieTree.insert(word);
        }
        trieTree.search(board,result);
        return result;
    }
};
