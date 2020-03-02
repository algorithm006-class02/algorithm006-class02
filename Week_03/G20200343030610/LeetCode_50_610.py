#v1
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1
        elif n > 0:
            return self.__help(x,n)
        else :
            return self.__help(1/x, -n)
    def __help(self,x,n):
         if n == 0:
             return 1
         elif n & 1:
             return x*self.__help(x,n-1)
         else:
             #return self.__help(x*x,n//2)
             return self.__help(x*x,n>>1)
#v1.1  x^2n == x^n * x^n 加速计算过程 可读性
class Solution(object):
    def myPow(self, x, n ):
        N = n
        if N < 0:
            N = -N
            x = 1/x
        return self.fastPow(x,N) #o(logn), O(logn)
   def fastPow(self,x, n):
       if n == 0:
           return 1
       half = fastPow(x, n//2)
       if n & 1:
           return x*half*half
       else:
           return half*half    
      

#v2 暴力 #超出时间限制
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        N = n
        if (N < 0):
            x = 1 /x
            N = -N
        ret = 1 #O(1) k
        for i in xrange(0,N): #O(n）
           ret = ret * x
        return ret
#v3,二分法 olog(n)
def myPow(double x, int n ){
    if n==0:
       return 1
    if n == 1:
       return x
    if n == -1:
       return 1/x
    half = myPow(x, n//2)
    rest = myPow(x, n%2)
    return rest*half*half    
}

#v4 12ms
def myPow(x, n):
    if n == 0 :
        return 1
    if n < 0 :
        n = -n
        x = 1/x
    return myPow(x*x, n//2) if n%2 == 0 else x*myPow(x*x, n//2)

#v5 5ms
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        x = float(x)
        if n<0:
            n = -n
            x = 1/x
        ans = 1
        while n:
            if n%2!=0:
                n -= 1
                ans *= x
            else:
                x *= x
                n /= 2
        return ans


           
