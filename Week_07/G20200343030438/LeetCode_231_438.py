class Solution:
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 0:
            return False
        n = n & (n - 1)
        if n == 0:
            return True
        else:
            return False
