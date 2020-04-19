#include <algorithm>
class Solution {
public:
    string reverseStr(string s, int k) {
        for ( int i = 0; i < s.size(); i = i + 2 * k )
        {
            //每个块都是从2k开始的，
            int start = i;
            int end = std::min((start + k - 1),static_cast<int>((s.size() - 1)));
            while ( start < end )
            {
                char c = s[start];
                s[start++] = s[end];
                s[end--] = c;
            }
            
        }
        return s;
    }
};
