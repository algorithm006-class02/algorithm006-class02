//20
//https://leetcode-cn.com/problems/valid-parentheses

class Solution {
public:
    bool isValid(string s) {
        int len = s.size();
        if (len == 0) return true;
        if (len % 2 == 1) return false; 
        stack<char> stk;
        for (int i = 0; i < len; ++i) {
            if (stk.empty()) {
                stk.push(s[i]);
                continue;
            } else if (s[i] == ')' && stk.top() == '(') {
                stk.pop();
                continue;
            } else if (s[i] == ']' && stk.top() == '[') {
                stk.pop();
                continue;
            } else if (s[i] == '}' && stk.top() == '{') {
                stk.pop();
                continue;
            }
            stk.push(s[i]);
        }
        return stk.empty();
    }
};

class Solution_ascii {
public:
    bool isValid(string s) {
        int len = s.size();
        if (len == 0) return true;
        if (len % 2 == 1) return false;
        stack<char> stk;
        for (int i = 0; i < len; ++i) {
            if (stk.empty()) {
                stk.push(s[i]);
                continue;
            } else if (s[i] - stk.top() <= 2 && s[i] - stk.top() >= 1) {   //ascii
                stk.pop();
                continue;
            }
            stk.push(s[i]);
        }
        return stk.empty();
    }
};
