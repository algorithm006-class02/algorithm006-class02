class Solution {
public:
    string reverseStr(string s, int k) {
        for (string::iterator it = s.begin(); it < s.end(); it += 2 * k)
            if (it + k < s.end()) reverse(it, it + k);
            else reverse(it, s.end());
        return s;
    }
};