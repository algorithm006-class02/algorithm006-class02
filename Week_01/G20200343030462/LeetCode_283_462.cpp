#include <vector>
class Solution {
public:
    //时间复杂度是O(n)
    void moveZeroes(std::vector<int>& nums) {
        int iSentry = 0;        //哨兵，它始终标记的是非零元素可以被存储的位置，
        //Step1.先处理非零元素
        for(int iLoop = 0; iLoop < nums.size(); ++iLoop)
        {
            if(nums[iLoop] != 0)
            {
                nums[iSentry] = nums[iLoop];
                ++iSentry;
            }
        }
        
        //Step.2将iSentry及以后的位置都置为零
        for(;iSentry < nums.size(); ++iSentry)
        {
            nums[iSentry] = 0;
        }
    }
};
