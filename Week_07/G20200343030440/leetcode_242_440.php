<?php
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        if(strlen($s) != strlen($t)) {
             return false;
        }
        $arr_s = str_split($s, 1);
        $arr_t = str_split($t, 1);
        sort($arr_s);
        sort($arr_t);
        $s = implode('',$arr_s);
        $t = implode('', $arr_t);
        $ret = strnatcasecmp($s, $t);
        return empty($ret) ? true : false;
    }
}
