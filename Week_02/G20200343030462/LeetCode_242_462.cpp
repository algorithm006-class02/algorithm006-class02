class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size())
            return false;
        std::sort(s.begin(),s.end());
        std::sort(t.begin(),t.end());
        return s == t;
    }
};

class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size())
            return false;
        int arrIntStatistics[26] = {0};          //保存统计结果
        for(int iIndex = 0; iIndex < s.size(); ++iIndex)        //这里字符串求大小的操作时间复杂度是O(1)
        {
            ++arrIntStatistics[s[iIndex] - 'a'];
            --arrIntStatistics[t[iIndex] - 'a'];
        }
        
        //如果是异位词，那么arrIntStatistics位置上每一个元素的值都应该是0
        for(int iLoop = 0; iLoop < 26; ++iLoop)
        {
            if(arrIntStatistics[iLoop] != 0)
                return false;
        }
        
        return true;
    }
};
