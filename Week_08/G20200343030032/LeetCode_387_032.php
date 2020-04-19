<?php

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
class Solution
{

    /**
     * @param String $s
     * @return Integer
     */
    function firstUniqChar($s)
    {
        $len = strlen($s);
        $count = [];
        for ($i = 0; $i < $len; $i++) {
            $count[$s[$i]] = isset($count[$s[$i]]) ? $count[$s[$i]] + 1 : 1;
        }

        foreach ($count as $k => $v) {
            if ($v == 1) {
                for($i = 0; $i < $len; $i++){
                    if($s[$i] == $k) return $i;
                }
            }
        }

        return -1;
    }
}
