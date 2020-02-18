class Solution {
public:
    //根据题目可以分析出这是一个求斐波那契数列的算法题，但是不一样的是我们不需要解出斐波那契数列中的每一个值，斐波那契数列的递推公式是f(n) = f(n - 1) + f(n - 2)
    int climbStairs(int n) {
        if( n <= 2)         //n为1或n为2这两种基本情况
            return n;
        int iMethod1 = 1;   //这个变量记录的相当于递推公式中的f(n - 2)，初始化时给出的是f(1)的结果
        int iMethod2 = 2;   //这个变量记录的相当于递推公式中的f(n - 1)，初始化时给出的是f(2)的结果
        int iMethod3 = 0;   //它相当于f(n)，也是我们最终要的结果
        for(int iLoop = 3; iLoop <= n; ++iLoop)
        {
            iMethod3 = iMethod1 + iMethod2;
            iMethod1 = iMethod2;        //注意赋值顺序
            iMethod2 = iMethod3;
        }
        return iMethod3;
    }
};
