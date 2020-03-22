class Solution {
public:
    //基于分治的思想求解
    double myPow(double x, int n) {
        long long lN = n;
        if(n < 0)
        {
            x = 1/x;
            lN = -lN;
        }
        return fastPow(x,lN);
    }
    double fastPow(double x,long long n)
    {
        //当大的问题不可再拆分为子问题的时候返回
        if( 0 == n)
            return 1.0;     //因为任何数的0次方都是1
        
        //对子问题求解，这个的子问题就是n的一半指数函数的结果是什么
        double dRet = fastPow(x, n / 2);
        
        //对子问题的答案进行合并，得到原问题的解
        if( 0 == n % 2)
            return dRet * dRet;
        
        return dRet * dRet * x;
    }
};
