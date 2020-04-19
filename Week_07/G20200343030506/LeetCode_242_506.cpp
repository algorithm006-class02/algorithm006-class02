/*
 * @lc app=leetcode.cn id=242 lang=cpp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size())
            return false;
            
        int hash[26]={0};       //构建哈希数组
        for(auto n:s)
            hash[n-'a']++;
        for(auto n:t)
            hash[n-'a']--;
        for(int i=0;i<26;i++)
            if(hash[i]!=0)   return false;          //如果两数组不完全相等
        return true;
    }
};
// @lc code=end

