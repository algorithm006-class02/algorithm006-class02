class Solution {
public:
    int mySqrt(int x) {
        if( 0 == x || 1 == x)
            return x;
        
        //x的平方根肯定是在[1,x]之间的
        long iLeft = 1;
        long iRight = x;
        long iMid = 1;
        while(iLeft <= iRight)
        {
            iMid = iLeft + (iRight - iLeft) / 2;
            if(iMid * iMid > x)
                iRight = iMid -1;
            else
                iLeft = iMid + 1;
        }
        
        return (int)iRight;
    }
};
