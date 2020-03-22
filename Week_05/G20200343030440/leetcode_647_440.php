<?php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function countSubstrings($s) {
        $n = strlen($s); 
        $ans = 0;
        for ($center = 0; $center <= 2*$n-1; ++$center) {
            $left = $center / 2;
            $right = $left + $center % 2;
            while ($left >= 0 && $right < $n && substr($s, $left,1) == substr($s, $right,1)) {
                $ans++;
                $left--;
                $right++;
            }
        }
        return $ans;
    }
}
