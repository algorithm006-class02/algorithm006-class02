class Solution {
public:
    int maxProduct(vector<int>& nums) {
        //这个题目和最大子序的不同在于对负数的处理，负数乘以最大数将会使最大数变成最小数，乘以最小数会使最小数变成最大数，所以需要记录下最大和最小数
        int subMax = 1; //初始值取1，是因为1乘以任何数都是1
        int subMin = 1;
        int max = INT_MIN;	//初始值，确保在nums只有一个元素且该元素为负数的时候结果正确
        for(auto num : nums)
        {
            if(num < 0)
            {
                int tmp = subMax;
                subMax = subMin;
                subMin = tmp;
            }
            
            subMax = subMax * num > num ? subMax * num : num;
            subMin = subMin * num < num ? subMin * num : num;
            max = subMax > max ? subMax : max;
        }
        
        return max;
    }
};
