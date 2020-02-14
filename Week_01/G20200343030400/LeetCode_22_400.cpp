//22
//https://leetcode-cn.com/problems/generate-parentheses

class Solution {
public:
    void recursion(string temp, int left_possible, int right_possible, vector<string>& ans) {
        if (left_possible == 0 && right_possible == 0)
            ans.push_back(temp);
        if (left_possible > 0)
            recursion(temp + "(", left_possible - 1, right_possible + 1, ans);
        if (right_possible >0) {
            recursion(temp + ")", left_possible, right_possible - 1, ans);
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        recursion("", n, 0, ans);
        return ans;
    }
};
