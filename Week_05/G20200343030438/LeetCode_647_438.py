class Solution:
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n=len(s)
        count=0
        for i in range(0,n-1):
            left=i-1
            right=i+1
            while left>=0 and right<n:
                if s[left]==s[right]:
                    count+=1
                    left-=1
                    right+=1
                else:
                    break
            left=i
            right=i+1
            while left>=0 and right<n:
                if s[left]==s[right]:
                    count+=1
                    left-=1
                    right+=1
                else:
                    break
        return count+n