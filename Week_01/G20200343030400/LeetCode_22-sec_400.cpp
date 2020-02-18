//22
//https://leetcode-cn.com/problems/generate-parentheses

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string s = "";
        s.append(n,'(');
        s.append(n,')');
        string s_final = "";
        for (int i = 0; i < n; ++i)
            s_final += "()";

        do {
            if (isWellFormed(s))
                ans.push_back(s);
        } while (next_permutation(s.begin(), s.end()) && s <= s_final);
        return ans;
    }

    bool isWellFormed(string& s){
        int count = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '(')
                ++count;
            else
                --count;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
};
