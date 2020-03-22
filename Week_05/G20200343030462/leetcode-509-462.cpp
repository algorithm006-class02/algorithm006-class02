lass Solution {
public:
    //动态规划
    int fib(int N) {
        std::vector<long> midResult(N + 1,0);        //动态规划存储中间结果的数组
        return fib(N,midResult);
    }
private:
    int fib(int N,std::vector<int> &midResult)
    {
        if(N <= 1)
            return N;
        //如果该位置上是0，说明这个f(n)还没有被计算过，因为斐波那契数列的特殊性，所以如果f(n)被计算了的话，那么midResult[N]不会等于0,（唯一有可能等0的情况，N==0的时候被作为递归终止条件了，它也不可能出现在这里的判断中，能走到这里来，N至少都是2）
        if(0 == midResult[N])       
            midResult[N] = fib(N - 1,midResult) + fib(N - 2,midResult);
        return midResult[N];
    }
};
