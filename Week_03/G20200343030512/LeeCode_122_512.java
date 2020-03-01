package Week_03.G20200343030512;

class Solution122 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;

        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0)max+=prices[i]-prices[i-1];
        }
        return max;
    }
}