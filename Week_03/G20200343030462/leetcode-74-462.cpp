class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if( 0 == m)
            return false;
        int n = matrix[0].size();
        
        int iLeft = 0 ,iRight = m * n -1;
        
        int iMid = 0,iMidEle = 0;
        while(iLeft <= iRight)
        {
            iMid = (iRight + iLeft) / 2;
            int iRow = iMid / n;
            int iCol = iMid % n;
            iMidEle = matrix[iRow][iCol];
            if(target == iMidEle)
                return true;
            if(target < iMidEle)
                iRight = iMid - 1;
            else
                iLeft = iMid + 1;
        }
        return false;
    }
};
