//买卖股票时机，贪心算法
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int amount=0;
        for (int i=1; i<prices.size(); i++) {
            if (prices[i]>prices[i-1]) {
                amount += prices[i]-prices[i-1];
            }
        }
        return amount;
    }
};