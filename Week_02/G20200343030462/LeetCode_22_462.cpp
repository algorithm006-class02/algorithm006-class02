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



