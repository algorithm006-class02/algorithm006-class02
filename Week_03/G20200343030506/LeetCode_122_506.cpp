/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        //快慢指针标记
        int i=0,j=1,sum=0;
        //判断vector大小
        if(prices.size()<=1)
        return 0;
        
        //两个指针一直紧挨在一起，只有j的值大于i的值时，就把差值加入sum中
        while(j<prices.size()){
            if(prices[j]-prices[i]>0)
                sum+=(prices[j]-prices[i]);

                i++;
                j++;
        }
        return sum;
    }
};
// @lc code=end

