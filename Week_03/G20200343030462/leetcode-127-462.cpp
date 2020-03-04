class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        std::unordered_set<std::string> unsetList{wordList.begin(),wordList.end()};
        if(unsetList.end() == unsetList.find(endWord))
            return 0;
        std::string strLetter="abcdefghijklmnopqrstuvwxyz";
        std::queue<std::pair<std::string,int>> queNode; 
        queNode.push({beginWord,0});
        while(!queNode.empty())
        {
            auto word = queNode.front();
            if(endWord == word.first)
            {
                ++word.second;      //因为这个题目它把beginWord也算了一次
                return word.second;
            }
            queNode.pop();
            for(int iIndex = 0; iIndex < word.first.size(); ++iIndex)
            {
                char c = word.first[iIndex];        //备份原来的状态
                for(const auto &letter : strLetter)
                {
                    if(letter == c)     //如果当前要进行变化的字符串iIndex位置上的值和letter相同，那么不用变化
                        continue;
                    word.first[iIndex] = letter;
                    if(unsetList.end() == unsetList.find(word.first))
                        continue;
                    queNode.push({word.first,word.second + 1});
                    unsetList.erase(word.first);        //删除已经访问过的结点，以免因为环造成死循环
                }
                word.first[iIndex] = c;         //恢复状态
            }
        }
        return 0;
    }
};
