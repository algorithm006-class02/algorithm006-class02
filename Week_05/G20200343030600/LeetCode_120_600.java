/**
 * 三角形最小路径和
 */

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size() + 1];

        for(int i = triangle.size() - 1; i >=0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}