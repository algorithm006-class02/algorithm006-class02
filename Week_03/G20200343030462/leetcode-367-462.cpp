class Solution {
public:
    //用二分查找法求解，如果num是一个完全平方数的话，那么num = x^2
    bool isPerfectSquare(int num) {
        if(num < 2)
            return true;
        
        long iLeft = 2;		//
        long iRight = num / 2 ;   //num = x ^2，那么x一定是在[2,num/2]之间的，因为x^2 = x *x，且num < 2的情况一开始就已经处理了，它不可能有小于2的情形
        long iMid = 0;
        long iGuess = 0;
        while(iLeft <= iRight)
        {
            iMid = iLeft + (iRight - iLeft) / 2;
            iGuess = iMid * iMid;
            if(num == iGuess)
                return true;
            if(num < iGuess)
                iRight = iMid - 1;
            else
                iLeft = iMid + 1;
        }
        return false;
    }
};
