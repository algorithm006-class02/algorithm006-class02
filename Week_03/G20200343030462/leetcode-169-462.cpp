class Solution {
public:
    int majorityElement(vector<int>& nums) {
        return majorityElement(nums,0,nums.size() - 1);
    }
    
private:
    int majorityElement(const std::vector<int> &nums,int iLeft,int iRight)
    {
        //iLeft和iRight相等的时候就说明分治已经把输入数组划分为只有一个元素的了
        if(iLeft == iRight)
            return nums[iLeft];
        
        //划分子问题
        int iMid = (iRight - iLeft) / 2 + iLeft;        //iMid中间元素的位置，如果用减法来求的话，iRight - iLeft得到的是相对于iLeft的偏移量，等价的计算方式是(iRight + iLeft) / 2
        //求左区间的众数
        int iLeftMajorityEle = majorityElement(nums,iLeft,iMid);
        //求右区间的众数
        int iRightMajorityEle = majorityElement(nums,iMid + 1, iRight);
        
        //如果做区间的众数和右区间一致，那么这就是全局的众数
        if(iRightMajorityEle == iLeftMajorityEle)
            return iRightMajorityEle;
        
        //如果不同的话，求左区间众数和右区间众数的计数值，哪个计数更大，哪个就是全局的众数
        int iLeftCount = count(nums,iLeftMajorityEle,iLeft,iMid);
        int iRightCount = count(nums,iRightMajorityEle,iMid + 1,iRight);
        return iLeftCount > iRightCount ? iLeftMajorityEle : iRightMajorityEle;
    }
    
    //统计目标值在nums中[iLeft,iRight]中出现的次数
    int count(const std::vector<int> &nums,int iDst,int iLeft,int iRight)
    {
        int iCount = 0;
        for(int iIndex = iLeft; iIndex <= iRight; ++iIndex)
        {
            if(iDst == nums[iIndex])
                ++iCount;
        }
        return iCount;
    }
};
