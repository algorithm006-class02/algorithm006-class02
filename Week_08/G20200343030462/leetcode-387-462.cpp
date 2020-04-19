class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char,int> memo; //key是s的每一个字符，int是这个字符在s中出现的次数
        for ( int i = 0; i < s.size(); ++i )
            ++memo[s[i]];
        
        for ( int i = 0; i < s.size(); ++i )
        {
            if ( 1 == memo[s[i]] )
                return i;
        }
        return -1;
    }
};
