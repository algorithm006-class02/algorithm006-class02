class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 1)
            return nums[0];
        int iLeft = 0;
        int iRight = nums.size() - 1;
        //说明没有被旋转
        if(nums[iRight] > nums[0])
            return nums[0];
        while(iLeft <= iRight)
        {
            int iMid = iLeft + (iRight - iLeft) / 2;
            if(nums[iMid] > nums[iMid + 1])
                return nums[iMid + 1];      //最小数
            if(nums[iMid] < nums[iMid - 1])
                return nums[iMid];      //最小数
            if(nums[iMid] > nums[0])
                iLeft = iMid + 1;       //说明最小数在右侧
            else
                iRight = iMid - 1;      //说明最小数在左侧
        }
        return -1;
    }
};
