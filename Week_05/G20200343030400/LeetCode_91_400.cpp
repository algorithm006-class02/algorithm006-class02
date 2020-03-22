class Solution {
public:
    int numDecodings(string s) {
        int pre = 1;
        int cur = ('0' == s[0]) ? 0 : 1;
        int next = cur;
        for (int i = 1; i < s.length(); i++) {
            next = ('0' != s[i]) ? cur : 0;
            if ('1' == s[i - 1] || ('2' == s[i - 1] && '6' >= s[i])) {
                next += pre;
            }
            pre = cur;
            cur = next;
        }
        return cur;
    }
};
