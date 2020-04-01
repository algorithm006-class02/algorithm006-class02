class Solution {
public:
    //使用双指针的办法求解
    string reverseOnlyLetters(string S) {
        int start = 0,end = S.size() - 1;
        while(start < end)
        {
            if(!isalpha(S[start]))
                ++start;
            else if(!isalpha(S[end]))
                --end;
            else if ( isalpha(S[start]) && isalpha(S[end]) )
            {
                swap(S[start],S[end]);
                ++start;
                --end;
            }
        }
        return S;
    }
};
