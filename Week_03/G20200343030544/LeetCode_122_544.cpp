class Solution {
public:
    int maxProfit(std::vector<int>& prices) {
        if (prices.size()==0) {
            return 0;
        }
        int price = 0;
        int temp = prices[0];
        for (int i=1; i < prices.size(); i++) {
            if (temp < prices[i]) {
                price += (prices[i] - temp);
            }
            temp = prices[i];
        }
        return price;
    }
};
