/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if ( !matrix.size()||!matrix[0].size() ) {
            return false;
        }
        int l,r,mid;
        int m=matrix.size();
        int n=matrix[0].size();

        l=-1,r=m;
        while(l+1!=r){
            mid=l+(r-l)/2;
            if(matrix[mid][0]==target)return true;
            else if(matrix[mid][0]>target){
                r=mid;
            }
            else{
                l=mid;
            }
        }
        int index=l;
        //cout<<index<<endl;
        if(index<0)return false;
        int l2,r2,mid2;
        l2=-1,r2=n;
        while(l2+1!=r2){
            mid2=l2+(r2-l2)/2;
            if(matrix[index][mid2]==target)return true;
            else if(matrix[index][mid2]>target){
                r2=mid2;
            }
            else{
                l2=mid2;
            }
        }
        return false;
    }
};

// @lc code=end

