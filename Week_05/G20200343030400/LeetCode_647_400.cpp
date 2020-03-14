class Solution {
public:
    int countSubstrings(string s) {
        int res = 0;
        int size = s.length();
        vector<vector<bool>> isPalindromic(size, vector<bool>(size, false));
        for (int j = 0; j < size; j++) {                     
            for (int i = j; i >= 0; i--) {
                isPalindromic[i][j] = (s[i] == s[j]) && ((j - i) <= 2 || isPalindromic[i + 1][j - 1]);
                if (isPalindromic[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
};
