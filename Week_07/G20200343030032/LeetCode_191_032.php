<?php
/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */

class Solution
{
    /**
     * @param Integer $n
     * @return Integer
     */
    function hammingWeight($n)
    {
        $bin = decbin($n);
        $len = strlen($bin);
        $count = 0;
        for ($i = 0; $i < $len; $i++) {
            if ($bin[$i] == 1)
                $count++;
        }
        return $count;
    }

    function hammingWeight2($n)
    {
        $count = 0;
        $mask = 1;
        for ($i = 0; $i < 32; $i++) {
            if (($n & $mask) != 0)
                $count++;
            $mask <<= 1;
        }
        return $count;
    }

    function hammingWeight3($n)
    {
        $count = 0;
        while ($n != 0) {
            $count++;
            $n &= ($n - 1);
        }
        return $count;
    }
}
