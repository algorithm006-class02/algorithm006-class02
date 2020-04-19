class Solution {
public:
    bool isPalindrome(string s) {
        //第一步，去掉字符串s中的所有非数字和非字母的字符，并将统一大小写
        if ( s.empty() )
            return true;
        string tmp;
        for ( int i = 0; i < s.size(); ++i )
        {
            if ( isdigit(s[i]) || islower(s[i]) )
                tmp.push_back(s[i]);
            else if ( isupper(s[i]) )
                tmp.push_back( tolower(s[i]) );
        }
        
        //第二步，验证是否是回文字符串
        for ( int i = 0,j = tmp.size() - 1; i < j; ++i, --j)
        {
            if ( tmp[i] != tmp[j] )
                return false;
        }
        
        return true;
    }
};
