<?php
class Solution {

    /**
     * @param String $s
     * @param Integer $k
     * @return String
     */
    function reverseStr($s, $k) {
        for ($start = 0; $start < strlen($s); $start += 2 * $k) {
            $front = $start;
            $rear = min($start + $k - 1, strlen($s) - 1);
            while ($front < $rear) {
                $tmp = $s[$front];
                $s[$front++] = $s[$rear];
                $s[$rear--] = $tmp;
            }
        }

        return $s;
    }
}
