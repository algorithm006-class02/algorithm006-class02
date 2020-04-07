class Solution {
public:
    bool validPalindrome(string s) {
        for ( int i = 0, j = s.size() - 1; i < j; ++i, --j )
        {
            if ( s[i] != s[j] )
                return validPalindrome(s,i + 1,j) || validPalindrome(s,i,j-1);
            
        }
        return true;
    }
private:
    bool validPalindrome(string s,int i,int j)
    {
        //判断i和j构成的子串是不是一个回文串
        while (i < j)
        {
            if ( s[i++] != s[j--] )
                return false;
        }
        return true;
    }
};
