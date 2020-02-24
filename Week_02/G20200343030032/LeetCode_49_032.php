<?php

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution
{

    /**
     * 解法一：使用排序后的字符串做键名，源字符串做键值进行归类
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs)
    {
        $res = [];
        foreach ($strs as $v) {
            // 利用内部函数生成key
            // $key = json_encode(count_chars($v, 1));

            // 自定义生成key
            $split = str_split($v, 1);
            sort($split);
            $key = implode('', $split);
            $res[$key][] = $v;
        }
        return array_values($res);
    }
}