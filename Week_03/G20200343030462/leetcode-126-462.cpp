class Solution {
public:
    //广度优先搜索解决，这个算法，你要理解的话，需要手动构造出搜索树（图）然后走一遍代码才能想明白
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        std::unordered_set<std::string> unsetWordList{wordList.begin(),wordList.end()};
        if(unsetWordList.end() == unsetWordList.find(endWord))
            return {};
        
        std::unordered_set<std::string> unsetVisited;       //记录每一层已经被访问过的结点
        int iLevel = 1; //搜索树（图）的层号，搜索起始点编号为1层
        int iMinLevel = INT_MAX;        //找到目标endWord时的层号
        
        std::queue<std::vector<std::string>> quePaths;  //queue里的元素记录的是找到endWord时搜索过的所有结点，它的数目恰好是当前层的层号
        quePaths.push({beginWord});
        std::vector<std::vector<std::string>> vecAns;   //最后的答案
        
        while(!quePaths.empty())
        {
            auto path = quePaths.front();
            quePaths.pop();
            if(path.size() > iLevel)  //此处不可取等，取大于表示已经处理到了下一层，而iLevel此时还是path.size()的上一层，当找到目标的时候，path.size()刚好要大于iMinLevel，它能覆盖到所有的搜索路径，但是如果取等就不一定可以覆盖所有搜索路径了（还是要把搜索树（图）画出来来理解）
            {
                //进入下一层
                for(auto const &word : unsetVisited)
                {
                    //将上一层遍历时已经访问过的结点从单词字典中删除
                    unsetWordList.erase(word);
                }
                unsetVisited.clear();
                //这说明已经找到了endWord
                if(path.size() > iMinLevel)
                    break;
                else
                    iLevel = path.size();
            }
           
            
            //取出当前正在处理的搜索路径上的最后一个单词，也就是当前层上要处理的单词
            std::string strLast = path.back();
            for(int iIndex = 0 ; iIndex < strLast.size(); ++iIndex)
            {
                char c = strLast[iIndex];
                for(char a = 'a'; a <= 'z'; ++a)
                {
                    if(c == a)
                        continue;
                    strLast[iIndex] = a;
                    if(unsetWordList.end() != unsetWordList.find(strLast))
                    {
                        //说明这是一个合法的中间状态
                        
                        unsetVisited.insert(strLast);
                        std::vector<std::string> vecNewPath = path;
                        vecNewPath.push_back(strLast);
                        
                        if(endWord == strLast)
                        {
                            //说明已经找到要找的目标了
                            iMinLevel = iLevel;
                            vecAns.push_back(vecNewPath);
                        }
                        else
                            quePaths.push(vecNewPath);
                    }
                }
                strLast[iIndex] = c;
            }
        }
        return vecAns;
    }
};
