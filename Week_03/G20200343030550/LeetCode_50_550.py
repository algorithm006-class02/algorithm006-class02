def myPow(x, n):
    """
    :type x: float
    :type n: int
    :rtype: float
    """
    def halfPow(x, n):
        if n == 0:
            return 1.0

        half = halfPow(x, n/2)

        if n % 2 == 0:
            return half * half
        else:
            return half * half * x
    
    if n < 0:
        x = 1/x
        n = -n

    return halfPow(x, n)
