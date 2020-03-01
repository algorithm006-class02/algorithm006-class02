class Solution {
public:
    //利用二分查找求解
    int search(vector<int>& nums, int target) {
        int iLeft = 0, iRight = nums.size() - 1, iMid = 0;
        while(iLeft <= iRight)
        {
            iMid = iLeft + (iRight - iLeft) / 2;
            if(target == nums[iMid])
                return iMid;
            //然后看被iMid拆分成两部分的那个半区间是有序的
            if(nums[iLeft] <= nums[iMid])
            {
                //说明左半区间有序，取等是要考虑左右边界target >= nums[iLeft],target< nums[iMid] 这里不取等是因为如果相等的话，循环其实就已经退出了
                if(target >= nums[iLeft] && target< nums[iMid])
                {
                    //说明target在这个半区间里
                    iRight = iMid -1;
                }
                else
                    iLeft = iMid + 1;       //说明要在无序的那个半区间里找target
            }
            else
            {
                //否则右半区间有序，不存在两个半区间都无序的情况，target <= nums[iRight]取等是要考虑左右边界
                if(target > nums[iMid] && target <= nums[iRight])  
                    iLeft = iMid + 1;
                else
                    iRight = iMid - 1;
            }
        }
        return -1;
    }
};
