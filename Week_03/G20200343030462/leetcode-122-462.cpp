class Solution {
public:
    //使用贪心算法求解
    int maxProfit(vector<int>& prices) {
        int iProfit = 0;
        //循环变量初始值为1，因为假设prices的大小为1，那么按照规则，你要么当天买入当天卖出，要么不买卖，这样利润都是0
        for(int i = 1; i < prices.size();++i)
        {
            if(prices[i] > prices[i - 1])
            {
                iProfit += (prices[i] - prices[i-1]);
            }
        }
        return iProfit;
    }
};
