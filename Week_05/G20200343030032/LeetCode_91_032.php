<?php

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：A-Z 分别对应1-26，给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
class Solution
{

    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s)
    {
        $len = strlen($s);
        if ($s[0] == '0') return 0;
        $pre = 1;
        $curr = 1;
        for ($i = 1; $i < $len; $i++) {
            $tmp = $curr;
            if ($s[$i] == '0') {
                if ($s[$i - 1] == '1' || $s[$i - 1] == '2') {
                    $curr = $pre;// 0 不可编码，保持原有
                } else {
                    return 0;// 遇到连续的0，结束编码
                }
            } else if ($s[$i - 1] == '1' || ($s[$i - 1] == '2' && $s[$i] >= '1' && $s[$i] <= '6')) {
                $curr += $pre;
            }
            $pre = $tmp;
        }
        return $curr;
    }
}

$class = new Solution();
$str = '226';
$res = $class->numDecodings($str);
var_dump($res);