class Solution {
public:
    bool isIsomorphic(string s, string t) {
        vector<char> map_s(128, (char)0);
        vector<char> map_t(128, (char)0);
        for (int i = 0; i < s.length(); i++) {
            int idx_s = (int)s[i];
            if (map_s[idx_s] == (char)0) {
                map_s[idx_s] = t[i];
            } else if (map_s[idx_s] != t[i]) {
                return false;
            }
            int idx_t = (int)t[i];
            if (map_t[idx_t] == (char)0) {
                map_t[idx_t] = s[i];
            } else if (map_t[idx_t] != s[i]) {
                return false;
            }
        }
        return true;
    }
};
