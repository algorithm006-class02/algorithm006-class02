/*
 * @lc app=leetcode.cn id=387 lang=cpp
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
public:
    int firstUniqChar(string s) {
        int hash[26]={0};   
        for(char n:s)
            hash[n-'a']++;          //n-'a'，得到该字母在数组中对应的索引
        for(int i=0;i<s.size();i++)
            if(hash[s[i]-'a']==1)       //如果只出现了一次
            return i;
        return -1;
    }
};

// @lc code=end

