//22
//https://leetcode-cn.com/problems/generate-parentheses

class Solution {
public:
    void recursion(string s, int left, int right, vector<string>& res){
        if (left == 0 && right == 0) {
            res.push_back(s);
            return;
        }
        if (left > 0) 
            recursion(s + "(", left - 1, right + 1, res);
        if (right > 0)
            recursion(s + ")", left, right - 1, res);
        return;
    }
    
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        recursion("", n, 0, res);
        return res;
    }
};
