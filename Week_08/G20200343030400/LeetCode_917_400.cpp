class Solution {
public:
    string reverseOnlyLetters(string S) {
        if (S.size() <= 1)  return S;
        for (int i = 0, j = S.size() - 1; i < j; i++, j--) {
            while (i < S.size() && (S[i] < 'A' || (S[i] > 'Z' && S[i] < 'a'))) i++;
            while (j >=0 && (S[j] < 'A' || (S[j] > 'Z' && S[j] < 'a'))) j--;
            if (i < j) swap(S[i], S[j]);
        }
        return S;
    }
};
