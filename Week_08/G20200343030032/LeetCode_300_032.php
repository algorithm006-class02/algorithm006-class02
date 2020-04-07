<?php

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 */
class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function lengthOfLIS($nums)
    {
        $len = count($nums);
        if($len == 0)
            return 0;

        $dp[0] = 1;
        $max = 1;
        for ($i = 1; $i < $len; $i++) {
            $maxval = 0;
            for ($j = 0; $j < $i; $j++) {
                if ($nums[$i] > $nums[$j]) {
                    $maxval = max($maxval, $dp[$j]);
                }
            }
            $dp[$i] = $maxval + 1;
            $max = max($max, $dp[$i]);
        }
        return $max;
    }
}
