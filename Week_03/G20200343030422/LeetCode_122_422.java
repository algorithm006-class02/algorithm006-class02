public class LeetCode_122_422 {
    public int maxProfit(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // 查找下一个最小的值
            while (i < prices.length-1 && prices[i+1] <= prices[i]) {
                i++;
            }
            // 避免"[1]"的死循环
            int min = prices[i++];
            // 查找下一个最大的值
            while (i < prices.length-1 && prices[i+1] >= prices[i]) {
                i++;
            }
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }
}
