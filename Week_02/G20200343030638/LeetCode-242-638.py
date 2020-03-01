class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if (len(s) != len(t)):
            return False

        dict = {}
        
        for i in s:
            dict[i] = dict.get(i, 0) + 1

        for j in t:
            dict[j] = dict.get(j, 0) - 1
            if dict[j] < 0 :
                return False

        return True 