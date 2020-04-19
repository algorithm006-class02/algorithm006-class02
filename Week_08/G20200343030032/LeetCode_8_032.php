<?php

class Solution
{

    /**
     * 字符串转整数
     * @param String $str
     * @return Integer
     */
    function myAtoi($str)
    {
        preg_match('/^[\+\-]?\d+/', ltrim($str), $m);
        return empty($m) ? 0 : max(-pow(2, 31), min((int)$m[0], pow(2, 31) - 1));
    }

    function myAtoi2($str)
    {
        $index = $total = 0;
        if ($str == '')
            return $total;

        $len = strlen($str);
        while ($str[$index] === ' ' && $index < $len)
            $index++;

        $sign = 1;
        if ($str[$index] == '-' || $str[$index] == '+') {
            $sign = $str[$index] == '+' ? 1 : -1;
            $index++;
        }

        while ($index < $len) {
            $num = intval($str[$index]);
            if ($num < 0 || $num > 9 || ($num == 0 && $str[$index] != '0')) break;
            $total = 10 * $total + $num;
            $index++;
        }

        return max(-pow(2, 31), min($total * $sign, pow(2, 31) - 1));
    }
}