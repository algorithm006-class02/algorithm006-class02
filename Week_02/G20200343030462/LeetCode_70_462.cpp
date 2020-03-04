class Solution {
public:
    vector<string> generateParenthesis(int n) {
        std::vector<std::string> vecRet;
        std::string str;
        generateParenthesis(0,0,n,vecRet,str);
        return vecRet;
    }
private:
    //参数iLeft记录的是左括号的个数，参数iRight记录的是右括号的个数，参数iTotal记录的是括号的对数，参数vecRet保存的是返回结果，str中保存的是每次生成的一个合法的括号
    void generateParenthesis(int iLeft,int iRight,const int iTotal,std::vector<std::string> &vecRet,std::string str)
    {
        //递归终止条件----任何递归函数没有递归终止条件就会成为死循环
        if(iTotal == iLeft && iTotal == iRight)
        {
            vecRet.push_back(str);
            return;
        }
        //先处理左括号，左括号的个数不大于n
        if(iLeft < iTotal)
            generateParenthesis(iLeft + 1,iRight,iTotal,vecRet,str + "(");
        //从最后生成的字符串来看，右括号不能出现在首位，这意味着当你要插入右括号的时候，右括号的数目是要比左括号的小的
        if(iRight < iLeft)
            generateParenthesis(iLeft,iRight + 1,iTotal,vecRet,str + ")");
    }
};

class Solution {
public:
    //根据题目可以分析出这是一个求斐波那契数列的算法题，但是不一样的是我们不需要解出斐波那契数列中的每一个值，斐波那契数列的递推公式是f(n) = f(n - 1) + f(n - 2)
    int climbStairs(int n) {
        if(n <= 2)
            return n;
        int iMethods1 = 1;
        int iMethods2 = 2;
        int iMethods3 = 0;
        for(int i = 3; i <= n; ++i)
        {
            iMethods3 = iMethods1 + iMethods2;
            iMethods1 = iMethods2;
            iMethods2 = iMethods3;
        }
        return iMethods3;
    }
};
