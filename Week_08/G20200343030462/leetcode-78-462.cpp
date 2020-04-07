class Solution {
public:
    string minWindow(string s, string t) {
        int start = 0;      //最小覆盖子字符串的起始位置
        int minSubStrLen = INT_MAX;     //最小覆盖子串的长度
        int left = 0, right = 0;        //滑动窗口[left,right] 的起点和终点位置
        unordered_map<char,int> window;     //统计在滑动窗口[left,right]中出字符出现的次数，key是字符，value是该字符出现的次数
        unordered_map<char,int> needs;      //统计字符串t中每个字符出现的次数
        int match = 0;          //统计[left,right]中出现的字符和needs中的出现的字符总共匹配了多少次，对这个值有一个细微的处理
        
        for ( const auto & alphabet : t )
            ++needs[alphabet];
        
        while ( right < s.size() )
        {
            char c = s[right];
            if ( needs.count(c) )
            {
                ++window[c];
                //如果滑动窗口中的字符和t中的对应字符统计值完全一致，说明已经匹配了一次
                //小于的话，说明次数不够，还没有匹配上
                //大于的话，说明已经匹配过了，就不要重复加了
                if ( window[c] == needs[c] )
                    ++match;
            }
            ++right;        //移动窗口
            
            //说明[left,right]区间里已经有了符合条件的字符串，然后增大left，缩小滑动窗口，寻找在[left,right]里最小的那个子串
            while ( needs.size() == match )
            {
                if ( right - left < minSubStrLen )
                {
                    minSubStrLen = right - left;
                    start = left;
                }
                
                char c1 = s[left];
                if ( needs.count(c) )
                {
                    --window[c1];
                    if ( window[c1] < needs[c1] )
                        --match;
                }
                ++left;
            }
        }
        return minSubStrLen == INT_MAX ? "" : s.substr(start,minSubStrLen);
    }
};
