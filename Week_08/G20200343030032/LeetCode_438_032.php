<?php

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 */
class Solution
{

    /**
     * 滑动窗口法
     * @param String $s
     * @param String $p
     * @return Integer[]
     */
    function findAnagrams($s, $p)
    {
        $match = $left = $right = 0;
        $lenP = strlen($p);
        $lenS = strlen($s);
        $need = $window = $res = [];
        for ($i = 0; $i < $lenP; $i++) {
            $need[$p[$i]] = isset($need[$p[$i]]) ? $need[$p[$i]]++  : 1;
            $window[$p[$i]] = 0;
        }

        while ($right < $lenS) {
            $c = $s[$right];
            if (isset($need[$c])) {
                $window[$c]++;
                if ($window[$c] == $need[$c])
                    $match++;
            }
            $right++;

            while ($match == count($need)) {
                // 如果window大小合适，就把其实索引left加入结果
                if ($right - $left == $lenP) {
                    $res[] = $left;
                }
                $c2 = $s[$left];
                if (isset($need[$c2])) {
                    $window[$c2]--;
                    if ($window[$c2] < $need[$c2]) {
                        $match--;
                    }
                }
                $left++;
            }
        }
        return $res;
    }
}
