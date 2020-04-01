class Solution {
public:
    string reverseWords(string s) {
        auto beg = s.begin();
        for(auto iter = s.begin(); iter != s.end(); ++iter)
        {
            //单词和单词之间用空格分隔
            if ( ' ' == *iter )
            {
                reverse(beg,iter);
                beg = iter + 1;
            }
        }
        //处理最后一个单词，如果有的话
        reverse(beg,s.end());
        return s;
    }
};
