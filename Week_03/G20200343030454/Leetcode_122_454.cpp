class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxprofit =0;
        int i=0,j=1,temp=0;
        while(j<prices.size()){
            if (prices[i]<prices[j]){
                temp=prices[j]-prices[i];
                maxprofit +=temp;
            }
            j++;
            i++;
        }
        return maxprofit;
    }
};