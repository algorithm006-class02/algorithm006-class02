class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        //使用滑动窗口的思路
        int left = 0, right = 0;
        int match = 0;
        unordered_map<char,int> window;
        unordered_map<char,int> needs;
        
        for ( const auto & c : p )
            ++needs[c];
        vector<int> result;
        while ( right < s.size() )
        {
            char c = s[right];
            if ( needs.count(c) )
            {
                ++window[c];
                if ( window[c] == needs[c] )
                    ++match;
            }
            ++right;
            
            while ( match == needs.size() )
            {
                if ( right - left == p.size() )
                {
                    result.push_back(left);
                }
                
                char c1 = s[left];
                if ( needs.count(c1) )
                {
                    --window[c1];
                    if ( window[c1] < needs[c1] )
                        --match;
                }
                
                ++left;
            }
        }
        return result;
    }
};
