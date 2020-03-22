import java.util.Arrays;

/**
 * @author : Hyuk
 * @description : LeetCode_322_536
 * @date : 2020/3/14 8:10 下午
 */
public class LeetCode_322_536 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) { return -1; }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new LeetCode_322_536().coinChange(coins, 11));
    }
}
