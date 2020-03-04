#!/bin/env python
class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
#        if x < 2: #x 范围跟面试官确认 ,  递增，边界，可索引访问 1,n
#            return x 
#        left = 2
#        right = x // 2
#        while left <= right:
#              mid = left + (right-left) // 2
#              num = mid*mid
#              if num < x:
#                  left = mid+1
#              elif num > x:
#                  right = mid - 1
#              else:
#                  return mid
#        return right
         left, right = 0, x//2
         while left < right :
             mid = left + (right-left)/2
             ret = mid*mid
             if ret == x:
                 return mid
             elif ret < x:
                 left = mid + 1
             else:
                 right = mid - 1
          return left
             




