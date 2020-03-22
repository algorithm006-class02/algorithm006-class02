<?php
class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {
        $m = count($grid);
        $n = count($grid[0]);
        if ($m <= 0 || $n <= 0) return 0;

        $dp = [];
        $dp[0][0] = $grid[0][0];
        
        for ($i = 1; $i < $m; $i++) {
            $dp[$i][0] = $dp[$i - 1][0] + $grid[$i][0];
        }

        for ($j = 0; $j < $n; $j++) {
            $dp[0][$j] = $dp[0][$j - 1] + $grid[0][$j];
        }

        for ($i = 1; $i < $m; $i++) {
            for ($j = 1; $j < $n; $j++) {
                $dp[$i][$j] = min($dp[$i - 1][$j], $dp[$i][$j - 1]) + $grid[$i][$j];
            }
        }

        return $dp[$m - 1][$n - 1];
    }
}
