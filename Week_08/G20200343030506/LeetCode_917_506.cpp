/*
 * @lc app=leetcode.cn id=917 lang=cpp
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
public:
    string reverseOnlyLetters(string S) {
        int begin = 0;
        int end = S.size()-1;
        while(begin <= end)
        {
            if(!isalpha(S[begin]))
                begin++;
            else if(!isalpha(S[end]))
                end--;
            else if(isalpha(S[begin]) && isalpha(S[end]))
            {
                swap(S[begin], S[end]);
                begin++;
                end--;
            }
        }  
        return S;      
    }
};
// @lc code=end

