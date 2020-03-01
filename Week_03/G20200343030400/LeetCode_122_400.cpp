//122
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profile = 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i - 1] < prices[i]) {
                profile += (prices[i] - prices[i - 1]);
            }
        }
        return profile;
    }
};
