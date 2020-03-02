package week03;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 */
public class LeetCode_121_564 {
    public static void main(String[] args) {
        LeetCode_121_564 leetCode = new LeetCode_121_564();
        System.out.println(leetCode.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(leetCode.maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(leetCode.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(leetCode.maxProfit2(new int[]{7,6,4,3,1}));
    }

    /**
     * 暴力法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) max = prices[j] - prices[i];
            }
        }
        return max;
    }

    /**
     * 一次循环
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    /**
     * 一次循环优化
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int pri: prices) {
            min = Math.min(min, pri);
            max = Math.max(max, pri - min);
        }
        return max;
    }
}
