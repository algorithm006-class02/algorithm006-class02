
/*
 * @lc app=leetcode.cn id=557 lang=cpp
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
public:
    string reverseWords(string s) {
        string res="";
        stack<char> sk;
        for(int c:s){
            if(c==' '){
                while(!sk.empty()){
                    res +=sk.top();
                    sk.pop();
                }
                res +=' ';
            }
            else sk.push(c);
        }
        while(!sk.empty()){
            res +=sk.top();
            sk.pop();
        } 
        return res;
    }
};
// @lc code=end

