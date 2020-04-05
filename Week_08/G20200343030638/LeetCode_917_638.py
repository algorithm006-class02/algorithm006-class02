class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        n = len(S)
        S = list(S)
        l, r = 0, n - 1
        while l < r:
            if S[l].isalpha() and S[r].isalpha():
                S[l], S[r] = S[r], S[l]
                l += 1
                r -= 1
            elif not S[r].isalpha():
                r -= 1
            elif not S[l].isalpha():
                l += 1

        return "".join(S)