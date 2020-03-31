class Solution {
public:
    string reverseStr(string s, int k) {
        int size = s.size();
        int idx = 0;
        bool flip = true;
        while (idx < size) {
            if (flip) {
                int range = min(k, size - idx);
                for (int i = 0; i < range / 2; i++) {
                    swap(s[idx + i], s[idx + range - 1 - i]);
                }
            }
            flip = !flip;
            idx += k;
        }
        return s;
    }
};
