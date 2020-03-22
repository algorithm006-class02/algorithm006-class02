<?php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s) {
        $len = strlen($s);
        $dp = [];

        $dp[$len] = 1;
        if ($s[$len - 1] != 0) $dp[$len - 1] = 1;

        for ($i = $len - 2; $i >= 0; $i--) {
            if ($s[$i] == 0) continue;

            if ($s[$i] * 10 + $s[$i + 1] <= 26) {
                $dp[$i] = $dp[$i + 1] + $dp[$i + 2];
            } else {
                $dp[$i] = $dp[$i + 1];
            }
        }

        return !isset($dp[0]) ? 0 : $dp[0];
    }
}
