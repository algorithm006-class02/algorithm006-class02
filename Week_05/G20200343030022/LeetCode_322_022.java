import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 19:25 2020/3/14
 * @Description：
 */
public class LeetCode_322_022 {

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        LeetCode_322_022 l = new LeetCode_322_022();
        l.coinChange(coins, 3);
        System.out.println("haha");
    }

    /**
     * dfs 超出内存因为是深度遍历
     */
    List<List<Integer>> res = new ArrayList();

    public int coinChange(int[] coins, int amount) {
        if(coins == null){
            return -1;
        }
        helper(0,new ArrayList(),coins,amount);
        return res.size() == 0 ? -1 : res.get(0).size() ;
    }

    public void helper(int level,List<Integer> list,int[] coins,int amount){
        if(amount == 0){
            res.add(new ArrayList(list));
            return;
        }
        if(amount < 0){
            return;
        }
        for(int i = coins.length - 1 ;i >= 0 ;i--){
            list.add(coins[i]);
            helper(level++,list,coins,amount-coins[i]);
            list.remove(list.size() - 1);
        }
    }


    /**
     * 方法二：动态规划 自顶向上
     * 每层找到最小的值
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    /**
     * 第三种方法 自低向上
     *  F(i)为组成金额 ii 所需最少的硬币数量
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
